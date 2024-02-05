package cucumber.hooks.test;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TestHook {

	@Before()
	public void setUp() {
		System.out.println("Test starts:");
	}

	@After()
	public void tearDown() {
		System.out.println("Test completed.");
	}

}
