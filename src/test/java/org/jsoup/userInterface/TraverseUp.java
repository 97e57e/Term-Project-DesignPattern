package org.jsoup.userInterface;

import org.jsoup.nodes.Element;

public class TraverseUp implements Traverse {

	public Element traverse(Element e) {
		if( e.hasParent() ) {
			return e.parent();
		} else {
			System.err.println("\n더이상 부모 Element가 없습니다.");
			return e;
		}
	}
}
