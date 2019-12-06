package org.jsoup.userInterface;

import org.jsoup.nodes.Element;

public class TraversePrevious implements Traverse{
	
	public Element traverse(Element e) {
		if (e.previousElementSibling() != null) {
			e = e.previousElementSibling();
			System.out.println("\n( " + Integer.toString(e.elementSiblingIndex()+1) + " / "  
			+ Integer.toString(e.elementSiblingSize(e)) + " )");
			return e;
		} else {
			System.err.println("\n첫번째 원소 입니다.");
			return e;
		}
	}
}
