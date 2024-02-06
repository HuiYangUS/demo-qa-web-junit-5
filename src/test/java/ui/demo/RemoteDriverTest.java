package ui.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import utilities.RemoteDriverFactory;

@Disabled
public class RemoteDriverTest {

	private static WebDriver driver;

	@BeforeEach
	void setUp() {
		driver = RemoteDriverFactory.getDriver();
	}

	@AfterEach
	void tearDown() {
		RemoteDriverFactory.reset();
	}

	@Test
	void runTest() {
		System.out.println(driver.toString().replaceAll("[(].*[)]", ""));
	}

}
