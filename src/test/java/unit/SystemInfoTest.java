package unit;

import java.util.Map.Entry;
import java.util.Properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;

import utilities.MyTestUtils;

public class SystemInfoTest {

	@SuppressWarnings("unused")
	private boolean runSystem() {
		return false;
	}

	@Test
	@Tag("sys")
	@EnabledIf(value = "runSystem")
	void runTest() {
		Properties p = System.getProperties();
		for (Entry<Object, Object> element : p.entrySet()) {
			System.out.println(String.format("%s --> %s", element.getKey(), element.getValue()));
		}
	}

	@Test
	void importantSysDataTest() {
		Properties p = System.getProperties();
		System.out.println(String.format("%s: %s", "OS name", p.get("os.name")));
		System.out.println(String.format("%s: %s", "Chip type", p.get("os.arch")));
		System.out.println(String.format("%s: %s", "Java version", p.get("java.version")));
		System.out.println(String.format("%s: %s", "Project directory", MyTestUtils.getCurrentDir()));
	}

}
