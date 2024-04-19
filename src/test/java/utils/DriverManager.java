package utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	private DriverManager() {
		// WARN: Nothing should be written here.
	}

	public static WebDriver getDriver() {
		String driverFactoryType = TestConfigsReader.getTextValue("config", "driverFactoryType");
		if (System.getProperty(TestKeys.DRIVER_FACTORY_TYPE_KEY) != null)
			driverFactoryType = System.getProperty(TestKeys.DRIVER_FACTORY_TYPE_KEY);
		if (driverFactoryType.equalsIgnoreCase("p") || driverFactoryType.equalsIgnoreCase("pie"))
			return DriverFactoryPie.getDriver();
		if (driverFactoryType.equalsIgnoreCase("m"))
			return DriverFactoryM.getDriver();
		throw new RuntimeException("No valid Driver Factory type in the system.");
	}

	public static void reset() {
		DriverFactoryPie.reset();
		DriverFactoryM.reset();
	}

}
