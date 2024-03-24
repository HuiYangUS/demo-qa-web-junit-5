package ui.demo;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWebTest {

    @Test
    void runTest() {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	driver.navigate().to("https://www.google.com/");
	try {
	    Thread.sleep(3000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	driver.quit();
    }

}
