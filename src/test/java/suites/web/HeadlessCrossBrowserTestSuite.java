package suites.web;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

import suites.headless.HeadlessChromeTest;
import suites.headless.HeadlessEdgeTest;
import suites.headless.HeadlessFirefoxTest;

@Suite
@SuiteDisplayName("Headless Cross Browser Test")
@SelectClasses(value = { HeadlessChromeTest.class, HeadlessEdgeTest.class, HeadlessFirefoxTest.class })
public class HeadlessCrossBrowserTestSuite {
    // WARN: Nothing should be written here.
}
