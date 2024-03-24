package ui.playground;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;

import ui.base.web.DriverFactoryWebBase;
import utils.TestConfigReader;

public class MouseActionsTest extends DriverFactoryWebBase {

    private static String playgroundURL = TestConfigReader.getTextValue("playground", "url");

    @Test
    @DisplayName("Mouse Actions Test")
    void actionTest() {
	driver.navigate().to(playgroundURL);
	By registerLinkByLocator = By
		.xpath("//a[@href='https://accounts.lambdatest.com/login/google']/following-sibling::div/a");
	// always need to "perform" at the end
	webUtils.useMouseOrKey().scrollToElement(driver.findElement(registerLinkByLocator)).perform();
	webUtils.savesScreenshot("center-element", false);
    }

}
