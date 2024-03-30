package ui.suites;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeTags;

import ui.demo.LoginTest;

@Suite
@SuiteDisplayName("Demo Firefox Web Test")
@SelectClasses(value = { LoginTest.class })
@ConfigurationParameter(key = "browser", value = "firefox")
@IncludeTags(value = { "web" })
public class FirefoxTestSuite {

}
