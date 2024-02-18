package ui.experiments;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

public class TestDemoReadDataXML {

	@Test
	void runTest() {
		Document doc = null;
		try {
			doc = Jsoup.parse(new File("src/test/resources/test-data/shopping.xml"));
		} catch (IOException e) {
			System.out.println("File is not available.");
			e.printStackTrace();
		}
		Elements elements = doc.getElementsByAttributeValue("when", "Aug 10");
		assertEquals(1, elements.size(), "Invalid numbers of elements.");
		Element element = elements.get(0);
		System.out.println(element.text());
	}

}
