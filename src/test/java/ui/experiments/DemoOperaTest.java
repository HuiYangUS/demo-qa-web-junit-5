package ui.experiments;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import utilities.MyTestUtils;

@EnabledOnOs(OS.WINDOWS)
public class DemoOperaTest {

	WebDriver driver;

	private static String url = "https://www.usa.gov/";

	@BeforeEach
	void setUp() {
		String userDir = System.getProperty("user.dir");
		String tempStr = userDir.substring(9);
		int index = -1;
		if (tempStr.contains("\\"))
			index = tempStr.indexOf("\\");
		else
			index = tempStr.indexOf("/");
		String resultStr = tempStr.substring(0, index);
		String operaBinaryFilePath = "C:/Users/" + resultStr + "/AppData/Local/Programs/Opera/opera.exe";
		assertTrue(new File(operaBinaryFilePath).exists(), "Failed to locate the binary.");

		ChromeDriverService service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File("src/test/resources/drivers/windows/operadriver/operadriver.exe"))
				.build();
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("w3c", true);
		options.setBinary(operaBinaryFilePath);
		driver = new ChromeDriver(service, options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterEach
	void tearDown() {
		if (driver != null)
			driver.quit();
	}

	@Test
	void runTest() {
		driver.navigate().to(url);
		driver.findElement(By.xpath("//li[@id='usa-nav_taxes']//a")).click();
		MyTestUtils.pause(1);
		assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://www.usa.gov/taxes"),
				"User is not on the taxes page.");
	}

}
