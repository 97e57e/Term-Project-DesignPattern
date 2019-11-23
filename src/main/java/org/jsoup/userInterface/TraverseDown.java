package org.jsoup.userInterface;

import org.jsoup.select.Elements;

public class TraverseDown implements Traverse{
	
	public Elements traverse(Elements els) {
		System.out.println("Down!");
		return els;
	}
}
