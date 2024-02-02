package utilities;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

public class RemoteDriverFactory {

	private static WebDriver driver;
	private static int waitTime = 5;

	private RemoteDriverFactory() {
	}

	public static WebDriver getDriver() {
		if (driver == null)
			try {
				driver = initRemoteDriver();
			} catch (Exception e) {
				e.printStackTrace();
			}
		return driver;
	}

	private static WebDriver initRemoteDriver() throws Exception {
		URL gridURL = new URL(ConfigReader.getValue("config", "grid"));

		switch (ConfigReader.getValue("config", "browser")) {
		case "chrome":
			driver = new RemoteWebDriver(gridURL, new ChromeOptions());
			break;
		case "edge":
			driver = new RemoteWebDriver(gridURL, new EdgeOptions());
			break;
		case "firefox":
			driver = new RemoteWebDriver(gridURL, new FirefoxOptions());
			break;
		case "safari":
			driver = new RemoteWebDriver(gridURL, new SafariOptions());
			break;
		default:
			throw new Exception("No browser is found.");
		}

		configDriver(driver);
		return driver;
	}

	private static void configDriver(WebDriver driver) {
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
	}

	public static void reset() {
		if (driver != null)
			driver.quit();
		driver = null;
	}

}
