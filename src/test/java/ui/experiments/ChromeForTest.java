package ui.experiments;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import utilities.ConfigReader;
import utilities.AppTestUtils;

public class ChromeForTest {

    @Test
    @DisplayName("Chrome for Test")
    void runTest() {
	String chromeForTest = null;
	try {
	    chromeForTest = ConfigReader.getValue("config", "chromeForTest");
	} catch (Exception e) {
	    assertTrue(false, "Chrome for Test is not found in the system.");
	}
	ChromeDriverService service = new ChromeDriverService.Builder()
		.usingDriverExecutable(new File("src/test/resources/drivers/win/chromedriver/chromedriver.exe"))
		.build();
	ChromeOptions options = new ChromeOptions();
	options.setBinary(chromeForTest);
	WebDriver driver = new ChromeDriver(service, options);
	driver.manage().window().maximize();
	driver.navigate().to(ConfigReader.getValue("playground", "url"));
	AppTestUtils.pause(3);
	driver.quit();
    }

}
