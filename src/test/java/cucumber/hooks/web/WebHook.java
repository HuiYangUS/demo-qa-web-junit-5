package cucumber.hooks.web;

import io.cucumber.java.*;
import utilities.ConfigReader;
import utilities.DataManager;
import utilities.DriverManager;
import utilities.PageManager;

public class WebHook {

	@BeforeAll(order = 3)
	public static void beforeAllTestConfig() {
		if (Boolean.valueOf(ConfigReader.getValue("config", "remote")))
			System.out.println("Remote testing:");
		else
			printTestType();
	}

	private static void printTestType() {
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
		DriverManager.getDriver();
		PageManager.getInstance();
		DataManager.getInstance();
	}

	@After("@ui or @web")
	public void tearDown() {
		System.out.println("Test completed.");
		DriverManager.reset();
		PageManager.reset();
		DataManager.reset();
	}

}
