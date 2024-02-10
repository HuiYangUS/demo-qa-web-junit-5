package unit.check;

public class Temp {

	public static void main(String[] args) {
		String userDir = System.getProperty("user.dir");
		String tempStr = userDir.substring(9);
		int index = -1;
		if (tempStr.contains("\\"))
			index = tempStr.indexOf("\\");
		else
			index = tempStr.indexOf("/");
		String resultStr = tempStr.substring(0, index);
		System.out.println(resultStr);
	}

}
