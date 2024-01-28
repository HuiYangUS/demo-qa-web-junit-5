package unit;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import utilities.MyPrinter;

public class DemoTest extends Base {

	@Test
	void runTest() {
		System.out.println("This is a demo test.");
	}

	@Test
	@Tag("cat")
	void catTest() {
		MyPrinter.printLine("This is a cat.");
	}

	@Test
	@Tags({ @Tag("dog"), @Tag("pet") })
	void dogTest() {
		MyPrinter.printLine("This is a dog.");
		MyPrinter.printLine("I want a dog as my pet.");
	}

}
