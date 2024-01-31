package utilities;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class MyTestUtils {

	private static int demoWaitTime = 6;

	public static void pause(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void demoPause() {
		boolean isDemo = Boolean.parseBoolean(ConfigReader.getValue("config", "demo"));
		if (isDemo)
			pause(demoWaitTime);
	}

	public static long getTimestamp() {
		return Timestamp.valueOf(LocalDateTime.now()).getTime();
	}

}
