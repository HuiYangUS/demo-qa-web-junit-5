package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUtils {

	private WebDriver driver;
	@SuppressWarnings("unused")
	private WebDriverWait wait;
	private Actions actions;
	private JavascriptExecutor js;

	public WebUtils(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(AppTestUtils.getTestConfigWaitTime()));
		actions = new Actions(driver);
		js = (JavascriptExecutor) driver;
	}

	public void jsClick(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}

	public void jsClick(By locator) {
		jsClick(driver.findElement(locator));
	}

	/**
	 * Change the border of an element to be thick and red
	 */
	public void elementOnFocus(WebElement element) {
		// Set this element's border to be red and thick
		js.executeScript("arguments[0].style.borderColor = 'red'; arguments[0].style.borderWidth = 'thick';", element);
		AppTestUtils.pause(2);
		// Reset this element's border
		js.executeScript("arguments[0].style.borderColor = ''; arguments[0].style.borderWidth = '';", element);
		AppTestUtils.pause(1);
	}

	public void elementOnFocus(By locator) {
		elementOnFocus(driver.findElement(locator));
	}

	public Actions useMouseOrKey() {
		return actions;
	}

	public void savesScreenshot() {
		savesScreenshot(null, false);
	}

	/**
	 * Takes a screenshot and stores in the "target" folder
	 */
	public void savesScreenshot(String postfix, boolean useTimeStamp) {
		String tail = "-" + postfix;
		if (postfix == null)
			tail = "";
		if (useTimeStamp)
			tail += "-" + AppTestUtils.getDateString() + "-" + AppTestUtils.getTimeStamp();
		TakesScreenshot cam = (TakesScreenshot) driver;
		File imgData = cam.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(imgData, new File(String.format("target/webpage-screenshots/screenshot%s.png", tail)));
		} catch (IOException e) {
			throw new RuntimeException("Failed to capture the screenshot.", e);
		}
	}

}
