package unit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import utilities.MyTestUtils;

public class AutoChromeBrowserTest {

	@Test
	@DisplayName("Auto Chrome Browser Test")
	@EnabledOnOs(OS.WINDOWS)
	void runTest() {
		assertTrue(MyTestUtils.isAutoChromeOnWindowsAvailable(), "Auto chrome browser is not available.");
	}

}
