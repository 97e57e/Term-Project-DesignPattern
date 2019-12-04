package org.jsoup.interfaceUnitTest;

import static org.junit.Assert.assertEquals;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.userInterface.Traverse;
import org.jsoup.userInterface.TraverseDown;
import org.jsoup.userInterface.TraverseNext;
import org.jsoup.userInterface.TraversePrevious;
import org.jsoup.userInterface.TraverseUp;
import org.junit.Test;

public class TraverseTest {
	
	static String address;
	static Document doc;
	
	Traverse tb;

	static {
		address = "https://jsoup.org/";
		try {
			doc = Jsoup.connect(address).get();
		}catch(Exception e) {}
	}
	
	@Test
	public void TraverseUpTest() {
		Elements els = doc.select(".nav-sections");
		Element e = els.get(0);
		tb = new TraverseUp();
		assertEquals(doc.select(".header").get(0), tb.traverse(e));
		e = tb.traverse(e);
		assertEquals(doc.select(".wrap").get(0), tb.traverse(e));
		e = tb.traverse(e);
		assertEquals(doc.select(".n1-home").get(0), tb.traverse(e));
	}
	
	@Test
	public void TraverseDownTest() {
		Elements els = doc.select(".wrap");
		Element e = els.get(0);
		tb = new TraverseDown();
		assertEquals(doc.select(".header").get(0), tb.traverse(e));
		e = tb.traverse(e);
		assertEquals(doc.select(".nav-sections").get(0), tb.traverse(e));
	}
	
	@Test
	public void TraverseNextTest() {
		Elements els = doc.select(".n1-discussion");
		Element e = els.get(0);
		tb = new TraverseNext();
		assertEquals(doc.select(".n1-download").get(0), tb.traverse(e));
		e = tb.traverse(e);
		assertEquals(doc.select(".n1-api").get(0), tb.traverse(e));
		e = tb.traverse(e);
		assertEquals(doc.select(".n1-cookbook").get(0), tb.traverse(e));
		e = tb.traverse(e);
		assertEquals(doc.select(".n1-try").get(0), tb.traverse(e));
		// "n1-try"가 가장 마지막 클래스 이기 때문에 traverse를 한 번 더 해도 "n1-try"를 반환
		e = tb.traverse(e);
		assertEquals(doc.select(".n1-try").get(0), tb.traverse(e));
	}
	
	@Test
	public void TraversePreviousTest() {
		Elements els = doc.select(".n1-try");
		Element e = els.get(0);
		tb = new TraversePrevious();
		assertEquals(doc.select(".n1-cookbook").get(0), tb.traverse(e));
		e = tb.traverse(e);
		assertEquals(doc.select(".n1-api").get(0), tb.traverse(e));
		e = tb.traverse(e);
		assertEquals(doc.select(".n1-download").get(0), tb.traverse(e));
	}

}
