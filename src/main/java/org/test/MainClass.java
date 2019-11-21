package org.test;

import org.jsoup.userInterface.UserInterface;


public class MainClass {

	public static void main(String[] args) {
		UserInterface userInterface;
		
		userInterface = UserInterface.getUserInterface();
		userInterface.run();
		
		
//		try {
//			doc = Jsoup.connect(address).get();
//			
//			Elements els = doc.select(".header").select(".nav-sections");
//			System.out.println(els);
//		}catch(Exception e) {
//			
//		}
	}
}
