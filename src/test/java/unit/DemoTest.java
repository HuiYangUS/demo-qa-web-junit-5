package unit;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import utilities.SimplePrinter;

public class DemoTest extends BaseTest {

	@Test
	void runTest() {
		System.out.println("This is a demo test.");
	}

	@Test
	@Tag("cat")
	void catTest() {
		SimplePrinter.printLine("This is a cat.");
	}

	@Test
	@Tags({ @Tag("dog"), @Tag("pet") })
	void dogTest() {
		SimplePrinter.printLine("This is a dog.");
		SimplePrinter.printLine("I want a dog as my pet.");
	}

}
