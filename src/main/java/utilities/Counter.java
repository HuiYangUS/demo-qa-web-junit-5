package utilities;

public class Counter {

	private static int count;

	public static void count() {
		count = getCount() + 1;
	}

	public static void resetCount() {
		count = 0;
	}

	public static int getCount() {
		return count;
	}

}
