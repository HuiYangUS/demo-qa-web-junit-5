package ui.demo;

import java.util.Map;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import ui.base.config.ConfigTest;
import ui.base.web.WebBase;
import utilities.MyTestUtils;

public class FirstWebTest extends WebBase {

	@Test
	@Tag("web")
	void demoTest() {
		ConfigTest.printThread();
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

		if (driver instanceof EdgeDriver) {
			EdgeDriver edgeDriver = (EdgeDriver) driver;
			Map<?, ?> data = edgeDriver.getCapabilities().asMap();
			System.out.println(String.format("%s: %s", "browserName", edgeDriver.getCapabilities().getBrowserName()));
			System.out.println(
					String.format("%s: %s", "browserVersion", edgeDriver.getCapabilities().getBrowserVersion()));
			System.out.println(String.format("%s: %s", "msedgedriverVersion", ((Map<?, ?>) data.get("msedge"))
					.get("msedgedriverVersion").toString().replaceAll("[(].*[)]", "").strip()));
		}

		MyTestUtils.pause(1);
	}

}
