package ui.base.config;

import java.util.Optional;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class BrowserTestConfig implements BeforeEachCallback {

	@Override
	public void beforeEach(ExtensionContext context) throws Exception {
		Optional<String> data = context.getConfigurationParameter("browser");
		if (data.isPresent())
			System.setProperty("browser", data.get());
	}

}
