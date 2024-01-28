package tests.selenium.demo;

import org.openqa.selenium.By;

public class DemoUI {

	public static void main(String[] args) {
		By locator = null;
		locator = By.id("id");
		locator = By.name("name");
		locator = By.className("class");
		locator = By.tagName("button");
		locator = By.cssSelector("input[id='password']");
		locator = By.linkText("click here");
		locator = By.partialLinkText("click");
		locator = By.xpath("//input[@id='password']");
		System.out.println(locator);
	}

}
