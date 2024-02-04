package ui.demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import utilities.DriverFactory;
import utilities.MyTestUtils;

public class SafariWebTest {

	@Disabled("Driver failed to create a session.")
	@Test
	@EnabledOnOs(OS.MAC)
	void driverTest() {
		System.setProperty("browser", "safari");
		WebDriver driver = DriverFactory.getDriver();
		System.out.println(driver.toString());
		MyTestUtils.pause(1);

		DriverFactory.reset();
	}

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

}
