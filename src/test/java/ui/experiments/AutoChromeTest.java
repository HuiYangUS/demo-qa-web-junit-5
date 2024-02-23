package ui.experiments;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import utilities.ConfigReader;
import utilities.MyTestUtils;

public class AutoChromeTest {

	@Test
	@DisplayName("Auto Chrome Test")
	@EnabledOnOs(OS.WINDOWS)
	void runTest() {
		assertTrue(MyTestUtils.isAutoChromeOnWindowsAvailable(), "No auto chrome browser is available in the system.");
		ChromeDriverService service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File("src/test/resources/drivers/win/chromedriver/chromedriver.exe"))
				.build();
		ChromeOptions options = new ChromeOptions();
		options.setBinary(MyTestUtils.getAutoChromeOnWindowsPath());
		WebDriver driver = new ChromeDriver(service, options);
		driver.manage().window().maximize();
		driver.navigate().to(ConfigReader.getValue("playground", "url"));
		MyTestUtils.pause(3);
		driver.quit();
	}

}
