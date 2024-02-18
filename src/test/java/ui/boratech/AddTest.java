package ui.boratech;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ui.base.web.DriverFactoryWebBase;
import utilities.ConfigReader;

public class AddTest extends DriverFactoryWebBase {

	private static String boratechURL = ConfigReader.getValue("boratech", "url");
	private static String email = ConfigReader.getValue("boratech", "email");
	private static String password = ConfigReader.getValue("boratech", "password");

	@Test
	void addEducation1stNegativeTest() {
		driver.navigate().to(boratechURL);
		driver.findElement(By.xpath("//div[@class='buttons']/a[@href='/login']")).click();
		wait.until(ExpectedConditions.urlContains("/login"));
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).submit();
		wait.until(ExpectedConditions.urlContains("/dashboard"));
		driver.findElement(By.xpath("//a[@href='/add-education']")).click();
		wait.until(ExpectedConditions.urlContains("/add-education"));
		By errorAlertByLocater = By.xpath("//div[@class='alert alert-danger']");
		assertEquals(0, driver.findElements(errorAlertByLocater).size(), "Incorrect timing of error messages.");
		driver.findElement(By.xpath("//input[@type='submit']")).submit();
		wait.until(ExpectedConditions.numberOfElementsToBe(errorAlertByLocater, 4));
		List<WebElement> errorAlertElements = driver.findElements(errorAlertByLocater);
		for (WebElement webElement : errorAlertElements)
			System.out.println("Alert: " + webElement.getText());
	}

	@Test
	void addExperience1stNegativeTest() {
		driver.navigate().to(boratechURL);
		driver.findElement(By.xpath("//div[@class='buttons']/a[@href='/login']")).click();
		wait.until(ExpectedConditions.urlContains("/login"));
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).submit();
		wait.until(ExpectedConditions.urlContains("/dashboard"));
		driver.findElement(By.xpath("//a[@href='/add-experience']")).click();
		wait.until(ExpectedConditions.urlContains("/add-experience"));
		By errorAlertByLocater = By.xpath("//div[@class='alert alert-danger']");
		assertEquals(0, driver.findElements(errorAlertByLocater).size(), "Incorrect timing of error messages.");
		driver.findElement(By.xpath("//input[@type='submit']")).submit();
		wait.until(ExpectedConditions.numberOfElementsToBe(errorAlertByLocater, 3));
		List<WebElement> errorAlertElements = driver.findElements(errorAlertByLocater);
		for (WebElement webElement : errorAlertElements)
			System.out.println("Alert: " + webElement.getText());
	}

}
