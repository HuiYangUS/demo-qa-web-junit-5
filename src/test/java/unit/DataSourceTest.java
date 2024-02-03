package unit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DataSourceTest extends BaseTest {

	// value source only supports one type per test
	@ParameterizedTest
	@ValueSource(ints = { 1, -1, 4 })
	void runTest(int num) {
		System.out.println("Number --> " + num);
	}

	@ParameterizedTest
	@ValueSource(booleans = { true, false })
	void runBooleanTest(boolean answer) {
		System.out.println(answer ? "good" : "bad");
	}

}
