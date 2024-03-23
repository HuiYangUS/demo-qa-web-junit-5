package unit;

import org.junit.jupiter.api.Test;

import utils.SimplePrinter;

public class SequentialTest extends BaseTest {

    @Test
    void runATest() {
	SimplePrinter.printLine("This the 1st demo test.");
    }

    @Test
    void runBTest() {
	SimplePrinter.printLine("This the 2nd demo test.");
    }

    @Test
    void runCTest() {
	SimplePrinter.printLine("This the 3rd demo test.");
    }

}
