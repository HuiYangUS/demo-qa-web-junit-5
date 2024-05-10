package ui.base.web;

import java.io.File;
import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import utils.TestConfigsReader;

public class ChromeBaseTest {

	protected ChromeDriver driver;

	@BeforeEach
	void setUp() {
		String driverBinPath = TestConfigsReader.getTextValue("drivers", "chrome");
		ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(new File(driverBinPath))
				.build();
		ChromeOptions options = new ChromeOptions();
		options.setBinary(TestConfigsReader.getTextValue("browsers", "chrome"));
		driver = new ChromeDriver(service, options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
	}

	@AfterEach
	void tearDown() {
		if (driver != null)
			driver.quit();
	}

}
