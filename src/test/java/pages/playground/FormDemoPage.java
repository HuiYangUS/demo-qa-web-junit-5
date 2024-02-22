package pages.playground;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.DriverManager;

public class FormDemoPage {

	private static WebDriver driver;
	private static WebDriverWait wait;

	@FindBy(id = "name")
	WebElement nameInput;

	@FindBy(css = "form[id='seleniumform'] input[name='email']")
	WebElement emailInput;

	@FindBy(name = "password")
	WebElement passwordInput;

	@FindBy(id = "company")
	WebElement companyInput;

	@FindBy(id = "websitename")
	WebElement websiteInput;

	@FindBy(name = "country")
	WebElement countrySelect;

	@FindBy(id = "inputCity")
	WebElement cityInput;

	@FindBy(id = "inputAddress1")
	WebElement firstAddressInput;

	@FindBy(id = "inputAddress2")
	WebElement secondAddressInput;

	@FindBy(id = "inputState")
	WebElement stateInput;

	@FindBy(id = "inputZip")
	WebElement zipCodeInput;

	@FindBy(css = "form[id='seleniumform'] button[type='submit']")
	WebElement submitButton;

	@FindBy(css = "p.success-msg")
	WebElement successText;

	public FormDemoPage() {
		driver = DriverManager.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}

	public void enterName(String name) {
		nameInput.clear();
		nameInput.sendKeys(name);
		wait.until(ExpectedConditions.attributeToBe(nameInput, "validationMessage", ""));
	}

	public void enterEmail(String email) {
		emailInput.clear();
		emailInput.sendKeys(email);
		wait.until(ExpectedConditions.attributeToBe(emailInput, "validationMessage", ""));
	}

	public void enterPassword(String password) {
		passwordInput.clear();
		passwordInput.sendKeys(password);
		wait.until(ExpectedConditions.attributeToBe(passwordInput, "validationMessage", ""));
	}

	public void enterCompany(String company) {
		companyInput.clear();
		companyInput.sendKeys(company);
		wait.until(ExpectedConditions.attributeToBe(companyInput, "validationMessage", ""));
	}

	public void enterWebsite(String website) {
		websiteInput.clear();
		websiteInput.sendKeys(website);
		wait.until(ExpectedConditions.attributeToBe(websiteInput, "validationMessage", ""));
	}

	public void enterCountry(String countryID) {
		Select countriesSelect = new Select(countrySelect);
		countriesSelect.deselectAll();
		try {
			countriesSelect.selectByValue(countryID);
		} catch (Exception e) {
			assertTrue(false, String.format("<%s> is not a valid country id.", countryID));
		}
	}

	public void enterCity(String city) {
		cityInput.clear();
		cityInput.sendKeys(city);
		wait.until(ExpectedConditions.attributeToBe(cityInput, "validationMessage", ""));
	}

	public void enterFirstAddress(String firstAddres) {
		firstAddressInput.clear();
		firstAddressInput.sendKeys(firstAddres);
		wait.until(ExpectedConditions.attributeToBe(firstAddressInput, "validationMessage", ""));
	}

	public void enterSecondAddress(String secondAddress) {
		secondAddressInput.clear();
		secondAddressInput.sendKeys(secondAddress);
		wait.until(ExpectedConditions.attributeToBe(secondAddressInput, "validationMessage", ""));
	}

	public void enterState(String stateName) {
		stateInput.clear();
		stateInput.sendKeys(stateName);
		wait.until(ExpectedConditions.attributeToBe(stateInput, "validationMessage", ""));
	}

	public void enterZipCode(String zipCode) {
		zipCodeInput.clear();
		zipCodeInput.sendKeys(zipCode);
		wait.until(ExpectedConditions.attributeToBe(zipCodeInput, "validationMessage", ""));
	}

	public void submitForm() {
		submitButton.submit();
	}

	public boolean submissionCheck() {
		try {
			wait.until(ExpectedConditions.visibilityOf(successText));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String getSuccessText() {
		if (submissionCheck())
			return successText.getText();
		return null;
	}

}
