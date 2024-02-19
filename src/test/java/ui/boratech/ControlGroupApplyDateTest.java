package ui.boratech;

import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ui.base.web.DriverFactoryWebBase;
import utilities.ConfigReader;

public class ControlGroupApplyDateTest extends DriverFactoryWebBase {

	private static String boratechURL = ConfigReader.getValue("boratech", "url");

	@Test
	void run1stApplyTest() {
		driver.navigate().to(boratechURL);
		driver.findElement(By.xpath("//a[@href='/apply']")).click();
		wait.until(ExpectedConditions.urlContains("/apply"));
		driver.findElement(By.name("dob")).sendKeys("12252001");
		wait.until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(By.name("dob")), "value"));
		System.out.println(driver.findElement(By.name("dob")).getAttribute("value"));
	}

	@Test
	void run2ndApplyTest() {
		driver.navigate().to(boratechURL);
		driver.findElement(By.xpath("//a[@href='/apply']")).click();
		wait.until(ExpectedConditions.urlContains("/apply"));
		driver.findElement(By.name("dob")).sendKeys("12-25-2001");
		wait.until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(By.name("dob")), "value"));
		System.out.println(driver.findElement(By.name("dob")).getAttribute("value"));
	}

	@Test
	void run3rdApplyTest() {
		driver.navigate().to(boratechURL);
		driver.findElement(By.xpath("//a[@href='/apply']")).click();
		wait.until(ExpectedConditions.urlContains("/apply"));
		driver.findElement(By.name("dob")).sendKeys("12/25/2001");
		wait.until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(By.name("dob")), "value"));
		System.out.println(driver.findElement(By.name("dob")).getAttribute("value"));
	}

}
