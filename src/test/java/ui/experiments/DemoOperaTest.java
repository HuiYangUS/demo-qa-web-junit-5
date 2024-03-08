package ui.experiments;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.time.Duration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.AppTestUtils;
import utilities.WebUtils;

@EnabledOnOs(OS.WINDOWS)
public class DemoOperaTest {

	private static String url = "https://jqueryui.com/";

	@Test
	@DisplayName("Demo Opera Test")
	@Tags({ @Tag("opera") })
	void runTest() {
		assertTrue(AppTestUtils.isOperaOnWindowsAvailable(), "Opera browser is not available.");
		ChromeDriverService operaService = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File("src/test/resources/drivers/win/operadriver/operadriver.exe")).build();
		ChromeOptions operaOptions = new ChromeOptions();
		operaOptions.setExperimentalOption("w3c", true);
		operaOptions.setBinary(AppTestUtils.getOperaOnWindowsPath());
		WebDriver driver = new ChromeDriver(operaService, operaOptions);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebUtils utils = new WebUtils(driver);
		driver.navigate().to(url);
		driver.findElement(By.linkText("Tooltip")).click();
		wait.until(ExpectedConditions.urlContains("tooltip/"));
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		By ageInputByLocator = By.id("age");
		By tooltipContentByLocator = By.className("ui-tooltip-content");
		utils.focusElement(driver.findElement(ageInputByLocator));
		utils.mouse().moveToElement(driver.findElement(ageInputByLocator)).pause(Duration.ofSeconds(1)).build()
				.perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(tooltipContentByLocator));
		System.out.println(driver.findElement(tooltipContentByLocator).getText());
		driver.quit();
	}

}
