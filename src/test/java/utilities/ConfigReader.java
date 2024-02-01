package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	private static final String DIR_PATH = "src/test/resources/configs/";

	public static String getValue(String fileName, String key) {
		Properties p = new Properties();
		String filePath = DIR_PATH + fileName + ".properties";
		try {
			p.load(new FileInputStream(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p.isEmpty() ? null : p.getProperty(key);
	}

}
