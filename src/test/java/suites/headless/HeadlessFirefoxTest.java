package suites.headless;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.ConfigurationParameter;

@Suite
@SuiteDisplayName("Headless Firefox Test")
@SelectPackages(value = { "ui.demo" })
@IncludeTags(value = { "ui" })
@ConfigurationParameter(key = "browser", value = "firefox")
@ConfigurationParameter(key = "headless", value = "true")
public class HeadlessFirefoxTest {
    // WARN: Nothing should be written here.
}
