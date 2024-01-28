package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	private static final String FILE_PATH = "src/test/resources/configs/";

	public static String getValue(String fileName, String key) {
		Properties p = new Properties();
		try {
			p.load(new FileInputStream(new File(FILE_PATH + fileName + ".properties")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p.isEmpty() ? null : p.getProperty(key);
	}

}
