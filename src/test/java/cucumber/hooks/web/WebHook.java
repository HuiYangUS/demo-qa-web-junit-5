package cucumber.hooks.web;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import utilities.DataManager;
import utilities.DriverFactory;
import utilities.PageManager;

public class WebHook {

	@BeforeAll(order = 3)
	public static void beforeAllTestConfig() {
		String browserName = System.getProperty("browser");
		if (browserName == null)
			browserName = "default";
		switch (browserName.strip().toLowerCase()) {
		case "chrome":
			System.out.println("Chrome in Test:");
			break;
		case "edge":
			System.out.println("Edge in Test:");
			break;
		case "firefox":
			System.out.println("Firefox in Test:");
			break;
		case "safari":
			System.out.println("Safari in Test:");
			break;
		default:
			System.out.println("Default browser in Test:");
			break;
		}
	}

	@Before("@ui or @web")
	public void setUp() {
		System.out.println("Test starts:");
		DriverFactory.getDriver();
		PageManager.getInstance();
		DataManager.getInstance();
	}

	@After("@ui or @web")
	public void tearDown() {
		System.out.println("Test completed.");
		DriverFactory.reset();
		PageManager.reset();
		DataManager.reset();
	}

}
