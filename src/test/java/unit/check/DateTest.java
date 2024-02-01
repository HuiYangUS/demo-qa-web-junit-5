package unit.check;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import utilities.MyTestUtils;

public class DateTest {
	
	@Test
	void runTest() {
		LocalDate date = LocalDate.now();
		System.out.println(date.toString());
	}
	
	@Test
	void runTimestampTest() {
		System.out.println(MyTestUtils.getTimestamp());
	}

}
