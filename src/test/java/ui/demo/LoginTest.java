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
import steps.DemoLoginSteps;
import ui.base.web.DriverFactoryWebBase;
import utils.AppConfigReader;

@TestMethodOrder(OrderAnnotation.class)
public class LoginTest extends DriverFactoryWebBase {

    /**
     * Without using Page Object Model
     */
    @Test
    @DisplayName("First Login Test")
    @Order(1)
    @Tags({ @Tag("ui"), @Tag("web") })
    public void the1stLoginTest() {
	driver.navigate().to(AppConfigReader.getValue("config", "url"));
	driver.findElement(By.id("user-name")).sendKeys(AppConfigReader.getValue("config", "username"));
	driver.findElement(By.id("password")).sendKeys(AppConfigReader.getValue("config", "password"));
	driver.findElement(By.id("login-button")).submit();
	assertTrue(driver.getCurrentUrl().contains("inventory"), "User should be on the inventory page.");
    }

    /**
     * Without using PageManager
     */
    @Test
    @DisplayName("Second Login Test")
    @Order(2)
    @Tags({ @Tag("ui"), @Tag("web") })
    public void the2ndLoginTest() {
	DemoLoginPage loginPage = new DemoLoginPage();
	loginPage.loadPage();
	loginPage.enterUsername("username");
	loginPage.enterPassword("password");
	loginPage.submitLogin();
	assertTrue(driver.getCurrentUrl().contains("inventory"), "User should be on the inventory page.");
    }

    /**
     * Without using steps package
     */
    @Test
    @DisplayName("Third Login Test")
    @Order(3)
    @Tags({ @Tag("ui"), @Tag("web") })
    public void the3rdLoginTest() {
	pages.demoLoginPage().loadPage();
	pages.demoLoginPage().enterUsername("username");
	pages.demoLoginPage().enterPassword("password");
	pages.demoLoginPage().submitLogin();
	assertTrue(driver.getCurrentUrl().contains("inventory"), "User should be on the inventory page.");
    }

    /**
     * The most advanced practice
     */
    @Test
    @DisplayName("Fourth Login Test")
    @Order(4)
    @Tags({ @Tag("ui"), @Tag("web") })
    public void the4thLoginTest() {
	DemoLoginSteps.navigateToLoginPage();
	DemoLoginSteps.enterUsername();
	DemoLoginSteps.enterPassword();
	DemoLoginSteps.clickSubmitButton();
	DemoLoginSteps.loginCheck();
    }

}
