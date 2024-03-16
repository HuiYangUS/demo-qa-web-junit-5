package ui.experiments;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ui.base.web.DriverFactoryWebBase;

public class DriverFactoryOperaTest extends DriverFactoryWebBase {

    @BeforeAll
    static void runOpera() {
	System.setProperty("browser", "opera");
	System.setProperty("headless", "true");
    }

    private String url = "https://www.google.com/";
    private String searchTerm = "Batman";
    private int num = 7;

    @Test
    @DisplayName("Opera Test")
    void runTest() {
	driver.navigate().to(url);
	driver.findElement(By.name("q")).sendKeys(searchTerm + Keys.ENTER);
	By linkByLocator = By.xpath("//div[@id='rso']//a");
	// if 39 does not work, try 29
	try {
	    wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(linkByLocator, 39));
	} catch (Exception e) {
	    wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(linkByLocator, 29));
	}
	List<WebElement> dataList = driver.findElements(linkByLocator);
	System.out.println("Number of links: " + dataList.size());
	if (num <= dataList.size())
	    System.out.println("Target webpage == " + dataList.get(num - 1).getAttribute("href"));
    }

}
