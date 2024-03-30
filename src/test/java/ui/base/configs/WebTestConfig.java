package ui.base.configs;

import java.util.Optional;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import utils.AppTestUtils;
import utils.TestKeys;

public class WebTestConfig implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
	Optional<String> driverFactoryData = context.getConfigurationParameter(TestKeys.DRIVER_FACTORY_TYPE_KEY);
	if (driverFactoryData.isPresent())
	    System.setProperty(TestKeys.DRIVER_FACTORY_TYPE_KEY, driverFactoryData.get());
	Optional<String> browserData = context.getConfigurationParameter(TestKeys.BROWSER_KEY);
	if (browserData.isPresent())
	    System.setProperty(TestKeys.BROWSER_KEY, browserData.get());
	Optional<String> headlessData = context.getConfigurationParameter(TestKeys.HEADLESS_KEY);
	if (headlessData.isPresent())
	    System.setProperty(TestKeys.HEADLESS_KEY, headlessData.get());
	Optional<String> deviceData = context.getConfigurationParameter(TestKeys.DEVICE_NAME_KEY);
	if (deviceData.isPresent())
	    System.setProperty(TestKeys.DEVICE_NAME_KEY, deviceData.get());
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
	AppTestUtils.testConfigReset();
	String testName = context.getDisplayName().replaceAll("[(].*[)]", "");
	if (context.getExecutionException().isPresent())
	    System.out.println(testName + " has failed.");
	else
	    System.out.println(testName + " passed.");
	System.out.println();
    }

}
