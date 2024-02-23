package unit;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.condition.EnabledIf;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import utilities.MyPrinter;

@TestMethodOrder(OrderAnnotation.class)
public class DependencyDemoTest extends BaseTest {

	static boolean isAlphaPassed = false;

	@Test
	@Order(value = 1)
	void runAlphaTest() {
		MyPrinter.printLine("This is alpha demo test.");
		isAlphaPassed = true;
	}

	boolean getAlphaResult() {
		return isAlphaPassed;
	}

	@Test
	@Order(value = 2)
	@EnabledIf(value = "getAlphaResult")
	void runOmegaTest() {
		MyPrinter.printLine("This is omega demo test.");
	}

}
