package unit.check;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utilities.MyTestUtils;

public class UtilTest {

	@Test
	void isIntTest() {
		assertTrue(MyTestUtils.isInt("5"), "<5> is an integer number.");
		assertFalse(MyTestUtils.isInt("five"), "<five> is not an integer number.");
	}

	@Test
	void isValidDateTest() {
		assertFalse(MyTestUtils.isValidDate("2000", "4th", "5"), "Invalid date.");
		assertFalse(MyTestUtils.isValidDate("2000", "4", "31"), "Invalid date.");
	}

	@Test
	void stringToMapTest() {
		String expectedText = "{badInput=false, customError=false, patternMismatch=false, rangeOverflow=false, rangeUnderflow=false, stepMismatch=false, tooLong=false, tooShort=false, typeMismatch=false, valid=false, valueMissing=true}";
		assertTrue(MyTestUtils.stringToMap(expectedText).toString().equals(expectedText),
				"Failed to convert string to map.");
	}

}
