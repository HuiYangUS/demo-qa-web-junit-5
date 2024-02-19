package cucumber.suites.boratech;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
//location of features' directory using 'dir_name/dir_name'
@SelectClasspathResource("features/boratech")
//location of step_definitions' directory using 'dir_name.dir_name'
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "cucumber.hooks.config, cucumber.step_definitions.boratech")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = EXECUTION_DRY_RUN_PROPERTY_NAME, value = "true")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@test")
public class DryRunBoraTechTestSuite {

}
