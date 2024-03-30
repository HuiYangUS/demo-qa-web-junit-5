package ui.mac;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariDriverService;

import utils.AppTestUtils;

/**
 * Use Selenium Manager only
 */
public class SafariWebTest {

    @Test
    @EnabledOnOs(OS.MAC)
    void independentTest() {
	WebDriver driver = new SafariDriver();
	driver.manage().window().maximize();
	System.out.println(driver.toString());
	driver.navigate().to("https://www.apple.com");
	AppTestUtils.pause(1);
	driver.quit();
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void localDriverTest() {
	// Default safari driver location
	String driverFilePath = "/usr/bin/safaridriver";
	SafariDriverService service = new SafariDriverService.Builder().usingDriverExecutable(new File(driverFilePath))
		.build();
	SafariDriver driver = new SafariDriver(service);
	driver.manage().window().maximize();
	System.out.println(driver.toString());
	AppTestUtils.pause(1);
	driver.quit();
    }

}
