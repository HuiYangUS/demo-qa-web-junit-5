package ui.demo.selenium;

import org.openqa.selenium.By;

public class LocatorDemo {

	public static void main(String[] args) {

	}

	void findLocator() {
		By.id("id");
		By.name("name");
		By.className("class");
		By.tagName("button");
		By.cssSelector("input[id='password']");
		By.linkText("click here");
		By.partialLinkText("click");
		By.xpath("//input[@id='password']");
	}

}
