package utilities;

public class Cat {

	private static int count;

	public Cat() {
		count++;
	}

	public static int getCount() {
		return count;
	}

}
