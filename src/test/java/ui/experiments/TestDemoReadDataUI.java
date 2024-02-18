package ui.experiments;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

public class TestDemoReadDataUI {

	@Test
	void runTest() {
		Document doc = null;
		try {
			doc = Jsoup.connect("https://www.espn.com/soccer/?src=com").get();
		} catch (IOException e) {
			System.out.println("Link is not available.");
			e.printStackTrace();
		}
		String title = doc.title();
		System.out.println(title);
	}

}
