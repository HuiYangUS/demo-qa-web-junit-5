package ui.demo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;

import utilities.DriverFactory;
import utilities.AppTestUtils;

public class LocalThreadDriverTest {

	@ParameterizedTest
	@ValueSource(strings = { "chrome", "edge", "firefox" })
	void runTest(String browser) {
		System.setProperty("browser", browser);
		WebDriver driver = DriverFactory.getDriver();
		System.out.println(driver.getWindowHandle() + "\n");
		AppTestUtils.pause(1);
		DriverFactory.reset();
	}

}
