package unit;

import org.junit.jupiter.api.Test;

import utilities.Cat;
import utilities.DataManager;
import utilities.MyPrinter;

@SuppressWarnings("unused")
public class SingletonTest extends BaseTest {

	@Test
	void runTest() {
		MyPrinter.printLine("Original Count: " + DataManager.getCount());
		DataManager dm1 = DataManager.getInstance();
		MyPrinter.printLine("Count: " + DataManager.getCount());
		DataManager dm2 = DataManager.getInstance();
		MyPrinter.printLine("Count: " + DataManager.getCount());
	}

	@Test
	void runCatTest() {
		MyPrinter.printLine("Count: " + Cat.getCount());
		Cat cat1 = new Cat();
		MyPrinter.printLine("Count: " + Cat.getCount());
		Cat cat2 = new Cat();
		MyPrinter.printLine("Count: " + Cat.getCount());
	}

}
