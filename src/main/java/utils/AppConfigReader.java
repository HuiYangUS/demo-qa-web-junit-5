package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class AppConfigReader {

    private static final String DIR_PATH = "src/main/resources/configs/";

    public static String getValue(String fileName, String key) {
	String filePath = DIR_PATH + fileName + ".properties";
	Properties p = load(filePath);
	return p.containsKey(key) ? (p.getProperty(key).isBlank() ? null : p.getProperty(key)) : null;
    }

    private static Properties load(String filePath) {
	Properties p = new Properties();
	try {
	    p.load(new FileInputStream(filePath));
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return p;
    }

}
