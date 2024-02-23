package unit.myapps.dotest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myapps.doapp.DoMath;

public class DoMathTest {

	@Test
	void searchTest() {
		assertFalse(DoMath.search(5, new int[] {}), "Array is empty.");
		assertFalse(DoMath.search(5, null), "Array is null.");
		assertFalse(DoMath.search(5, new int[] { 7, 8 }), "Target is not in the array.");
		assertTrue(DoMath.search(5, new int[] { 7, 5 }), "Target is in the array.");
	}

}
