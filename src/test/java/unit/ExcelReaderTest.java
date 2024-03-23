package unit;

import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import utils.ExcelReader;

public class ExcelReaderTest {

    @ParameterizedTest
    @MethodSource("dataProvider")
    void runDemoTest(Map<?, ?> dataRow) {
	System.out.println(String.format("Employee: %s %s, %s, %s.", dataRow.get("firstName"), dataRow.get("lastName"),
		dataRow.get("empID"), dataRow.get("department")));
    }

    static Stream<Object> dataProvider() {
	return Stream.of(ExcelReader.getData("pseudo_candy_company", "employees"));
    }

}
