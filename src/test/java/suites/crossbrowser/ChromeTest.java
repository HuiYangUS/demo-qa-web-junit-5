package suites.crossbrowser;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Chrome Test")
@SelectPackages(value = { "ui.base.config", "ui.demo" })
@IncludeTags(value = { "ui", "chrome" })
public class ChromeTest {

}
