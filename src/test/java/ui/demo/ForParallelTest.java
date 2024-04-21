package ui.demo;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.TestConfigsReader;

public class ForParallelTest {

	private WebDriver driver;
	private WebDriverWait wait;

	@BeforeEach
	void setUp() {
		String chromeDriverPath = TestConfigsReader.getTextValue("drivers", "chrome");
		ChromeDriverService service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File(chromeDriverPath)).build();
		ChromeOptions options = new ChromeOptions();
		options.setBinary(TestConfigsReader.getTextValue("config", "testChromeBinPath"));
		driver = new ChromeDriver(service, options);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(TestConfigsReader.getIntNumValue("config", "waitTime")));
	}

	@AfterEach
	void tearDown() {
		if (driver != null)
			driver.quit();
	}

	private static String url = "https://www.google.com/";
	private static int num = 7;

	@Test
	void testGoogleSearchA() {
		String searchTerm = "Batman";
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

	@Test
	void testGoogleSearchB() {
		String searchTerm = "Superman";
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
