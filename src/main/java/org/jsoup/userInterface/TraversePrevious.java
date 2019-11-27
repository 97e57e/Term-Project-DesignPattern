package org.jsoup.userInterface;

import org.jsoup.nodes.Element;

public class TraversePrevious implements Traverse{
	
	public Element traverse(Element e) {
		System.out.println("Previous!");
		return e;
	}
}
