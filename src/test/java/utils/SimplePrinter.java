package utils;

public class SimplePrinter {

	public static void printLine(String text) {
		try {
			if (text == null)
				throw new Exception();
			System.out.println(text);
		} catch (Exception e) {
			throw new RuntimeException("Cannot print null.");
		}
	}

}
