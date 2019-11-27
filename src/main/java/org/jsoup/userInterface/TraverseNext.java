package org.jsoup.userInterface;

import org.jsoup.nodes.Element;

public class TraverseNext implements Traverse {
	
	public Element traverse(Element e) {
		System.out.println("Next!");
		return e;
	}
}
