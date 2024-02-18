package suites.boratech;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import ui.boratech.WarmUpTest;

@Suite
@SelectClasses(value = { WarmUpTest.class })
@ConfigurationParameter(key = "headless", value = "true")
public class WarmUpTestSuite {

}
