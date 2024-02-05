package utilities;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MyTestUtils {

	public static void pause(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static long getTimeStamp() {
		return Timestamp.valueOf(LocalDateTime.now()).getTime();
	}

	public static String getDateString() {
		return LocalDate.now().toString();
	}

	public static String getOS() {
		return System.getProperty("os.name").toLowerCase();
	}

	public static boolean isWindows() {
		return getOS().contains("windows");
	}

	public static boolean isMac() {
		return getOS().contains("mac");
	}

	public static String getWindowsErrMsg() {
		return String.format("Expected: <windows> but actual: <%s>.", getOS());
	}

	public static String getMacErrMsg() {
		return String.format("Expected: <mac> but actual: <%s>.", getOS());
	}

	public static String getCurrentDir() {
		return System.getProperty("user.dir").replace("\\", "/");
	}

}
