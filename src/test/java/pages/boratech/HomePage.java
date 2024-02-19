package pages.boratech;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ConfigReader;
import utilities.DriverManager;

public class HomePage {

	private static String fileName = "boratech";

	private static WebDriver driver;
	private static WebDriverWait wait;

	@FindBy(xpath = "//a[@href='/apply']")
	private static WebElement applyTopBar;

	public HomePage() {
		driver = DriverManager.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}

	public void loadPage() {
		driver.navigate().to(ConfigReader.getValue(fileName, "url"));
	}

	public void toApplyPage() {
		applyTopBar.click();
		wait.until(ExpectedConditions.urlContains("/apply"));
	}

}
