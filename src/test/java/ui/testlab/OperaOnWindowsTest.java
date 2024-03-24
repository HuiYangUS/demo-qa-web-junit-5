package ui.testlab;

import java.io.File;
import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.AppTestUtils;
import utils.TestConfigReader;

public class OperaOnWindowsTest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    private static String url = TestConfigReader.getTextValue("playground", "url");

    private static boolean demo = TestConfigReader.getBooleanValue("config", "demo");

    @Test
    @DisplayName("Opera On Windows Test")
    @EnabledOnOs(OS.WINDOWS)
    void runTest() {
	driver.navigate().to(url);
	wait.until(ExpectedConditions.urlContains("playground"));
	if (demo)
	    AppTestUtils.pause(1);
    }

    @BeforeEach
    void setUp() {
	ChromeDriverService service = new ChromeDriverService.Builder()
		.usingDriverExecutable(new File("src/test/resources/drivers/win/operadriver/operadriver.exe")).build();
	ChromeOptions options = new ChromeOptions();
	options.setBinary(TestConfigReader.getTextValue("config", "operaBinPath"));
	options.setExperimentalOption("w3c", true);
	driver = new ChromeDriver(service, options);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	wait = new WebDriverWait(driver, Duration.ofSeconds(TestConfigReader.getIntNumValue("config", "waitTime")));
    }

    @AfterEach
    void tearDown() {
	driver.quit();
    }

}
