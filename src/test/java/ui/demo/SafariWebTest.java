package ui.demo;

import java.io.File;

import org.apache.commons.io.FileUtils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.manager.SeleniumManagerOutput;
import org.openqa.selenium.remote.service.DriverFinder;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariDriverService;
import org.openqa.selenium.safari.SafariOptions;

import utilities.DriverFactory;
import utilities.MyTestUtils;

public class SafariWebTest {

	@Test
	@EnabledOnOs(OS.MAC)
	void independentTest() {
		WebDriver driver = new SafariDriver();
		driver.manage().window().maximize();
		System.out.println(driver.toString());
		driver.navigate().to("https://www.apple.com");
		MyTestUtils.pause(1);
		driver.quit();
	}

	File driverPath;

	void pathFinder() {
		SafariOptions options = new SafariOptions();
		options.setBrowserVersion("stable");
		SeleniumManagerOutput.Result location = DriverFinder.getPath(SafariDriverService.createDefaultService(),
				options);
		driverPath = new File(location.getDriverPath());
		System.out.println(driverPath.getAbsolutePath());
	}

	@Test
	@EnabledOnOs(OS.MAC)
	void runTest() {
		pathFinder();
		SafariDriverService service = new SafariDriverService.Builder().usingDriverExecutable(driverPath).build();
		SafariDriver driver = new SafariDriver(service);
		driver.manage().window().maximize();
		System.out.println(driver.toString());
		MyTestUtils.pause(1);
		driver.quit();
	}

	@Test
	@EnabledOnOs(OS.MAC)
	void localDriverTest() {
		String driverFilePath = "/usr/bin/safaridriver";
		SafariDriverService service = new SafariDriverService.Builder().usingDriverExecutable(new File(driverFilePath))
				.build();
		SafariDriver driver = new SafariDriver(service);
		driver.manage().window().maximize();
		System.out.println(driver.toString());
		MyTestUtils.pause(1);
		driver.quit();
	}

	@Test
	@EnabledOnOs(OS.MAC)
	void localCopyDriverTest() {
		String driverFilePath = "/usr/bin/safaridriver";
		String targetFilePath = "src/test/resources/drivers/mac/intel/safaridriver/safaridriver";
		try {
			File input = new File(driverFilePath);
			FileUtils.copyFile(input, new File(targetFilePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		SafariDriverService service = new SafariDriverService.Builder().usingDriverExecutable(new File(targetFilePath))
				.build();
		SafariDriver driver = new SafariDriver(service);
		driver.manage().window().maximize();
		System.out.println(driver.toString());
		MyTestUtils.pause(1);
		driver.quit();
	}

	@Test
	@EnabledOnOs(OS.MAC)
	void localThreadDriverTest() {
		System.setProperty("browser", "safari");
		WebDriver driver = DriverFactory.getDriver();
		System.out.println(driver.toString());
		MyTestUtils.pause(1);
		DriverFactory.reset();
	}

}
