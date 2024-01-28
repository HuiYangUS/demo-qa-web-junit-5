package suites.web;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Cross Browser Test")
@SelectPackages("suites.crossbrowser")
public class CrossBrowserTestSuite {

}
