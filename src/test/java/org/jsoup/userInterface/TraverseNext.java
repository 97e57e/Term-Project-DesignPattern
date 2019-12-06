package org.jsoup.userInterface;

import org.jsoup.nodes.Element;

public class TraverseNext implements Traverse {
	
	public Element traverse(Element e) {
		if (e.nextElementSibling() != null) {
			e = e.nextElementSibling();
			System.out.println("\n( " + Integer.toString(e.elementSiblingIndex()+1) + " / "  
			+ Integer.toString(e.elementSiblingSize(e)) + " )");
			return e;
		} else {
			System.err.println("\n마지막 원소 입니다.");
			return e;
		}
	}
}
