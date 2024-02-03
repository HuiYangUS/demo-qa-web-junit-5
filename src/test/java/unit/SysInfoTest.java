package unit;

import java.util.Map.Entry;
import java.util.Properties;

import org.junit.jupiter.api.Test;

import utilities.MyTestUtils;

public class SysInfoTest {

	@Test
	void runTest() {
		Properties p = System.getProperties();
		for (Entry<Object, Object> element : p.entrySet()) {
			System.out.println(String.format("%s --> %s", element.getKey(), element.getValue()));
		}
	}

	@Test
	void importantSysDataTest() {
		Properties p = System.getProperties();
		System.out.println(String.format("%s : %s", "OS name", p.get("os.name")));
		System.out.println(String.format("%s : %s", "Chip name", p.get("os.arch")));
		if (p.get("os.name").toString().toLowerCase().contains("windows"))
			System.out.println(String.format("%s : %s", "Chip type", p.get("sun.arch.data.model")));
		System.out.println(String.format("%s : %s", "Java home", p.get("java.home")));
		System.out.println(String.format("%s : %s", "Java version", p.get("java.version")));
		System.out.println(String.format("%s : %s", "Project directory", MyTestUtils.getCurrentDir()));
	}

}
