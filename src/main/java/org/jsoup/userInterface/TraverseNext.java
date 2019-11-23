package org.jsoup.userInterface;

import org.jsoup.select.Elements;

public class TraverseNext implements Traverse {
	
	public Elements traverse(Elements els) {
		System.out.println("Next!");
		return els;
	}
}
