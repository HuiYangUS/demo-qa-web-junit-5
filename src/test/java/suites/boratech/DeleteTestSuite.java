package suites.boratech;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import ui.boratech.DeleteTest;

@Suite
@SelectClasses(value = { DeleteTest.class })
@ConfigurationParameter(key = "headless", value = "true")
@IncludeTags(value = { "exp" })
public class DeleteTestSuite {

}
