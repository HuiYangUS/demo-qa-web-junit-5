package unit;

import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import utilities.ExcelReader;

public class ExcelReaderTest {

	@ParameterizedTest
	@MethodSource("dataProvider")
	void runDemoTest(Map<?, ?> dataRow) {
		System.out.println(String.format("Full name: %s %s.", dataRow.get("firstName"), dataRow.get("lastName")));
	}

	static Stream<Object> dataProvider() {
		return Stream.of(ExcelReader.getData("pseudo_candy_company", "employees"));
	}

}
