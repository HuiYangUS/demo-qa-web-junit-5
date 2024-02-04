package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.safari.SafariDriver;

/*
 * JUnit-5 "DriverFactory" class that uses Selenium-4
 */
public class DriverFactory {

	private static ThreadLocal<WebDriver> localDriver;
	private static final String BROWSER_KEY = "browser";

	private static String browser = "default";
	private static boolean headless = false;
	private static int waitTime = 5;

	private DriverFactory() {
	}

	private static void setUpDriver() {
		if (System.getProperty(BROWSER_KEY) != null)
			browser = System.getProperty(BROWSER_KEY).strip().toLowerCase();

		String headlessKey = "headless";
		if (System.getProperty(headlessKey) != null)
			headless = Boolean.valueOf(System.getProperty(headlessKey).strip().toLowerCase());
	}

	public static synchronized WebDriver getDriver() {
		setUpDriver();
		if (localDriver == null)
			localDriver = new ThreadLocal<WebDriver>();
		if (localDriver.get() == null)
			localDriver.set(MyTestUtils.isWindows() ? initLocalDriver() : autoLocalDriver());
		return localDriver.get();
	}

	public static void reset() {
		if (localDriver != null && localDriver.get() != null) {
			localDriver.get().quit();
			localDriver.remove();
		}
		if (System.getProperties().containsKey(BROWSER_KEY))
			System.clearProperty(BROWSER_KEY);
	}

	private static WebDriver initLocalDriver() {
		WebDriver driver;
		switch (browser) {
		case "chrome":
			driver = getDefaultLocalDriver();
			break;
		case "edge":
			EdgeDriverService edgeService = new EdgeDriverService.Builder()
					.usingDriverExecutable(new File(getDriverDir() + "/edgedriver/msedgedriver.exe")).build();
			EdgeOptions edgeOptions = new EdgeOptions();

			Map<String, Object> prefs = new HashMap<>();
			prefs.put("user_experience_metrics.personalization_data_consent_enabled", true);
			edgeOptions.setExperimentalOption("prefs", prefs);
			findEdgeHeadless(edgeOptions);

			driver = new EdgeDriver(edgeService, edgeOptions);
			break;
		case "firefox":
			FirefoxDriverService firefoxService = new GeckoDriverService.Builder()
					.usingDriverExecutable(new File(
							getDriverDir() + "/firefoxdriver/geckodriver" + (MyTestUtils.isWindows() ? ".exe" : "")))
					.build();
			FirefoxOptions firefoxOptions = new FirefoxOptions();

			firefoxOptions.addPreference("geo.enabled", false);
			findFirefoxHeadless(firefoxOptions);

			driver = new FirefoxDriver(firefoxService, firefoxOptions);
			break;
		default:
			System.out.println("No browser is found. Default to chrome.");
			driver = getDefaultLocalDriver();
			break;
		}

		configDriver(driver);
		return driver;
	}

	private static WebDriver autoLocalDriver() {
		System.out.println("Auto driver in use:");
		WebDriver driver;
		switch (browser) {
		case "chrome":
			driver = getAutoLocalDriver();
			break;
		case "edge":
			EdgeOptions edgeOptions = new EdgeOptions();

			Map<String, Object> prefs = new HashMap<>();
			prefs.put("user_experience_metrics.personalization_data_consent_enabled", true);
			edgeOptions.setExperimentalOption("prefs", prefs);
			findEdgeHeadless(edgeOptions);

			driver = new EdgeDriver(edgeOptions);
			break;
		case "firefox":
			FirefoxOptions firefoxOptions = new FirefoxOptions();

			firefoxOptions.addPreference("geo.enabled", false);
			findFirefoxHeadless(firefoxOptions);

			driver = new FirefoxDriver(firefoxOptions);
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		default:
			System.out.println("No browser is found. Default to chrome.");
			driver = getAutoLocalDriver();
			break;
		}

		configDriver(driver);
		return driver;
	}

	private static void configDriver(WebDriver driver) {
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
	}

	private static WebDriver getDefaultLocalDriver() {
		ChromeDriverService service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File(
						getDriverDir() + "/chromedriver/chromedriver" + (MyTestUtils.isWindows() ? ".exe" : "")))
				.build();
		ChromeOptions options = new ChromeOptions();
		findChromeHeadless(options);
		return new ChromeDriver(service, options);
	}

	private static WebDriver getAutoLocalDriver() {
		ChromeOptions options = new ChromeOptions();
		findChromeHeadless(options);
		return new ChromeDriver(options);
	}

	private static void findChromeHeadless(ChromeOptions options) {
		if (headless)
			options.addArguments("--headless");
	}

	private static void findEdgeHeadless(EdgeOptions options) {
		if (headless)
			options.addArguments("--headless");
	}

	private static void findFirefoxHeadless(FirefoxOptions options) {
		if (headless)
			options.addArguments("-headless");
	}

	public static String getDriverDir() {
		String dirPathName = null;
		if (MyTestUtils.isMac() && System.getProperty("os.arch").equalsIgnoreCase("x86_64"))
			dirPathName = "mac/intel";
		else if (MyTestUtils.isMac())
			dirPathName = "mac/m-chip";
		else if (MyTestUtils.isWindows())
			dirPathName = "windows";
		assertNotNull(dirPathName, "Failed to locate a valid directory for the driver.");
		return MyTestUtils.getCurrentDir() + "/src/test/resources/drivers/" + dirPathName;
	}

}
