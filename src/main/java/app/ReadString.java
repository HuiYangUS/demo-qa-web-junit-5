package app;

import utils.AppConfigReader;

public class ReadString {

    private static String originText = AppConfigReader.getValue("config", "text");

    public static void main(String[] args) {
	System.out.println(originText.replace("\"", "").replace("\\", "/"));
    }

}
