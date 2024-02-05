package ui.demo;

import java.util.Map;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import ui.base.web.DriverFactoryWebBase;
import utilities.MyTestUtils;

public class FirstWebTest extends DriverFactoryWebBase {

	@Test
	@Tag("web")
	void demoTest() {
		System.out.println("ChromeDriver: " + (driver instanceof ChromeDriver));
		if (driver instanceof ChromeDriver) {
			ChromeDriver chromeDriver = (ChromeDriver) driver;
			Map<?, ?> data = chromeDriver.getCapabilities().asMap();
			System.out.println(String.format("%s: %s", "browserName", chromeDriver.getCapabilities().getBrowserName()));
			System.out.println(
					String.format("%s: %s", "browserVersion", chromeDriver.getCapabilities().getBrowserVersion()));
			System.out.println(String.format("%s: %s", "chromedriverVersion", ((Map<?, ?>) data.get("chrome"))
					.get("chromedriverVersion").toString().replaceAll("[(].*[)]", "").strip()));
		}

		MyTestUtils.pause(1);
	}

}
