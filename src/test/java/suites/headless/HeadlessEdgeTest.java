package suites.headless;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.ConfigurationParameter;

@Suite
@SuiteDisplayName("Headless Edge Test")
@SelectPackages(value = { "ui.demo" })
@IncludeTags(value = { "ui" })
@ConfigurationParameter(key = "browser", value = "edge")
@ConfigurationParameter(key = "headless", value = "true")
public class HeadlessEdgeTest {
    // WARN: Nothing should be written here.
}
