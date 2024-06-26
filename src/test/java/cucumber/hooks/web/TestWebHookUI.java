package cucumber.hooks.web;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import utils.DataManager;
import utils.DriverManager;
import utils.PageManager;
import utils.TestConfigsReader;

public class TestWebHookUI {

	@Before(order = 1, value = "@chrome")
	public void useChrome() {
		setupChrome();
	}

	@Before(order = 1, value = "@firefox")
	public void useFirefox() {
		System.setProperty("browser", "firefox");
	}

	private static String phoneName = "iPhone SE";
	private static String tabletName = "iPad Mini";

	@Before(order = 1, value = "@phone")
	public void setupPhone() {
		setupChrome();
		System.setProperty("deviceName", phoneName);
	}

	@Before(order = 1, value = "@tablet")
	public void setupTablet() {
		setupChrome();
		System.setProperty("deviceName", tabletName);
	}

	private static void setupChrome() {
		System.setProperty("browser", "chrome");
	}

	@Before(order = 2, value = "@ui or @web or @e2e or @phone or @tablet")
	public void setUp() {
		DriverManager.getDriver();
		PageManager.getInstance();
		DataManager.getInstance();
	}

	@After(order = 2, value = "@ui or @web or @e2e or @phone or @tablet")
	public void tearDown(Scenario scenario) {
		DataManager dataManager = DataManager.getInstance();
		if (TestConfigsReader.getBooleanValue("config", "screenshot") && scenario.isFailed())
			dataManager.webUtils().savesScreenshot();
		DriverManager.reset();
		PageManager.reset();
		DataManager.reset();
	}

}
