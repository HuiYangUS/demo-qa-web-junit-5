package ui.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.WebDriver;

import utilities.Browser;
import utilities.DriverFactory;

public class DateDrivenTest {

	@DisplayName("Multiple Browsers Test")
	@ParameterizedTest
	@EnumSource(Browser.class)
	void multipleBrowsersTest(Browser browser) {
		System.setProperty("browser", browser.name().toLowerCase());
		WebDriver driver = DriverFactory.getDriver();
		System.out.println(driver.toString().replaceAll("[(].*[)]", ""));
	}

	@AfterEach
	void tearDown() {
		DriverFactory.reset();
	}

}
