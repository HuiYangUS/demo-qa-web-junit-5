package ui.playground;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages.playground.FormDemoPage;
import pages.playground.MainPage;
import ui.base.web.DriverFactoryWebBase;
import utilities.ConfigReader;

public class PlaygroundDemoTest extends DriverFactoryWebBase {

	private static String playgroundURL = ConfigReader.getValue("playground", "url");

	@Test
	@DisplayName("Form Demo Positive Test")
	@Tags(value = { @Tag("pos"), @Tag("form") })
	void formDemoPositiveTest() {
		MainPage mainPage = new MainPage();
		mainPage.loadPage();
		mainPage.toFormDemo();
		FormDemoPage formDemoPage = new FormDemoPage();
		formDemoPage.enterName("My Name");
		formDemoPage.enterEmail("mytest@email.com");
		formDemoPage.enterPassword("mypass666");
		formDemoPage.enterCompany("Microsoft Corporation");
		formDemoPage.enterWebsite("https://www.microsoft.com/en-us/");

		formDemoPage.enterCity("Redmond");
		formDemoPage.enterFirstAddress("Microsoft Building 92");
		formDemoPage.enterSecondAddress("NE 36th St");
		formDemoPage.enterState("Washington");
		formDemoPage.enterZipCode("98052");
		formDemoPage.submitForm();
		assertTrue(formDemoPage.submissionCheck(), "Submission failed.");
		System.out.println(formDemoPage.getSuccessText());
	}

	@Test
	@Tags(value = { @Tag("date") })
	void DateDemoInput1stTest() {
		driver.navigate().to(playgroundURL);
		driver.findElement(By.linkText("Bootstrap Date Picker")).click();
		wait.until(ExpectedConditions.urlContains("/bootstrap-date-picker-demo"));
		By birthdayDateInputByLocator = By.id("birthday");
		// make sure to clear any placeholder or previous stored entered data
		driver.findElement(birthdayDateInputByLocator).clear();
		wait.until(ExpectedConditions.attributeToBe(birthdayDateInputByLocator, "value", ""));
		// send data
		webUtils.keyboard().sendKeys(driver.findElement(birthdayDateInputByLocator), "12252005").perform();
		wait.until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(birthdayDateInputByLocator), "value"));
		System.out.println(driver.findElement(birthdayDateInputByLocator).getAttribute("value"));
		// clear data
		driver.findElement(birthdayDateInputByLocator).clear();
		wait.until(ExpectedConditions.attributeToBe(birthdayDateInputByLocator, "value", ""));
	}

}
