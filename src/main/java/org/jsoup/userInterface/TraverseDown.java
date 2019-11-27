package org.jsoup.userInterface;

import org.jsoup.nodes.Element;

public class TraverseDown implements Traverse{
	
	public Element traverse(Element e) {
		if (e.children().isEmpty()) {
			System.out.println("더 이상 child가 없습니다.\n");
			return e;
		}
		e = e.child(0);
		System.out.println("( " + 1 + " / " + e.childNodeSize() + " )\n");

		return e;
	}
}
