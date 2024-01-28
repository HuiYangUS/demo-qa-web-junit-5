package cucumber.hooks.chrome;

import io.cucumber.java.BeforeAll;

public class ChromeWebHook {

	@BeforeAll(order = 0)
	public static void beforeAllTestConfig() {
		System.setProperty("browser", "chrome");
	}

}
