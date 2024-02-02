package ui.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverInfo;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverInfo;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.safari.SafariDriverInfo;

public class DriverDataTest {

	@Test
	void safariDriverInfoTest() {
		SafariDriverInfo driverInfo = new SafariDriverInfo();
		System.out.println(driverInfo.getDisplayName());
		System.out.println(driverInfo.isPresent());
		System.out.println(driverInfo.isAvailable());
	}

	@Test
	void systemFirefoxDriverDataTest() {
		GeckoDriverInfo driverInfo = new GeckoDriverInfo();
		assertTrue(driverInfo.isPresent() && driverInfo.isAvailable(), "Driver is not present or available.");
		FirefoxDriver driver = new FirefoxDriver();
		configDriver(driver);
		Map<?, ?> data = driver.getCapabilities().asMap();
		printDriverData(data);
		shutDown(driver);
	}

	@Test
	void localFirefoxDriverDataTest() {
		GeckoDriverInfo driverInfo = new GeckoDriverInfo();
		assertTrue(driverInfo.isPresent() && driverInfo.isAvailable(), "Driver is not present or available.");
		FirefoxDriver driver = new FirefoxDriver(new GeckoDriverService.Builder()
				.usingDriverExecutable(new File("src/test/resources/drivers/firefoxdriver/geckodriver.exe")).build());
		configDriver(driver);
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
		EdgeDriverInfo driverInfo = new EdgeDriverInfo();
		assertTrue(driverInfo.isPresent() && driverInfo.isAvailable(), "Driver is not present or available.");
		EdgeDriver driver = new EdgeDriver();
		configDriver(driver);
		Map<?, ?> data = driver.getCapabilities().asMap();
		printDriverData(data);
		shutDown(driver);
	}

	@Test
	void localEdgeDriverDataTest() {
		EdgeDriverInfo driverInfo = new EdgeDriverInfo();
		assertTrue(driverInfo.isPresent() && driverInfo.isAvailable(), "Driver is not present or available.");
		EdgeDriver driver = new EdgeDriver(new EdgeDriverService.Builder()
				.usingDriverExecutable(new File("src/test/resources/drivers/edgedriver/msedgedriver.exe")).build());
		configDriver(driver);
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
		ChromeDriverInfo driverInfo = new ChromeDriverInfo();
		assertTrue(driverInfo.isPresent() && driverInfo.isAvailable(), "Driver is not present or available.");
		ChromeDriver driver = new ChromeDriver();
		configDriver(driver);
		Map<?, ?> data = driver.getCapabilities().asMap();
		printDriverData(data);
		shutDown(driver);
	}

	@Test
	void localChromeDriverDataTest() {
		ChromeDriverInfo driverInfo = new ChromeDriverInfo();
		assertTrue(driverInfo.isPresent() && driverInfo.isAvailable(), "Driver is not present or available.");
		ChromeDriver driver = new ChromeDriver(new ChromeDriverService.Builder()
				.usingDriverExecutable(new File("src/test/resources/drivers/chromedriver/chromedriver.exe")).build());
		configDriver(driver);
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

	private static void configDriver(WebDriver driver) {
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
