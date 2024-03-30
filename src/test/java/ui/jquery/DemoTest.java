package ui.jquery;

import java.time.Duration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ui.base.web.DriverFactoryWebBase;

public class DemoTest extends DriverFactoryWebBase {

    private static String url = "https://jqueryui.com/";

    @Test
    @DisplayName("Tooltip Test")
    void tooltipTest() {
	driver.navigate().to(url);
	utils.jsClick(By.linkText("Tooltip"));
	wait.until(ExpectedConditions.urlContains("tooltip/"));
	driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
	By ageInputByLocator = By.id("age");
	By tooltipContentByLocator = By.className("ui-tooltip-content");
	utils.elementOnFocus(driver.findElement(ageInputByLocator));
	utils.useMouseOrKey().moveToElement(driver.findElement(ageInputByLocator)).pause(Duration.ofSeconds(1)).build()
		.perform();
	wait.until(ExpectedConditions.visibilityOfElementLocated(tooltipContentByLocator));
	System.out.println(driver.findElement(tooltipContentByLocator).getText());
    }

}
