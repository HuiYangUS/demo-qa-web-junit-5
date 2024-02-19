package cucumber.suites.demo;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/demo")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "cucumber.hooks.browsers.firefox, cucumber.hooks.config, cucumber.step_definitions.demo")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@ui")
public class DemoFirefoxTestSuite {

}
