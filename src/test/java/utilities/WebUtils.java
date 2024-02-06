package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class WebUtils {

	private WebDriver driver;

	public WebUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void saveScreenshot() {
		TakesScreenshot cam = (TakesScreenshot) driver;
		File imgData = cam.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(imgData, new File("target/webpage-screenshots/screenshot.png"));
		} catch (IOException e) {
			assertTrue(false, "Failed to capture the screenshot.");
		}
	}

}
