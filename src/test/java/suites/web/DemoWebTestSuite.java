package suites.web;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Web Test")
@SelectPackages(value = { "ui.demo" })
@IncludeTags(value = { "ui" })
public class DemoWebTestSuite {

}
