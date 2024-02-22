package ui.playground;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ui.base.web.DriverFactoryWebBase;
import utilities.ConfigReader;

public class TempTest extends DriverFactoryWebBase {

	private static String playgroundURL = ConfigReader.getValue("playground", "url");

	@Test
	@DisplayName("Playground Temp Test")
	void runTest() {
		driver.navigate().to(playgroundURL);
		driver.findElement(By.linkText("Input Form Submit")).click();
		wait.until(ExpectedConditions.urlContains("input-form-demo"));
		By nameInputByLocator = By.id("name");
		String validationText = driver.findElement(nameInputByLocator).getAttribute("validationMessage");
		assertFalse(validationText.isBlank(), "Input field is not empty.");
		System.out.println("Validation message: " + validationText);
		driver.findElement(nameInputByLocator).sendKeys("King");
		driver.findElement(By.cssSelector("form[id='seleniumform'] button[type='submit']")).click();
		wait.until(ExpectedConditions.attributeToBe(nameInputByLocator, "validationMessage", ""));
		webUtils.savesScreenshot("validation-message-demo", false);
	}

}
