package unit.check;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class MapTest {

	@Test
	void runTest() {
		System.out.println(
				new HashMap<String, Integer>(Map.ofEntries(new AbstractMap.SimpleEntry<String, Integer>("vanilla", 4),
						new AbstractMap.SimpleEntry<String, Integer>("chocolate", 2))));
	}

	@Test
	void withoutDemoTest() {
		Map<String, Double> data = new HashMap<>();
		data.put("hot", 3.3);
		data.put("cold", -4.5);
		System.out.println(data);
	}

}
