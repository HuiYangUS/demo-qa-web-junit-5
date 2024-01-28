package cucumber.hooks.firefox;

import io.cucumber.java.BeforeAll;

public class FirefoxWebHook {

	@BeforeAll(order = -1)
	public static void beforeAllTestConfig() {
		System.setProperty("browser", "firefox");
	}

}
