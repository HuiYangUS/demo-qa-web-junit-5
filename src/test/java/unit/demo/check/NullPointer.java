package unit.demo.check;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

public class NullPointer {

	@Test
	void runTest() {
		String value = null;
		assertTrue(value == null);
		System.out.println("Test passed.");
	}

	@Test
	void emptyDirTest() {
		String targetDirPath = "target/demo";
		System.out.println(new File(targetDirPath).exists());
		if (!new File(targetDirPath).exists())
			new File(targetDirPath).mkdir();
	}

}
