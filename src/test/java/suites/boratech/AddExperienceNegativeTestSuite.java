package suites.boratech;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import ui.boratech.AddTest;

@Suite
@SelectClasses(value = { AddTest.class })
@ConfigurationParameter(key = "headless", value = "true")
@IncludeTags(value = { "exp & neg" })
public class AddExperienceNegativeTestSuite {

}
