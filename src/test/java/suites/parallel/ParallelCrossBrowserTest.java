package suites.parallel;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

import suites.crossbrowser.ChromeTest;
import suites.crossbrowser.EdgeTest;
import suites.crossbrowser.FirefoxTest;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.ConfigurationParameter;

@Suite
@SuiteDisplayName("Parallel Cross Browser Test")
@SelectClasses(value = { ChromeTest.class, EdgeTest.class, FirefoxTest.class })
@ConfigurationParameter(key = "junit.jupiter.execution.parallel.enabled", value = "true")
@ConfigurationParameter(key = "junit.jupiter.execution.parallel.config.strategy", value = "fixed")
@ConfigurationParameter(key = "junit.jupiter.execution.parallel.config.fixed.parallelism", value = "3")
@ConfigurationParameter(key = "junit.jupiter.execution.parallel.config.fixed.max-pool-size", value = "3")
public class ParallelCrossBrowserTest {
    // WARN: Nothing should be written here.
}
