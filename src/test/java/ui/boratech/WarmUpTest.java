package ui.boratech;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ui.base.web.DriverFactoryWebBase;
import utilities.ConfigReader;

public class WarmUpTest extends DriverFactoryWebBase {

	private static String boratechURL = ConfigReader.getValue("boratech", "url");

	@Test
	void runTest() {
		driver.navigate().to(boratechURL);
		wait.until(ExpectedConditions.urlContains("boratech"));
		System.out.println(driver.getTitle());
	}

}
