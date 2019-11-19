package org.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class MainClass {

	public static void main(String[] args) {
		String address = "https://jsoup.org/download";
		Document doc = null;
		
		try {
			doc = Jsoup.connect(address).get();
			
			Elements els = doc.select(".header").select(".nav-sections");
			System.out.println(els);
		}catch(Exception e) {
			
		}
	}

}
