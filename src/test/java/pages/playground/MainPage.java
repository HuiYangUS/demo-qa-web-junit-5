package pages.playground;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ConfigReader;
import utilities.DriverManager;

public class MainPage {

	private static String fileName = "playground";

	private static WebDriver driver;

	@FindBy(linkText = "Simple Form Demo")
	private static WebElement formDemoText;

	public MainPage() {
		driver = DriverManager.getDriver();
		PageFactory.initElements(driver, this);
	}

	public void loadPage() {
		driver.navigate().to(ConfigReader.getValue(fileName, "url"));
	}

	public boolean isPageLoaded() {
		try {
			return driver.getCurrentUrl().equals(ConfigReader.getValue(fileName, "url"));
		} catch (Exception e) {
			return false;
		}
	}

	public void toFormDemo() {
		if (isPageLoaded())
			formDemoText.click();
	}

}