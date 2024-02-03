package ui.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverInfo;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverInfo;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariDriverInfo;

import utilities.MyTestUtils;

public class AutoDriverTest {

	WebDriver driver;
	String url = "https://junit.org/junit5/docs/current/user-guide/";

	@Test
	void chromeTest() {
		ChromeDriverInfo driverInfo = new ChromeDriverInfo();
		assertTrue(driverInfo.isPresent() && driverInfo.isPresent(), "No driver is found.");
		driver = new ChromeDriver();
		DriverDataTest.configDriver(driver);
		driver.navigate().to(url);
		MyTestUtils.pause(1);
	}

	@Test
	@EnabledOnOs(OS.WINDOWS)
	void edgeTest() {
		EdgeDriverInfo driverInfo = new EdgeDriverInfo();
		assertTrue(driverInfo.isPresent() && driverInfo.isPresent(), "No driver is found.");
		driver = new EdgeDriver();
		DriverDataTest.configDriver(driver);
		driver.navigate().to(url);
		MyTestUtils.pause(1);
	}

	@Test
	void firefoxTest() {
		GeckoDriverInfo driverInfo = new GeckoDriverInfo();
		assertTrue(driverInfo.isPresent() && driverInfo.isPresent(), "No driver is found.");
		driver = new FirefoxDriver();
		DriverDataTest.configDriver(driver);
		driver.navigate().to(url);
		MyTestUtils.pause(1);
	}

	@Test
	@EnabledOnOs(OS.MAC)
	void safariTest() {
		SafariDriverInfo driverInfo = new SafariDriverInfo();
		assertTrue(driverInfo.isPresent() && driverInfo.isPresent(), "No driver is found.");
		driver = new SafariDriver();
		DriverDataTest.configDriver(driver);
		driver.navigate().to(url);
		MyTestUtils.pause(1);
	}

	@AfterEach
	void afterTest() {
		if (driver != null)
			DriverDataTest.shutDown(driver);
	}

}
