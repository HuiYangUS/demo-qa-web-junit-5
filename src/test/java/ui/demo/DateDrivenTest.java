package ui.demo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import utilities.Browser;
import utilities.MyPrinter;

public class DateDrivenTest {

	@ParameterizedTest
	@EnumSource(Browser.class)
	void run1stTest(Browser browserName) {
		String browser = browserName.name().toLowerCase();
		MyPrinter.printLine(browser);
	}

}
