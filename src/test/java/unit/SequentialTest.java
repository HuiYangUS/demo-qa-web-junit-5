package unit;

import org.junit.jupiter.api.Test;

import utilities.MyPrinter;

public class SequentialTest extends Base {

	@Test
	void runATest() {
		MyPrinter.printLine("This the 1st demo test.");
	}

	@Test
	void runBTest() {
		MyPrinter.printLine("This the 2nd demo test.");
	}

	@Test
	void runCTest() {
		MyPrinter.printLine("This the 3rd demo test.");
	}

}
