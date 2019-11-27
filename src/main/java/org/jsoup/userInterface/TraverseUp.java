package org.jsoup.userInterface;

import org.jsoup.nodes.Element;

public class TraverseUp implements Traverse {

	public Element traverse(Element e) {
		return e.parent();
	}
}
