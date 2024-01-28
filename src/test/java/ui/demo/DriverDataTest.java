package ui.demo;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverInfo;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

public class DriverDataTest {

	@Test
	void runChromeDriverInfoTest() {
		ChromeDriverInfo driverInfo = new ChromeDriverInfo();
		System.out.println(driverInfo.getDisplayName());
		System.out.println(driverInfo.isPresent());
		System.out.println(driverInfo.isAvailable());
	}

	@Test
	void runFirefoxLogTest() {
		FirefoxDriver driver = new FirefoxDriver();
		driver.setLogLevel(Level.INFO);
		driverConfig(driver);
		shutDown(driver);
	}

	@Test
	void systemFirefoxDriverDataTest() {
		FirefoxDriver driver = new FirefoxDriver();
		driverConfig(driver);
		Map<?, ?> data = driver.getCapabilities().asMap();
		printDriverData(data);
		shutDown(driver);
	}

	@Test
	void localFirefoxDriverDataTest() {
		FirefoxDriver driver = new FirefoxDriver(new GeckoDriverService.Builder()
				.usingDriverExecutable(new File("src/test/resources/drivers/firefoxdriver/geckodriver.exe")).build());
		driverConfig(driver);
		Map<?, ?> data = driver.getCapabilities().asMap();
		System.out.println(String.format("%s: %s", "browserName", driver.getCapabilities().getBrowserName()));
		System.out.println(String.format("%s: %s", "browserVersion", driver.getCapabilities().getBrowserVersion()));
		System.out.println(String.format("%s: %s", "geckodriverVersion", data.get("moz:geckodriverVersion")));
		System.out.println(String.format("%s: %s", "cdpVersion", data.get("se:cdpVersion")));
		System.out.println(
				String.format("%s: %s", "implicitTimeout", ((Map<?, ?>) data.get("timeouts")).get("implicit")));
		shutDown(driver);
	}

	@Test
	void systemEdgeDriverDataTest() {
		EdgeDriver driver = new EdgeDriver();
		driverConfig(driver);
		Map<?, ?> data = driver.getCapabilities().asMap();
		printDriverData(data);
		shutDown(driver);
	}

	@Test
	void localEdgeDriverDataTest() {
		EdgeDriver driver = new EdgeDriver(new EdgeDriverService.Builder()
				.usingDriverExecutable(new File("src/test/resources/drivers/edgedriver/msedgedriver.exe")).build());
		driverConfig(driver);
		Map<?, ?> data = driver.getCapabilities().asMap();
		System.out.println(String.format("%s: %s", "browserName", driver.getCapabilities().getBrowserName()));
		System.out.println(String.format("%s: %s", "browserVersion", driver.getCapabilities().getBrowserVersion()));
		System.out.println(String.format("%s: %s", "msedgedriverVersion", ((Map<?, ?>) data.get("msedge"))
				.get("msedgedriverVersion").toString().replaceAll("[(].*[)]", "").strip()));
		System.out.println(String.format("%s: %s", "cdpVersion", data.get("se:cdpVersion")));
		System.out.println(
				String.format("%s: %s", "implicitTimeout", ((Map<?, ?>) data.get("timeouts")).get("implicit")));
		shutDown(driver);
	}

	@Test
	void systemChromeDriverDataTest() {
		ChromeDriver driver = new ChromeDriver();
		driverConfig(driver);
		Map<?, ?> data = driver.getCapabilities().asMap();
		printDriverData(data);
		shutDown(driver);
	}

	@Test
	void localChromeDriverDataTest() {
		ChromeDriver driver = new ChromeDriver(new ChromeDriverService.Builder()
				.usingDriverExecutable(new File("src/test/resources/drivers/chromedriver/chromedriver.exe")).build());
		driverConfig(driver);
		Map<?, ?> data = driver.getCapabilities().asMap();
		System.out.println(String.format("%s: %s", "browserName", driver.getCapabilities().getBrowserName()));
		System.out.println(String.format("%s: %s", "browserVersion", driver.getCapabilities().getBrowserVersion()));
		System.out.println(String.format("%s: %s", "chromedriverVersion", ((Map<?, ?>) data.get("chrome"))
				.get("chromedriverVersion").toString().replaceAll("[(].*[)]", "").strip()));
		System.out.println(String.format("%s: %s", "cdpVersion", data.get("se:cdpVersion")));
		System.out.println(
				String.format("%s: %s", "implicitTimeout", ((Map<?, ?>) data.get("timeouts")).get("implicit")));
		shutDown(driver);
	}

	private static void driverConfig(WebDriver driver) {
		driver.manage().window().maximize();
	}

	private static void shutDown(WebDriver driver) {
		try {

		} finally {
			driver.quit();
		}
	}

	private static void printDriverData(Map<?, ?> data) {
		for (Entry<?, ?> entry : data.entrySet()) {
			String key = entry.getKey().toString();
			String value = entry.getValue().toString();
			System.out.println(String.format("%s --> %s", key, value));
		}
	}

}
