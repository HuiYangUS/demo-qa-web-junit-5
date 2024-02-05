package cucumber.suites;

import static io.cucumber.junit.platform.engine.Constants.*;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/demo")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "cucumber.hooks.test, cucumber.hooks.config, cucumber.step_definitions.demo")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-reports/cucumber.html")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@ui and @test")
@ConfigurationParameter(key = "pet", value = "cat")
public class DemoTestSuite {

}
