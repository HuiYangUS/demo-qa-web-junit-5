package pages.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ConfigReader;
import utilities.DriverManager;

public class LoginPage {

	private static String fileName = "config";

	private static WebDriver driver;

	@FindBy(id = "user-name")
	private static WebElement usernameInput;

	@FindBy(id = "password")
	private static WebElement passwordInput;

	@FindBy(id = "login-button")
	private static WebElement loginButton;

	public LoginPage() {
		driver = DriverManager.getDriver();
		PageFactory.initElements(driver, this);
	}

	public void loadPage() {
		driver.navigate().to(ConfigReader.getValue(fileName, "url"));
	}

	public void enterUsername(String username) {
		usernameInput.sendKeys(ConfigReader.getValue(fileName, username));
	}

	public void enterPassword(String password) {
		passwordInput.sendKeys(ConfigReader.getValue(fileName, password));
	}

	public String getPasswordValue() {
		String data = passwordInput.getDomAttribute("value");
		return data;
	}

	public void submitLogin() {
		loginButton.submit();
	}

}
