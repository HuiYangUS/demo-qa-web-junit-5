package ui.base.web;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.DriverFactory;
import utilities.PageManager;

public class WebBase {

	protected static WebDriver driver;
	protected static WebDriverWait wait;

	protected static PageManager pages;

	@BeforeEach
	protected void setUp() throws Exception {
		driver = DriverFactory.getDriver();
		System.out.println(driver.toString().replaceAll("[(].*[)]", "").strip());
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		pages = PageManager.getInstance();
	}

	@AfterEach
	protected void tearDown() {
		DriverFactory.reset();
		PageManager.reset();
	}

}
