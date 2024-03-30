package junit.demo;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;
import org.junit.jupiter.params.provider.MethodSource;

public class DataDrivenWithStream {

    @ParameterizedTest
    @MethodSource("fruitsDataProvider")
    void runFruitsTest(String fruit) {
	System.out.println(String.format("Fruit: %s.", fruit));
    }

    static Stream<String> fruitsDataProvider() {
	return Stream.of("apple", "peach", "orange", "banana");
    }

    @ParameterizedTest
    @MethodSource("drinkingAgeDataProvider")
    void runDrinkingAgeTest(String person, int age, boolean canLegallyDrink) {
	assertTrue(canLegallyDrink == age >= 21, "Invalid data for drinking age.");
	if (canLegallyDrink)
	    System.out.println(String.format("%s is %d and a beer drinker.", person, age));
	else
	    System.out.println(String.format("%s is %d and is not a beer drinker but can have milk.", person, age));
    }

    static Stream<Arguments> drinkingAgeDataProvider() {
	// Arguments is a Junit data structure class
	return Stream.of(arguments("Robert", 36, true), arguments("Mary", 6, false), arguments("John", 44, true));
    }

}
