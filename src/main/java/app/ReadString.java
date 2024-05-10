package app;

import utils.AppConfigsReader;

public class ReadString {

	private static String originText = AppConfigsReader.getValue("config", "text");

	public static void main(String[] args) {
		System.out.println(originText.replace("\"", "").replace("\\", "/"));
	}

}
