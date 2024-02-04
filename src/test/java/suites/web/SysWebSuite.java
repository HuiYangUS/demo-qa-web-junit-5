package suites.web;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

import ui.demo.AutoDriverTest;
import unit.SysInfoTest;

@Suite
@SuiteDisplayName("System Data")
@SelectClasses(value = { AutoDriverTest.class, SysInfoTest.class })
@IncludeTags(value = { "sys" })
public class SysWebSuite {

}
