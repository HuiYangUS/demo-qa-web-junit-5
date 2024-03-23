package ui.playground;

import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;

import ui.base.web.DriverFactoryWebBase;
import utils.AppConfigReader;

public class MouseActionsTest extends DriverFactoryWebBase {

    private static String playgroundURL = AppConfigReader.getValue("playground", "url");

    @Test
    void actionTest() {
	driver.navigate().to(playgroundURL);
	By registerLinkByLocator = By
		.xpath("//a[@href='https://accounts.lambdatest.com/login/google']/following-sibling::div/a");
	// always need to "perform" at the end
	webUtils.useMouseOrKey().scrollToElement(driver.findElement(registerLinkByLocator)).perform();
	webUtils.savesScreenshot("center-element", false);
    }

}
