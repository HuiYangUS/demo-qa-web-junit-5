package pages.boratech;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.DriverManager;
import utilities.MyTestUtils;

public class ApplyPage {

	private static WebDriver driver;
	private static WebDriverWait wait;

	@FindBy(name = "firstname")
	private static WebElement firstNameInput;

	@FindBy(name = "lastname")
	private static WebElement lastNameInput;

	@FindBy(name = "dob")
	private static WebElement dateOfBirthInput;

	// 0 = male, 1 = female, 2 = other
	@FindBy(name = "gender")
	private static List<WebElement> genders;

	@FindBy(name = "email")
	private static WebElement emailInput;

	@FindBy(name = "phonenumber")
	private static WebElement phoneNumberInput;

	@FindBy(name = "course")
	private static WebElement courseElement;

	@FindBy(name = "source")
	private static WebElement sourceElement;

	@FindBy(name = "notarobot")
	private static WebElement robotCheckbox;

	@FindBy(xpath = "//input[@type='submit']")
	private static WebElement submitButton;

	@FindBy(xpath = "//div[@class='alert alert-success']")
	private static WebElement successAlert;

	public ApplyPage() {
		driver = DriverManager.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}

	public void enterFirstName(String firstName) {
		firstNameInput.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		lastNameInput.sendKeys(lastName);
	}

	public void enterDateOfBirth(String dateOfBirth) {
		// month, day, year
		String[] date = dateOfBirth.split("-");
		assertEquals(3, date.length, "Incorrect date format.");
		String year = date[2];
		String month = date[0];
		String dayOfMonth = date[1];
		assertTrue(MyTestUtils.isValidDate(year, month, dayOfMonth), "Invalid date.");
		if (Integer.parseInt(dayOfMonth) < 10)
			dayOfMonth = "0" + Integer.parseInt(dayOfMonth);
		dateOfBirthInput.sendKeys(month + dayOfMonth + year);
	}

	public void enterEmail(String email) {
		emailInput.sendKeys(email);
	}

	public void enterPhoneNumber(String phoneNumber) {
		phoneNumberInput.sendKeys(phoneNumber);
	}

	public void selectGender(int genderOption) {
		assertTrue(genderOption >= 0 && genderOption <= 2, "Invalid gender.");
		genders.get(genderOption).click();
	}

	public void selectCourse(String courseOption) {
		Select courses = new Select(courseElement);
		try {
			courses.selectByValue(courseOption);
		} catch (Exception e) {
			assertTrue(false, "Invalid course.");
		}
	}

	public void selectSource(String sourceOption) {
		Select sources = new Select(sourceElement);
		try {
			sources.selectByValue(sourceOption);
		} catch (Exception e) {
			assertTrue(false, "Invalid source.");
		}
	}

	public void checkPreApplyStatus() {
		assertFalse(robotCheckbox.isSelected(), "Robot select should be off.");
		assertFalse(submitButton.isEnabled(), "Submit button should be disabled");
	}

	public void isNotRobot() {
		robotCheckbox.click();
		wait.until(ExpectedConditions.elementToBeClickable(submitButton));
	}

	public void submitApplication() {
		submitButton.submit();
		wait.until(ExpectedConditions.visibilityOf(successAlert));
	}

	public String getSuccessAlertText() {
		return successAlert.getText();
	}

}
