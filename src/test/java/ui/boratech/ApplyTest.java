package ui.boratech;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import ui.base.web.DriverFactoryWebBase;
import utilities.ConfigReader;

public class ApplyTest extends DriverFactoryWebBase {

	private static String boratechURL = ConfigReader.getValue("boratech", "url");

	@Test
	@DisabledIfSystemProperty(named = "browser", matches = "firefox", disabledReason = "Date input field needs to be fixed in Firefox.")
	void applyPositiveTest() {
		driver.navigate().to(boratechURL);
		driver.findElement(By.xpath("//a[@href='/apply']")).click();
		wait.until(ExpectedConditions.urlContains("/apply"));
		// data
		String firstName = "Bruce";
		String lastName = "Wayne";
		String[] dateData = LocalDate.now().toString().split("-");
		// month, day, year
		String today = dateData[1] + dateData[2] + dateData[0];
		int gender = 2;
		String email = "myemail@email.com";
		String phoneNumber = "1234569999";
		// data entries
		driver.findElement(By.name("firstname")).sendKeys(firstName);
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.name("dob")).sendKeys(today);
		List<WebElement> genderElements = driver.findElements(By.name("gender"));
		genderElements.get(gender).click();
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("phonenumber")).sendKeys(phoneNumber);
		// Select class
		Select courseSelectElement = new Select(driver.findElement(By.name("course")));
		courseSelectElement.selectByValue("sdet");
		Select sourceSelectElement = new Select(driver.findElement(By.name("source")));
		sourceSelectElement.selectByValue("website");
		// check for elements' status
		By robotByLocator = By.name("notarobot");
		assertFalse(driver.findElement(robotByLocator).isSelected(), "Robot select should be off.");
		By submitByLocator = By.xpath("//input[@type='submit']");
		assertFalse(driver.findElement(submitByLocator).isEnabled(), "Submit button should be disabled");
		driver.findElement(robotByLocator).click();
		wait.until(ExpectedConditions.elementToBeClickable(submitByLocator));
		// submit
		driver.findElement(submitByLocator).click();
		By successAlertByLocater = By.xpath("//div[@class='alert alert-success']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(successAlertByLocater));
		Document doc = Jsoup.parse(driver.getPageSource());
		Elements alertElements = doc.getElementsByAttributeValueContaining("class", "alert");
		if (alertElements.size() == 1)
			System.out.println(alertElements.get(0).className());
		System.out.println(driver.findElement(successAlertByLocater).getText());
	}

}
