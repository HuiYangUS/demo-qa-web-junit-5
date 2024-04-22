package junit.demo;

import org.junit.jupiter.api.Test;

import junit.base.BaseTest;
import utils.SimplePrinter;

public class SequentialTest extends BaseTest {

	@Test
	void runTestA() {
		SimplePrinter.printLine("This is the 1st demo test.");
	}

	@Test
	void runTestB() {
		SimplePrinter.printLine("This is the 2nd demo test.");
	}

	@Test
	void runTestC() {
		SimplePrinter.printLine("This is the 3rd demo test.");
	}

}
