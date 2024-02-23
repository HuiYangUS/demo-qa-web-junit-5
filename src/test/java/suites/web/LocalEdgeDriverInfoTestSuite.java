package suites.web;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

import ui.demo.metadata.DriverDataTest;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.IncludeTags;

@Suite
@SuiteDisplayName(value = "Local Edge Driver")
@SelectClasses(value = { DriverDataTest.class })
@IncludeTags(value = { "local & edge" })
public class LocalEdgeDriverInfoTestSuite {

}
