package ui.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;

import pages.DemoLoginPage;
import ui.base.web.WebBaseTest;
import utils.TestUtils;
import utils.TestConfigsReader;

@TestMethodOrder(OrderAnnotation.class)
public class LoginTest extends WebBaseTest {

	private static boolean demo = TestUtils.isDemoTest()
			&& !Boolean.valueOf(TestConfigsReader.getBooleanValue("config", "headless"));

	/**
	 * Without using Page Object Model
	 */
	@Test
	@DisplayName("First Login Demo Test")
	@Order(1)
	@Tags({ @Tag("ui"), @Tag("web"), @Tag("demo"), @Tag("login") })
	public void the1stLoginTest() {
		driver.navigate().to(TestConfigsReader.getTextValue("demo", "url"));
		driver.findElement(By.id("user-name")).sendKeys(TestConfigsReader.getTextValue("demo", "username"));
		driver.findElement(By.id("password")).sendKeys(TestConfigsReader.getTextValue("demo", "password"));
		driver.findElement(By.id("login-button")).submit();
		assertTrue(driver.getCurrentUrl().contains("inventory"), "User should be on the inventory page.");
		if (demo)
			TestUtils.pause(1);
	}

	/**
	 * Without using PageManager
	 */
	@Test
	@DisplayName("Second Login Demo Test")
	@Order(2)
	@Tags({ @Tag("ui"), @Tag("web"), @Tag("demo"), @Tag("login") })
	public void the2ndLoginTest() {
		DemoLoginPage loginPage = new DemoLoginPage();
		loginPage.loadPage();
		loginPage.enterUsername("username");
		loginPage.enterPassword("password");
		loginPage.submitLogin();
		assertTrue(driver.getCurrentUrl().contains("inventory"), "User should be on the inventory page.");
		if (demo)
			TestUtils.pause(1);
	}

	/**
	 * Without using steps package
	 */
	@Test
	@DisplayName("Third Login Demo Test")
	@Order(3)
	@Tags({ @Tag("ui"), @Tag("web"), @Tag("demo"), @Tag("login") })
	public void the3rdLoginTest() {
		pages.demoLoginPage().loadPage();
		pages.demoLoginPage().enterUsername("username");
		pages.demoLoginPage().enterPassword("password");
		pages.demoLoginPage().submitLogin();
		assertTrue(driver.getCurrentUrl().contains("inventory"), "User should be on the inventory page.");
		if (demo)
			TestUtils.pause(1);
	}

}
