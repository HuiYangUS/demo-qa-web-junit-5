package ui.boratech;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ui.base.web.DriverFactoryWebBase;
import utilities.ConfigReader;
import utilities.MyTestUtils;

public class AddTest extends DriverFactoryWebBase {

	private static String boratechURL = ConfigReader.getValue("boratech", "url");
	private static String email = ConfigReader.getValue("boratech", "email");
	private static String password = ConfigReader.getValue("boratech", "password");

	@Test
	@Tags(value = { @Tag("exp"), @Tag("neg") })
	void addExperience1stNegativeTest() {
		driver.navigate().to(boratechURL);
		driver.findElement(By.xpath("//div[@class='buttons']/a[@href='/login']")).click();
		wait.until(ExpectedConditions.urlContains("/login"));
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).submit();
		wait.until(ExpectedConditions.urlContains("/dashboard"));
		driver.findElement(By.xpath("//a[@href='/add-experience']")).click();
		wait.until(ExpectedConditions.urlContains("/add-experience"));
		By errorAlertByLocater = By.xpath("//div[@class='alert alert-danger']");
		assertEquals(0, driver.findElements(errorAlertByLocater).size(), "Incorrect timing of error messages.");
		driver.findElement(By.xpath("//input[@type='submit']")).submit();
		wait.until(ExpectedConditions.numberOfElementsToBe(errorAlertByLocater, 3));
		List<WebElement> errorAlertElements = driver.findElements(errorAlertByLocater);
		for (WebElement webElement : errorAlertElements)
			System.out.println("Alert: " + webElement.getText());
	}

	@Test
	@Tags(value = { @Tag("edu"), @Tag("neg") })
	void addEducation1stNegativeTest() {
		driver.navigate().to(boratechURL);
		driver.findElement(By.xpath("//div[@class='buttons']/a[@href='/login']")).click();
		wait.until(ExpectedConditions.urlContains("/login"));
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).submit();
		wait.until(ExpectedConditions.urlContains("/dashboard"));
		driver.findElement(By.xpath("//a[@href='/add-education']")).click();
		wait.until(ExpectedConditions.urlContains("/add-education"));
		By errorAlertByLocater = By.xpath("//div[@class='alert alert-danger']");
		assertEquals(0, driver.findElements(errorAlertByLocater).size(), "Incorrect timing of error messages.");
		driver.findElement(By.xpath("//input[@type='submit']")).submit();
		wait.until(ExpectedConditions.numberOfElementsToBe(errorAlertByLocater, 4));
		List<WebElement> errorAlertElements = driver.findElements(errorAlertByLocater);
		for (WebElement webElement : errorAlertElements)
			System.out.println("Alert: " + webElement.getText());
	}

	@Test
	@Tags(value = { @Tag("exp"), @Tag("pos") })
	@DisabledIfSystemProperty(named = "browser", matches = "firefox", disabledReason = "Date input field needs to be fixed in Firefox.")
	void addExperience1stPositiveTest() {
		driver.navigate().to(boratechURL);
		driver.findElement(By.xpath("//div[@class='buttons']/a[@href='/login']")).click();
		wait.until(ExpectedConditions.urlContains("/login"));
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).submit();
		wait.until(ExpectedConditions.urlContains("/dashboard"));
		By dataRowByLocator = By.xpath("//table/thead/tr/th[text()='Title']/ancestor::table/tbody/tr");
		List<WebElement> dataTableRows = driver.findElements(dataRowByLocator);
		int count = dataTableRows.size();
		driver.findElement(By.xpath("//a[@href='/add-experience']")).click();
		wait.until(ExpectedConditions.urlContains("/add-experience"));
		By successAlertByLocater = By.xpath("//div[@class='alert alert-success']");
		String jobTitle = "Cashier - " + MyTestUtils.getTimeStamp();
		String company = "Walmart";
		String[] dateData = LocalDate.now().toString().split("-");
		String today = dateData[1] + dateData[2] + dateData[0];
		driver.findElement(By.name("title")).sendKeys(jobTitle);
		driver.findElement(By.name("company")).sendKeys(company);
		driver.findElement(By.name("from")).sendKeys(today);
		driver.findElement(By.name("current")).click();
		wait.until(ExpectedConditions.attributeToBe(By.name("current"), "value", "true"));
		driver.findElement(By.xpath("//input[@type='submit']")).submit();
		wait.until(ExpectedConditions.urlContains("/dashboard"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(successAlertByLocater));
		Document doc = Jsoup.parse(driver.getPageSource());
		Elements alertElements = doc.getElementsByAttributeValueContaining("class", "alert");
		if (alertElements.size() == 1)
			System.out.println(alertElements.get(0).className());
		System.out.println(driver.findElement(successAlertByLocater).getText());
		int index = 1;
		dataTableRows = driver.findElements(dataRowByLocator);
		if (count < 20)
			assertEquals(count + 1, dataTableRows.size(), "Expected numbers of data rows do not match.");
		boolean targetFound = false;
		for (WebElement webElement : dataTableRows) {
			String actualTitle = webElement.findElements(By.tagName("td")).get(index).getText();
			if (actualTitle.equalsIgnoreCase(jobTitle)) {
				targetFound = true;
				System.out.println("Target: " + actualTitle);
				break;
			}
		}
		assertTrue(targetFound, "Entered data is not found.");
	}

	@Test
	@Tags(value = { @Tag("exp"), @Tag("pos") })
	@DisabledIfSystemProperty(named = "browser", matches = "firefox", disabledReason = "Date input field needs to be fixed in Firefox.")
	void addExperience2ndPositiveTest() {
		driver.navigate().to(boratechURL);
		driver.findElement(By.xpath("//div[@class='buttons']/a[@href='/login']")).click();
		wait.until(ExpectedConditions.urlContains("/login"));
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).submit();
		wait.until(ExpectedConditions.urlContains("/dashboard"));
		By dataRowByLocator = By.xpath("//table/thead/tr/th[text()='Title']/ancestor::table/tbody/tr");
		List<WebElement> dataTableRows = driver.findElements(dataRowByLocator);
		int count = dataTableRows.size();
		driver.findElement(By.xpath("//a[@href='/add-experience']")).click();
		wait.until(ExpectedConditions.urlContains("/add-experience"));
		By successAlertByLocater = By.xpath("//div[@class='alert alert-success']");
		String jobTitle = "Cashier - " + MyTestUtils.getTimeStamp();
		String company = "Walmart";
		String[] dateData = LocalDate.now().toString().split("-");
		String today = dateData[1] + dateData[2] + dateData[0];
		driver.findElement(By.name("title")).sendKeys(jobTitle);
		driver.findElement(By.name("company")).sendKeys(company);
		driver.findElement(By.name("from")).sendKeys(today);
		driver.findElement(By.name("current")).click();
		wait.until(ExpectedConditions.attributeToBe(By.name("current"), "value", "true"));
		driver.findElement(By.xpath("//input[@type='submit']")).submit();
		wait.until(ExpectedConditions.urlContains("/dashboard"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(successAlertByLocater));
		Document doc = Jsoup.parse(driver.getPageSource());
		Elements alertElements = doc.getElementsByAttributeValueContaining("class", "alert");
		if (alertElements.size() == 1)
			System.out.println(alertElements.get(0).className());
		System.out.println(driver.findElement(successAlertByLocater).getText());
		// HTML table index does not start at 0
		int index = 2;
		dataTableRows = driver.findElements(dataRowByLocator);
		if (count < 20)
			assertEquals(count + 1, dataTableRows.size(), "Expected numbers of data rows do not match.");
		boolean targetFound = false;
		for (WebElement webElement : dataTableRows) {
			String actualTitle = webElement.findElement(By.xpath(String.format("td[%d]", index))).getText();
			if (actualTitle.equalsIgnoreCase(jobTitle)) {
				targetFound = true;
				System.out.println("Target: " + actualTitle);
				break;
			}
		}
		assertTrue(targetFound, "Entered data is not found.");
	}

}
