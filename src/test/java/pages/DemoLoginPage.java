package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DriverManager;
import utils.TestConfigReader;

public class DemoLoginPage {

    private static String fileName = "demo";

    private WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public DemoLoginPage() {
	driver = DriverManager.getDriver();
	PageFactory.initElements(driver, this);
    }

    public void loadPage() {
	driver.navigate().to(TestConfigReader.getValue(fileName, "url"));
    }

    public void enterUsername(String username) {
	usernameInput.sendKeys(TestConfigReader.getValue(fileName, username));
    }

    public void enterPassword(String password) {
	passwordInput.sendKeys(TestConfigReader.getValue(fileName, password));
    }

    public String getPasswordValue() {
	String data = passwordInput.getDomAttribute("value");
	return data;
    }

    public void submitLogin() {
	loginButton.submit();
    }

}
