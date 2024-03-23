package ui.demo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import ui.base.web.DriverFactoryWebBase;
import utils.AppTestUtils;

/**
 * Tests using <DriverFactoryM> for automatic updated drivers
 */
public class DriverFactoryMTest extends DriverFactoryWebBase {

    @BeforeAll
    static void useMType() {
	System.setProperty("driverFactoryType", "m");
    }

    String url = "https://junit.org/junit5/docs/current/user-guide/";

    @Test
    @DisplayName("Driver Facotry M Test")
    @Tags(value = { @Tag("m"), @Tag("ui") })
    void runTest() {
	System.out.println(driver.toString().replaceAll("[(].*[)]", ""));
	driver.navigate().to(url);
	AppTestUtils.pause(1);
    }

    @Test
    @DisplayName("Driver Facotry M Test")
    @Tags(value = { @Tag("m"), @Tag("ui"), @Tag("demo") })
    void demoTest() {
	System.out.println(driver.toString().replaceAll("[(].*[)]", ""));
	driver.navigate().to(url);
	AppTestUtils.pause(1);
    }

}
