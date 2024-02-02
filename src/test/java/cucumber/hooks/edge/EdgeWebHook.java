package cucumber.hooks.edge;

import io.cucumber.java.BeforeAll;

public class EdgeWebHook {

	@BeforeAll(order = 1)
	public static void beforeAllTestConfig() {
		System.setProperty("browser", "edge");
	}

}
