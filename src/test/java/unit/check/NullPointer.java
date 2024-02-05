package unit.check;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import utilities.ConfigReader;
import utilities.MyTestUtils;

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

	@Test
	void configReaderTest() {
		System.out.println(ConfigReader.getValue("config", "grid"));
		System.out.println(ConfigReader.getValue("config", "remote"));
		System.out.println(ConfigReader.getValue("config", "age"));
	}

	@Test
	void getDriverDirTest() {
		System.out.println(MyTestUtils.getCurrentDir());
		String safariDriverFilePath = "/usr/bin/safaridriver";
		System.out.println(!new File(safariDriverFilePath).exists());
	}

}
