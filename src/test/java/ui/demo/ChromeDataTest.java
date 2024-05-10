package ui.demo;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Capabilities;

import ui.base.web.ChromeBaseTest;
import utils.TestUtils;

public class ChromeDataTest extends ChromeBaseTest {

	@Test
	void runTest() {
		TestUtils.pause(1);
		Capabilities data = driver.getCapabilities();
		@SuppressWarnings("unchecked")
		Map<String, String> chrome = (Map<String, String>) data.getCapability("chrome");
		String browserVersion = data.getBrowserVersion();
		System.out.println("Browser name: " + data.getBrowserName());
		System.out.println("Browser version: " + browserVersion);
		System.out.println("Driver version: " + chrome.get("chromedriverVersion").replaceAll("[(].*[)]", ""));
	}

}
