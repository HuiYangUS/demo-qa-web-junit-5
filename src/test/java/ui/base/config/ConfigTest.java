package ui.base.config;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class ConfigTest {

	@Test
	@Tag("headless")
	void runHeadless() {
		System.setProperty("headless", "true");
	}

	@Test
	@Tag("chrome")
	void runChrome() {
		printThread();
		System.setProperty("browser", "chrome");
	}

	@Test
	@Tag("edge")
	void runEdge() {
		printThread();
		System.setProperty("browser", "edge");
	}

	@Test
	@Tag("safari")
	@EnabledOnOs(OS.MAC)
	void runSafari() {
		printThread();
		System.setProperty("browser", "safari");
	}

	@Test
	@Tag("firefox")
	void runFirefox() {
		printThread();
		System.setProperty("browser", "firefox");
	}

	public static void printThread() {
		System.out.println("Thread-ID: " + Thread.currentThread().getId());
	}

}
