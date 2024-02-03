package cucumber.step_definitions.demo;

import static org.junit.jupiter.api.Assertions.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import utilities.ConfigReader;
import utilities.DataManager;
import utilities.DriverManager;
import utilities.MyTestUtils;
import utilities.PageManager;

public class LoginSteps {

	private static PageManager pages = PageManager.getInstance();
	private static DataManager testData = DataManager.getInstance();

	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		pages.loginPage().loadPage();
		assertTrue(DriverManager.getDriver().getCurrentUrl().contains("saucedemo"), "User is not on the login page.");
	}

	@When("user enters the username")
	public void user_enters_the_username() {
		pages.loginPage().enterUsername("username");
	}

	@When("user enters the password")
	public void user_enters_the_password() {
		pages.loginPage().enterPassword("password");
		testData.setPasswordValue(pages.loginPage().getPasswordValue());
		assertTrue(testData.getPasswordValue().length() >= 1, "Password field is empty.");
	}

	@When("user clicks the [Login] button")
	public void user_clicks_the_login_button() {
		pages.loginPage().submitLogin();
	}

	@Then("user does not see a visible password")
	public void user_does_not_see_visible_password() {
		assertEquals(pages.loginPage().getPasswordValue(), ConfigReader.getValue("config", "password"),
				"Password is wrong.");
	}

	@Then("user is on the inventory page")
	public void user_is_on_the_inventory_page() {
		MyTestUtils.pause(1);
		assertTrue(pages.inventoryPage().isLoaded(), "User is not on the inventory page.");
	}

}
