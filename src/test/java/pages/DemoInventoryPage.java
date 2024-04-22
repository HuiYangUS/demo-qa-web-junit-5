package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DriverManager;
import utils.TestConfigsReader;

public class DemoInventoryPage {

	private static String pageTitle = "inventory";

	private WebDriver driver;
	private WebDriverWait wait;

	public DemoInventoryPage() {
		driver = DriverManager.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(TestConfigsReader.getIntNumValue("config", "waitTime")));
	}

	public boolean isLoaded() {
		try {
			wait.until(ExpectedConditions.urlContains("saucedemo"));
			wait.until(ExpectedConditions.urlContains(pageTitle));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
