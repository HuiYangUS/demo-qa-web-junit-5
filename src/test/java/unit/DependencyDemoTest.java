package unit;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.condition.EnabledIf;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import utilities.MyPrinter;

@TestMethodOrder(OrderAnnotation.class)
public class DependencyDemoTest extends Base {

	static boolean isATestPass = false;

	@Test
	@Order(value = 1)
	void runATest() {
		MyPrinter.printLine("This the 1st demo test.");
		fail();
		isATestPass = true;
	}

	boolean getATestResult() {
		return isATestPass;
	}

	@Test
	@Order(value = 2)
	@EnabledIf(value = "getATestResult")
	void runBTest() {
		MyPrinter.printLine("This the 2nd demo test.");
	}

}
