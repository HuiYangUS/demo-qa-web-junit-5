package ui.boratech;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ui.base.web.DriverFactoryWebBase;
import utilities.ConfigReader;

public class FirefoxApplyDateTest extends DriverFactoryWebBase {

	@BeforeAll
	static void runFirefox() {
		System.setProperty("browser", "firefox");
	}

	private static String boratechURL = ConfigReader.getValue("boratech", "url");

	@Test
	void runApplyTest() {
		driver.navigate().to(boratechURL);
		driver.findElement(By.xpath("//a[@href='/apply']")).click();
		wait.until(ExpectedConditions.urlContains("/apply"));
		driver.findElement(By.name("dob")).click();
		webUtils.keyboard().sendKeys("12252005").perform();
		wait.until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(By.name("dob")), "value"));
		System.out.println(driver.findElement(By.name("dob")).getAttribute("value"));
	}

}
