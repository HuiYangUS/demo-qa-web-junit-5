package unit;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import utilities.MyPrinter;

@TestMethodOrder(OrderAnnotation.class)
public class OrderTest extends Base {

	@Test
	@Order(value = 3)
	void runATest() {
		MyPrinter.printLine("This the 1st demo test.");
	}

	@Test
	@Order(value = 1)
	void runBTest() {
		MyPrinter.printLine("This the 2nd demo test.");
	}

	@Test
	@Order(value = 2)
	void runCTest() {
		MyPrinter.printLine("This the 3rd demo test.");
	}

}
