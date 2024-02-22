package ui.jquery;

import java.time.Duration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ui.base.web.DriverFactoryWebBase;

public class TestUI extends DriverFactoryWebBase {

	private static String url = "https://jqueryui.com/";

	@Test
	@DisplayName("Tooltip Test")
	void tooltipTest() {
		driver.navigate().to(url);
		webUtils.jsClick(By.linkText("Tooltip"));
		wait.until(ExpectedConditions.urlContains("tooltip/"));
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		By ageInputByLocator = By.id("age");
		By tooltipContentByLocator = By.className("ui-tooltip-content");
		webUtils.focusElement(driver.findElement(ageInputByLocator));
		webUtils.mouse().moveToElement(driver.findElement(ageInputByLocator)).pause(Duration.ofSeconds(1)).build()
				.perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(tooltipContentByLocator));
		System.out.println(driver.findElement(tooltipContentByLocator).getText());
	}

}
