package utilities;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	private static boolean remote = Boolean.valueOf(ConfigReader.getValue("config", "remote"));

	private DriverManager() {
	}

	public static WebDriver getDriver() {
		return remote ? RemoteDriverFactory.getDriver() : DriverFactory.getDriver();
	}

	public static void reset() {
		if (remote)
			RemoteDriverFactory.reset();
		else
			DriverFactory.reset();
	}

}
