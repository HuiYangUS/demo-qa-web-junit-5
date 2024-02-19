package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class WebUtils {

	private WebDriver driver;
	private Actions actions;

	public WebUtils(WebDriver driver) {
		this.driver = driver;
		actions = new Actions(driver);
	}

	public Actions mouse() {
		return actions;
	}

	public Actions keyboard() {
		return actions;
	}

	public void savesScreenshot() {
		savesScreenshot(null, false);
	}

	public void savesScreenshot(String postfix, boolean useTimeStamp) {
		String tail = "-" + postfix;
		if (postfix == null)
			tail = "";
		if (useTimeStamp)
			tail += "-" + MyTestUtils.getDateString() + "-" + MyTestUtils.getTimeStamp();
		TakesScreenshot cam = (TakesScreenshot) driver;
		File imgData = cam.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(imgData, new File(String.format("target/webpage-screenshots/screenshot%s.png", tail)));
		} catch (IOException e) {
			assertTrue(false, "Failed to capture the screenshot.");
		}
	}

}
