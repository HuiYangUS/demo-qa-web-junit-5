package ui.base.web;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import ui.base.configs.SimpleReportExtension;
import ui.base.configs.WebTestConfig;
import utils.AppTestUtils;
import utils.DataManager;
import utils.DriverManager;
import utils.PageManager;
import utils.WebUtils;

@ExtendWith({ WebTestConfig.class, SimpleReportExtension.class })
public class DriverFactoryWebBase {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static PageManager pages;
    protected static DataManager dataManager;
    protected static WebUtils utils;

    @BeforeEach
    protected void setUp() {
	driver = DriverManager.getDriver();
	wait = new WebDriverWait(driver, Duration.ofSeconds(AppTestUtils.getTestConfigWaitTime()));
	utils = new WebUtils(driver);
	pages = PageManager.getInstance();
	dataManager = DataManager.getInstance();
    }

    @AfterEach
    protected void tearDown() {
	DriverManager.reset();
	PageManager.reset();
	DataManager.reset();
    }

}
