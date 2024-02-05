package suites.crossbrowser;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Chrome Test")
@SelectPackages(value = { "ui.demo" })
@IncludeTags(value = { "ui" })
@ConfigurationParameter(key = "browser", value = "chrome")
public class ChromeTest {

}
