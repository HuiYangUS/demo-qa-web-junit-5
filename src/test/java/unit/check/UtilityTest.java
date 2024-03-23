package unit.check;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utils.AppTestUtils;

public class UtilityTest {

    @Test
    void isIntTest() {
	assertTrue(AppTestUtils.isInt("5"), "<5> is an integer number.");
	assertFalse(AppTestUtils.isInt("five"), "<five> is not an integer number.");
    }

    @Test
    void isValidDateTest() {
	assertFalse(AppTestUtils.isValidDate("2000", "4th", "5"), "Invalid date.");
	assertFalse(AppTestUtils.isValidDate("2000", "4", "31"), "Invalid date.");
    }

    @Test
    void stringToMapTest() {
	String expectedText = "{badInput=false, customError=false, patternMismatch=false, rangeOverflow=false, rangeUnderflow=false, stepMismatch=false, tooLong=false, tooShort=false, typeMismatch=false, valid=false, valueMissing=true}";
	assertTrue(AppTestUtils.stringToMap(expectedText).toString().equals(expectedText),
		"Failed to convert string to map.");
    }

}
