package cucumber.hooks.config;

import io.cucumber.java.*;

import utilities.ConfigReader;
import utilities.DataManager;
import utilities.DriverManager;
import utilities.PageManager;

public class WebHook {

	@BeforeAll(order = 3)
	public static void printTestInfo() {
		if (Boolean.valueOf(ConfigReader.getValue("config", "remote")))
			System.out.println("Remote testing:");
		else
			printTestType();
	}

	private static void printTestType() {
		String browser = System.getProperty("browser");
		if (browser == null)
			browser = "default";
		String browserName = "default browser";
		switch (browser.strip().toLowerCase()) {
		case "chrome":
			browserName = "Chrome";
			break;
		case "edge":
			browserName = "Edge";
			break;
		case "firefox":
			browserName = "Firefox";
			break;
		case "safari":
			browserName = "Safari";
			break;
		default:
			break;
		}
		System.out.println("Test in " + browserName + ":");
	}

	@Before("@ui or @web")
	public void setUp() {
		DriverManager.getDriver();
		PageManager.getInstance();
		DataManager.getInstance();
	}

	@After("@ui or @web")
	public void tearDown() {
		DriverManager.reset();
		PageManager.reset();
		DataManager.reset();
	}

}
