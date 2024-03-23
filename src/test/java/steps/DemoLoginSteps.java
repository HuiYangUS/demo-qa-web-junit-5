package steps;

import static org.junit.jupiter.api.Assertions.*;

import utils.DriverManager;
import utils.PageManager;

public class DemoLoginSteps {

    private static PageManager pages = PageManager.getInstance();

    public static void navigateToLoginPage() {
	pages.demoLoginPage().loadPage();
	System.out.println("User is on the login page.");
    }

    public static void enterUsername() {
	pages.demoLoginPage().enterUsername("username");
	System.out.println("User enters the username.");
    }

    public static void enterPassword() {
	pages.demoLoginPage().enterPassword("password");
	System.out.println("User enters the password.");
    }

    public static void clickSubmitButton() {
	pages.demoLoginPage().submitLogin();
	System.out.println("User clicks the [Submit] button.");
    }

    public static void loginCheck() {
	assertTrue(DriverManager.getDriver().getCurrentUrl().contains("inventory"),
		"User should be on the inventory page.");
	System.out.println("User logins successfully.");
    }

}
