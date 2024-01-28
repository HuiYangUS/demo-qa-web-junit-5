package unit;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.*;
import org.junit.jupiter.params.provider.MethodSource;

import utilities.Counter;

public class DataDrivenWithStream {

	@ParameterizedTest
	@MethodSource("fruits")
	void runFruit1stTest(String fruit) {
		Counter.count();
		int count = Counter.getCount();
		System.out.println(String.format("Fruit <%d>: %s.", count, fruit));
	}

	static Stream<String> fruits() {
		return Stream.of("apple", "peach", "orange", "banana");
	}

	@ParameterizedTest
	@MethodSource("persons")
	void runDrinkTest(String person, int age, boolean canDrink) {
		if (canDrink)
			System.out.println(String.format("%s is %d and can drink beer.", person, age));
		else
			System.out.println(String.format("%s is %d and can not drink beer but can have milk.", person, age));
	}

	static Stream<Arguments> persons() {
		return Stream.of(

				arguments("Bob", 36, true), arguments("Mary", 6, false), arguments("John", 44, true)

		);
	}

}
