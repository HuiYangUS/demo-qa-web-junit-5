package app;

import utils.ConfigReader;

public class ReadString {

    private static String originText = ConfigReader.getValue("config", "text");

    public static void main(String[] args) {
	System.out.println(originText.replace("\"", "").replace("\\", "/"));
    }

}
