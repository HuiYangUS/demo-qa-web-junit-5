package ui.lab;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

import ui.demo.ForParallelTest;

@Suite
@SuiteDisplayName("Parallel Demo Web Test")
@SelectClasses({ ForParallelTest.class })
@ConfigurationParameter(key = "junit.jupiter.execution.parallel.enabled", value = "true")
@ConfigurationParameter(key = "junit.jupiter.execution.parallel.mode.default", value = "concurrent")
@ConfigurationParameter(key = "junit.jupiter.execution.parallel.config.strategy", value = "fixed")
@ConfigurationParameter(key = "junit.jupiter.execution.parallel.config.fixed.parallelism", value = "2")
@ConfigurationParameter(key = "junit.jupiter.execution.parallel.config.fixed.max-pool-size", value = "3")
public class ExperimentalParallelTestSuite {
	// WARN: Nothing should be written here.
}
