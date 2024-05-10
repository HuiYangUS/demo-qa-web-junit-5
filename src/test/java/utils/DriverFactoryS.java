package utils;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;

/**
 * This <DriverFactoryS> class uses Selenium-4. Drivers are updated manually in
 * "drivers" folder under "resources" package.
 */
public class DriverFactoryS {

	private static ThreadLocal<DriverFactoryS> localDriverFactory;

	private WebDriver driver;
	private String browser = TestUtils.getTestConfigBrowserName();
	private boolean headless = TestConfigsReader.getBooleanValue("config", "headless");
	private String deviceName = TestConfigsReader.getTextValue("config", "deviceName");
	private boolean isSet;
	private int waitTime = 5;

	private DriverFactoryS() {
		// WARN: Nothing should be written here.
	}

	public static DriverFactoryS getInstance() {
		if (localDriverFactory == null)
			localDriverFactory = new ThreadLocal<DriverFactoryS>();
		if (localDriverFactory.get() == null)
			localDriverFactory.set(new DriverFactoryS());
		return localDriverFactory.get();
	}

	private void setupDriver() {
		if (System.getProperty(TestKeys.BROWSER_KEY) != null)
			browser = System.getProperty(TestKeys.BROWSER_KEY).toLowerCase();
		if (System.getProperty(TestKeys.HEADLESS_KEY) != null)
			headless = Boolean.valueOf(System.getProperty(TestKeys.HEADLESS_KEY).toLowerCase());
		if (System.getProperty(TestKeys.DEVICE_NAME_KEY) != null)
			deviceName = System.getProperty(TestKeys.DEVICE_NAME_KEY);
		isSet = true;
	}

	public void setupDriver(String browser) {
		this.browser = browser;
	}

	public void setupDriver(boolean headless) {
		this.headless = headless;
	}

	public void setupDriver(String browser, boolean headless) {
		this.browser = browser;
		this.headless = headless;
	}

	public WebDriver getDriver() {
		if (!isSet)
			setupDriver();
		if (driver == null)
			initDriver();
		return driver;
	}

	public static void reset() {
		if (localDriverFactory.get().driver != null)
			localDriverFactory.get().driver.quit();
		if (localDriverFactory != null && localDriverFactory.get() != null)
			localDriverFactory.remove();
	}

	private void configDriver(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
	}

	private void initDriver() {
		switch (browser) {
		case "chrome":
			String chromeDriverPath = getDriverDir() + "/chromedriver/chromedriver"
					+ (TestUtils.isWindows() ? ".exe" : "");
			ChromeDriverService service = new ChromeDriverService.Builder()
					.usingDriverExecutable(new File(chromeDriverPath)).build();
			ChromeOptions options = new ChromeOptions();
			setChromeOptions(options);
			driver = new ChromeDriver(service, options);
			break;
		case "firefox":
			String firefoxDriverPath = getDriverDir() + "/firefoxdriver/geckodriver"
					+ (TestUtils.isWindows() ? ".exe" : "");
			FirefoxDriverService firefoxService = new GeckoDriverService.Builder()
					.usingDriverExecutable(new File(firefoxDriverPath)).build();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			setFirefoxOptions(firefoxOptions);
			driver = new FirefoxDriver(firefoxService, firefoxOptions);
			break;
		default:
			throw new RuntimeException("No such browser in the system.");
		}
		if (driver != null)
			System.out.println(driver.toString().replaceAll("[(].*[)]", ""));
		configDriver(driver);
	}

	/**
	 * Set specific conditions of <Chrome> for this application
	 */
	private void setChromeOptions(ChromeOptions chromeOptions) {
		useChromeForTest(chromeOptions);
		if (TestConfigsReader.getBooleanValue("config", "guest"))
			chromeOptions.addArguments("--guest");
		emulateChromeIfMobile(chromeOptions);
		if (headless) {
			chromeOptions.addArguments("--headless=new");
			chromeOptions.addArguments("--user-agent=" + AppConfigsReader.getValue("config", "chromeUserAgent"));
		}
	}

	private void useChromeForTest(ChromeOptions options) {
		String testChromeUserDataPath = TestConfigsReader.getTextValue("config", "testChromeUserDataPath");
		if (testChromeUserDataPath != null) {
			options.addArguments(String.format("--user-data-dir=%s", testChromeUserDataPath));
			options.addArguments(String.format("--profile-directory=%s",
					TestConfigsReader.getTextValue("config", "testChromeProfile")));
		}
		options.setBinary(TestConfigsReader.getTextValue("config", "testChromeBinPath"));
	}

	/**
	 * Change web view from desktop to either tablet or phone
	 */
	private void emulateChromeIfMobile(ChromeOptions chromeOptions) {
		if (deviceName != null) {
			Map<String, String> mobileEmulation = new HashMap<>();
			mobileEmulation.put("deviceName", deviceName);
			chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
		}
	}

	/**
	 * Set specific conditions of <Firefox> for this application
	 */
	private void setFirefoxOptions(FirefoxOptions firefoxOptions) {
		firefoxOptions.addPreference("geo.enabled", false); // Turn off geographical locator
		useFirefoxProfile(firefoxOptions);
		String firefoxBinPath = TestConfigsReader.getTextValue("config", "firefoxProfilePath");
		if (firefoxBinPath != null)
			firefoxOptions.setBinary(firefoxBinPath);
		if (headless)
			firefoxOptions.addArguments("-headless");
	}

	private void useFirefoxProfile(FirefoxOptions firefoxOptions) {
		String firefoxProfilePath = TestConfigsReader.getTextValue("config", "firefoxProfilePath");
		if (firefoxProfilePath != null)
			firefoxOptions.addArguments("-profile", TestConfigsReader.getTextValue("config", firefoxProfilePath));
	}

	/**
	 * Local drivers location
	 */
	private static String getDriverDir() {
		String dirPathName = null;
		if (TestUtils.isMac() && System.getProperty("os.arch").equalsIgnoreCase("x86_64"))
			dirPathName = "mac/intel";
		else if (TestUtils.isMac() && System.getProperty("os.arch").equalsIgnoreCase("aarch64"))
			dirPathName = "mac/m-chip";
		else if (TestUtils.isWindows())
			dirPathName = "win";
		else if (TestUtils.isLinux())
			dirPathName = "linux";
		if (dirPathName == null)
			throw new RuntimeException("Failed to locate a valid directory for the driver.");
		return TestUtils.getCurrentDir() + "/src/test/resources/drivers/" + dirPathName;
	}

}
