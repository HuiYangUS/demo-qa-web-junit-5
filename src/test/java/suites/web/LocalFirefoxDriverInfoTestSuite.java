package suites.web;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.IncludeTags;

import ui.metadata.DriverDataTest;

@Suite
@SuiteDisplayName(value = "Local Firefox Driver Test")
@SelectClasses(value = { DriverDataTest.class })
@IncludeTags(value = { "local & firefox" })
public class LocalFirefoxDriverInfoTestSuite {

}
