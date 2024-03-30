package app;

import utils.AppConfigReader;

public class ReadStringToUpper {

    private static String originText = AppConfigReader.getValue("config", "lowerText");

    public static void main(String[] args) {
	System.out.println(originText.toUpperCase());
    }

}
