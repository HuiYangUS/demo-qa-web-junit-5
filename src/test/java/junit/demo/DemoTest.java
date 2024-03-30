package junit.demo;

import java.util.Set;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

import utils.SimplePrinter;

public class DemoTest {

    @Test
    @Disabled
    @Tags({ @Tag("demo") })
    void runTest() {
	Assumptions.assumeTrue(false);
    }

    @Test
    @DisplayName("Runtime Exception Demo Test")
    void demoTest() {
	SimplePrinter.printLine(null);
    }

    @BeforeEach
    void setUpA(TestInfo testInfo) {
	String name = testInfo.getDisplayName();
	System.out.println(name);
	Set<String> tags = testInfo.getTags();
	if (tags.contains("demo"))
	    System.out.println("This a demo test.");
	System.out.println("A");
    }

    @BeforeEach
    void setUpB(TestReporter testReporter) {
	System.out.println("B");
    }

    @BeforeEach
    void setUpC() {
	System.out.println("C");
    }

}
