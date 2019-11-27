package org.jsoup.userInterface;

import org.jsoup.nodes.Element;

public class TraverseDown implements Traverse{
	
	public Element traverse(Element e) {
		e = e.child(0);
		System.out.println("( " + 1 + " / " + e.childNodeSize() + " )\n");

		return e;
	}
}
