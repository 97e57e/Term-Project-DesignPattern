package org.jsoup.userInterface;

import org.jsoup.nodes.Element;

public class TraverseDown implements Traverse{
	
	public Element traverse(Element e) {
		if (e.children().isEmpty()) {
			System.err.println("\n더 이상 child가 없습니다.");
			return e;
		}
		e = e.child(0);
		System.out.println("\n( " + 1 + " / " + e.elementSiblingSize(e) + " )");

		return e;
	}
}
