package org.jsoup.userInterface;

import org.jsoup.select.Elements;

public class TraversePrevious implements Traverse{
	
	public Elements traverse(Elements els) {
		System.out.println("Previous!");
		return els;
	}
}
