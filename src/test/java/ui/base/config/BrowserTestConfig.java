package ui.base.config;

import java.util.Optional;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class BrowserTestConfig implements BeforeEachCallback, AfterEachCallback {

	@Override
	public void beforeEach(ExtensionContext context) throws Exception {
		Optional<String> data = context.getConfigurationParameter("browser");
		if (data.isPresent())
			System.setProperty("browser", data.get());
	}

	@Override
	public void afterEach(ExtensionContext context) throws Exception {
		String testName = context.getDisplayName().replaceAll("[(].*[)]", "");
		if (context.getExecutionException().isPresent())
			System.out.println(testName + " has failed.");
		else
			System.out.println(testName + " passed.");
		System.out.println();
	}

}
