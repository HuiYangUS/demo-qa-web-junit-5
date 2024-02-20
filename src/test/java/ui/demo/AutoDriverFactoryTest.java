package ui.demo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import ui.base.web.DriverFactoryWebBase;
import utilities.MyTestUtils;

public class AutoDriverFactoryTest extends DriverFactoryWebBase {

	@BeforeAll
	static void useAutoDriver() {
		System.setProperty("auto", "true");
	}

	String url = "https://junit.org/junit5/docs/current/user-guide/";

	@Test
	@DisplayName("Auto Driver Test")
	@Tags(value = { @Tag("auto"), @Tag("ui") })
	void runTest() {
		System.out.println(driver.toString().replaceAll("[(].*[)]", ""));
		driver.navigate().to(url);
		MyTestUtils.pause(1);
	}

	@Test
	@DisplayName("Demo Auto Driver Test")
	@Tags(value = { @Tag("auto"), @Tag("ui"), @Tag("demo") })
	void demoTest() {
		System.out.println(driver.toString().replaceAll("[(].*[)]", ""));
		driver.navigate().to(url);
		MyTestUtils.pause(1);
	}

}
