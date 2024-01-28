package tests.steps.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import utilities.DriverFactory;
import utilities.PageManager;

public class LoginSteps {

	private static PageManager pages = PageManager.getInstance();

	public static void navigateToLoginPage() {
		pages.loginPage().loadPage();
		System.out.println("User is on the login page.");
	}

	public static void enterUsername() {
		pages.loginPage().enterUsername("username");
		System.out.println("User enters the username.");
	}

	public static void enterPassword() {
		pages.loginPage().enterPassword("password");
		System.out.println("User enters the password.");
	}

	public static void clickSubmitButton() {
		pages.loginPage().submitLogin();
		System.out.println("User clicks the [Submit] button.");
	}

	public static void loginCheck() {
		assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("inventory"),
				"User should be on the inventory page.");
		System.out.println("User logins successfully.");
	}

}
