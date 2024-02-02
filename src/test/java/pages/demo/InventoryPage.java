package pages.demo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.DriverManager;

public class InventoryPage {

	private static String pageTitle = "inventory";

	private static WebDriver driver;
	private static WebDriverWait wait;

	public InventoryPage() {
		driver = DriverManager.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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
