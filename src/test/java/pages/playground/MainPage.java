package pages.playground;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ConfigReader;
import utilities.DriverManager;

public class MainPage {

	private static String fileName = "playground";
	private static String playgroundURL = ConfigReader.getValue(fileName, "url");

	private static WebDriver driver;
	private static WebDriverWait wait;

	@FindBy(linkText = "Input Form Submit")
	private static WebElement formDemoLink;

	public MainPage() {
		driver = DriverManager.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}

	public void loadPage() {
		driver.navigate().to(playgroundURL);
		wait.until(ExpectedConditions.urlToBe(playgroundURL));
	}

	public void toFormDemo() {
		formDemoLink.click();
		wait.until(ExpectedConditions.urlContains("/input-form-demo"));
	}

}
