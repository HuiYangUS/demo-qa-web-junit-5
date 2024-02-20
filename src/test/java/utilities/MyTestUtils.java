package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.sql.Timestamp;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import io.cucumber.datatable.DataTable;

public class MyTestUtils {

	public static void pause(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static boolean isInt(String text) {
		try {
			Integer.parseInt(text);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isValidDate(String year, String month, String dayOfMonth) {
		if (!isInt(year) || !isInt(month) || !isInt(dayOfMonth))
			return false;
		try {
			LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(dayOfMonth));
			return true;
		} catch (DateTimeException e) {
			return false;
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

	public static String getCurrentDir() {
		return System.getProperty("user.dir").replace("\\", "/");
	}

	/*
	 * return first row of cucumber data table as map
	 */
	public static Map<String, String> getDataRow(DataTable dataTable) {
		if (dataTable.asMaps().size() >= 1)
			return dataTable.asMaps().get(0);
		return new HashMap<String, String>();
	}

	public static String getAutoChromeOnWindowsPath() {
		assertTrue(isWindows(), "It must be on a windows machine.");
		int lastIndex = getCurrentDir().lastIndexOf("/");
		String projectContainerDirPath = getCurrentDir().substring(0, lastIndex);
		String autoChromePath = projectContainerDirPath + "/automation/chrome/chrome.exe";
		return autoChromePath;
	}

	public static boolean isAutoChromeOnWindowsAvailable() {
		return (new File(getAutoChromeOnWindowsPath()).exists());
	}

}
