package suites.boratech;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import ui.boratech.ApplyTest;

@Suite
@SelectClasses(value = { ApplyTest.class })
@ConfigurationParameter(key = "headless", value = "true")
public class ApplyTestSuite {

}
