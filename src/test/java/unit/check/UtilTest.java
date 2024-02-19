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

}
