package app;

import utils.AppConfigsReader;

public class ReadStringToUpper {

	private static String originText = AppConfigsReader.getValue("config", "lowerText");

	public static void main(String[] args) {
		System.out.println(originText.toUpperCase());
	}

}
