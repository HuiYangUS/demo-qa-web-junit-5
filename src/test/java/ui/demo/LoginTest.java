package ui.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import org.openqa.selenium.By;

import pages.demo.LoginPage;
import steps.demo.LoginSteps;
import ui.base.web.DriverFactoryWebBase;
import utilities.ConfigReader;

@DisabledIfSystemProperty(named = "browser", matches = "safari", disabledReason = "LocalThreadDriver is incompatible with SafariDriver.")
@TestMethodOrder(OrderAnnotation.class)
public class LoginTest extends DriverFactoryWebBase {

	/*
	 * Without using Page Object Model
	 */
	@Test
	@Order(1)
	@Tags({ @Tag("ui"), @Tag("web") })
	public void run1stLoginTest() {
		driver.navigate().to(ConfigReader.getValue("config", "url"));
		driver.findElement(By.id("user-name")).sendKeys(ConfigReader.getValue("config", "username"));
		driver.findElement(By.id("password")).sendKeys(ConfigReader.getValue("config", "password"));
		driver.findElement(By.id("login-button")).submit();
		assertTrue(driver.getCurrentUrl().contains("inventory"), "User should be on the inventory page.");
	}

	/*
	 * Without using PageManager
	 */
	@Test
	@Order(2)
	@Tags({ @Tag("ui"), @Tag("web") })
	public void run2ndLoginTest() {
		LoginPage loginPage = new LoginPage();
		loginPage.loadPage();
		loginPage.enterUsername("username");
		loginPage.enterPassword("password");
		loginPage.submitLogin();
		assertTrue(driver.getCurrentUrl().contains("inventory"), "User should be on the inventory page.");
	}

	/*
	 * Without using steps package
	 */
	@Test
	@Order(3)
	@Tags({ @Tag("ui"), @Tag("web") })
	public void run3rdLoginTest() {
		pages.loginPage().loadPage();
		pages.loginPage().enterUsername("username");
		pages.loginPage().enterPassword("password");
		pages.loginPage().submitLogin();
		assertTrue(driver.getCurrentUrl().contains("inventory"), "User should be on the inventory page.");
	}

	/*
	 * The most advanced practice
	 */
	@Test
	@Order(4)
	@Tags({ @Tag("ui"), @Tag("web") })
	public void run4thLoginTest() {
		LoginSteps.navigateToLoginPage();
		LoginSteps.enterUsername();
		LoginSteps.enterPassword();
		LoginSteps.clickSubmitButton();
		LoginSteps.loginCheck();
	}

}
