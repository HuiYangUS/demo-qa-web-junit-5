package suites.web;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.IncludeTags;

import ui.demo.DriverDataTest;

@Suite
@SuiteDisplayName(value = "Local Chrome Driver")
@SelectClasses(value = { DriverDataTest.class })
// operators: ! == (not), & == (and), | == (or).
@IncludeTags(value = { "local & chrome" })
public class LocalChromeDriverInfoTestSuite {

}
