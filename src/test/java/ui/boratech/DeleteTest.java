package ui.boratech;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ui.base.web.DriverFactoryWebBase;
import utilities.ConfigReader;

public class DeleteTest extends DriverFactoryWebBase {

	private static String boratechURL = ConfigReader.getValue("boratech", "url");
	private static String email = ConfigReader.getValue("boratech", "email");
	private static String password = ConfigReader.getValue("boratech", "password");

	@Test
	@Tags(value = { @Tag("exp"), @Tag("delete") })
	void deleteExperience1stNegativeTest() {
		driver.navigate().to(boratechURL);
		driver.findElement(By.xpath("//div[@class='buttons']/a[@href='/login']")).click();
		wait.until(ExpectedConditions.urlContains("/login"));
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).submit();
		wait.until(ExpectedConditions.urlContains("/dashboard"));
		// collect all table rows
		By dataRowByLocator = By.xpath("//table/thead/tr/th[text()='Title']/ancestor::table/tbody/tr");
		List<WebElement> dataTableRows = driver.findElements(dataRowByLocator);
		int count = dataTableRows.size();
		// make sure it is not empty
		assertTrue(count >= 1, "Nothing to be deleted.");
		System.out.println("Count before deletion: " + count);
		// randomly delete one row
		Random roll = new Random();
		int targetRowIndex = roll.nextInt(count);
		// cell column index
		int titleIndex = 1;
		int deleteButtonIndex = 3;
		// unique data value
		String targetTitle = dataTableRows.get(targetRowIndex).findElements(By.tagName("td")).get(titleIndex).getText();
		// delete
		dataTableRows.get(targetRowIndex).findElements(By.tagName("td")).get(deleteButtonIndex).click();
		By successAlertByLocater = By.xpath("//div[@class='alert alert-success']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(successAlertByLocater));
		System.out.println(driver.findElement(successAlertByLocater).getText());
		// make sure deleted row is gone from the existing table
		dataTableRows = driver.findElements(dataRowByLocator);
		boolean targetFound = false;
		for (WebElement webElement : dataTableRows) {
			String actualTitle = webElement.findElements(By.tagName("td")).get(titleIndex).getText();
			if (actualTitle.equalsIgnoreCase(targetTitle)) {
				targetFound = true;
				System.out.println("Target: " + actualTitle);
				break;
			}
		}
		assertFalse(targetFound, "Deleted data is still visible.");
		System.out.println("Count after deletion: " + dataTableRows.size());
		System.out.println("Deleted: " + targetTitle);
	}

}
