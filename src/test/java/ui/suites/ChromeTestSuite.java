package ui.suites;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.ConfigurationParameter;

import ui.demo.LoginTest;

@Suite
@SuiteDisplayName("Demo Chrome Web Test")
@SelectClasses(value = { LoginTest.class })
@ConfigurationParameter(key = "browser", value = "chrome")
public class ChromeTestSuite {
	// WARN: Nothing should be written here.
}
