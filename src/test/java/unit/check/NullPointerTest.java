package unit.check;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import utils.AppTestUtils;
import utils.TestConfigReader;

public class NullPointerTest {

    @Test
    @Disabled("Done")
    void runTest() {
	String value = null;
	assertTrue(value == null);
	System.out.println("Test passed.");
    }

    @Test
    @Disabled("Done")
    void emptyDirTest() {
	String targetDirPath = "target/demo";
	System.out.println(new File(targetDirPath).exists());
	if (!new File(targetDirPath).exists())
	    new File(targetDirPath).mkdir();
    }

    @Test
    void configReaderTest() {
	System.out.println(TestConfigReader.getTextValue("config", "author"));
	System.out.println(TestConfigReader.getTextValue("config", "age"));
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void getDriverDirTest() {
	System.out.println(AppTestUtils.getCurrentDir());
	String safariDriverFilePath = "/usr/bin/safaridriver";
	System.out.println(!new File(safariDriverFilePath).exists());
    }

}
