package suites.headless;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Headless Edge Test")
@SelectPackages(value = { "ui.base.config", "ui.demo" })
@IncludeTags(value = { "ui", "edge", "headless" })
public class HeadlessEdgeTest {

}
