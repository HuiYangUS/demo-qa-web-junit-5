package suites.headless;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.ConfigurationParameter;

@Suite
@SuiteDisplayName("Headless Chrome Test")
@SelectPackages(value = { "ui.demo" })
@IncludeTags(value = { "ui" })
@ConfigurationParameter(key = "browser", value = "chrome")
@ConfigurationParameter(key = "headless", value = "true")
public class HeadlessChromeTest {
    // WARN: Nothing should be written here.
}
