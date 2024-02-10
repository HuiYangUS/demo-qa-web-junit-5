package ui.demo;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ui.base.web.DriverFactoryWebBase;

public class FirstWebTest extends DriverFactoryWebBase {

	private String url = "https://www.google.com/";
	private String searchTerm = "Batman";
	private int num = 7;

	@Test
	@DisplayName(value = "First Web Test")
	@Tag("web")
	void webTest() {
		if (driver instanceof ChromeDriver) {
			ChromeDriver chromeDriver = (ChromeDriver) driver;
			Map<?, ?> data = chromeDriver.getCapabilities().asMap();
			System.out.println(String.format("%s: %s", "browserName", chromeDriver.getCapabilities().getBrowserName()));
			System.out.println(
					String.format("%s: %s", "browserVersion", chromeDriver.getCapabilities().getBrowserVersion()));
			System.out.println(String.format("%s: %s", "chromedriverVersion", ((Map<?, ?>) data.get("chrome"))
					.get("chromedriverVersion").toString().replaceAll("[(].*[)]", "").strip()));
		}
		driver.navigate().to(url);
		driver.findElement(By.name("q")).sendKeys(searchTerm + Keys.ENTER);
		By linkByLocator = By.xpath("//div[@id='rso']//a");
		// if 39 does not work, try 29
		try {
			wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(linkByLocator, 39));
		} catch (Exception e) {
			wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(linkByLocator, 29));
		}
		List<WebElement> dataList = driver.findElements(linkByLocator);
		System.out.println("Number of links: " + dataList.size());
		if (num <= dataList.size())
			System.out.println("Target webpage == " + dataList.get(num - 1).getAttribute("href"));
	}

}
