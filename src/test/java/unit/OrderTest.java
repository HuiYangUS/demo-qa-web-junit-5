package unit;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import utils.SimplePrinter;

@TestMethodOrder(OrderAnnotation.class)
public class OrderTest extends BaseTest {

    @Test
    @Order(value = 3)
    void runATest() {
	SimplePrinter.printLine("This the 1st demo test.");
    }

    @Test
    @Order(value = 1)
    void runBTest() {
	SimplePrinter.printLine("This the 2nd demo test.");
    }

    @Test
    @Order(value = 2)
    void runCTest() {
	SimplePrinter.printLine("This the 3rd demo test.");
    }

}
