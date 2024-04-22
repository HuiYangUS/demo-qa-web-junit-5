package ui.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;

import ui.base.web.WebBaseTest;
import utils.TestConfigsReader;

public class MouseActionsTest extends WebBaseTest {

	private static String playgroundURL = TestConfigsReader.getTextValue("playground", "url");

	@Test
	@DisplayName("Mouse Actions Test")
	void actionTest() {
		driver.navigate().to(playgroundURL);
		By registerLinkByLocator = By
				.xpath("//a[@href='https://accounts.lambdatest.com/login/google']/following-sibling::div/a");
		// Always has to "perform" at the end
		utils.useMouseOrKey().scrollToElement(driver.findElement(registerLinkByLocator)).perform();
		utils.savesScreenshot("center-element", false);
	}

}
