package unit;

import org.junit.jupiter.api.Test;

import utilities.Cat;
import utilities.DataManager;
import utilities.SimplePrinter;

@SuppressWarnings("unused")
public class SingletonTest extends BaseTest {

	@Test
	void runTest() {
		SimplePrinter.printLine("Original Count: " + DataManager.getCount());
		DataManager dm1 = DataManager.getInstance();
		SimplePrinter.printLine("Count: " + DataManager.getCount());
		DataManager dm2 = DataManager.getInstance();
		SimplePrinter.printLine("Count: " + DataManager.getCount());
	}

	@Test
	void runCatTest() {
		SimplePrinter.printLine("Count: " + Cat.getCount());
		Cat cat1 = new Cat();
		SimplePrinter.printLine("Count: " + Cat.getCount());
		Cat cat2 = new Cat();
		SimplePrinter.printLine("Count: " + Cat.getCount());
	}

}
