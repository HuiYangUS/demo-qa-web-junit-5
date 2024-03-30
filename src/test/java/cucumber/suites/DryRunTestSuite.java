package cucumber.suites;

import static io.cucumber.junit.platform.engine.Constants.*;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
// Location of features' directory using 'dir_name/dir_name'
@SelectClasspathResource("features")
// Location of step_definitions' directory using 'dir_name.dir_name'
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "cucumber.hooks.web, cucumber.step_definitions")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = EXECUTION_DRY_RUN_PROPERTY_NAME, value = "true")
// Use "and", "or"
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@test")
public class DryRunTestSuite {
    // WARN: Nothing should be written here.
}
