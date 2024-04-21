package ui.suites;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

import ui.demo.LoginTest;

@Suite
@SuiteDisplayName("Demo Firefox Web Test")
@SelectClasses(value = { LoginTest.class })
@ConfigurationParameter(key = "browser", value = "firefox")
public class FirefoxTestSuite {
	// WARN: Nothing should be written here.
}
