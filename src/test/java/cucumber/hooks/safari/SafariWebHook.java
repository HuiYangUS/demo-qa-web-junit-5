package cucumber.hooks.safari;

import io.cucumber.java.BeforeAll;

public class SafariWebHook {

	@BeforeAll(order = 1)
	public static void beforeAllTestConfig() {
		System.setProperty("browser", "safari");
	}

}
