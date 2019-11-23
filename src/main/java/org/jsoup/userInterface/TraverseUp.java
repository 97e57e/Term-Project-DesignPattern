package org.jsoup.userInterface;

import org.jsoup.select.Elements;

public class TraverseUp implements Traverse {

	public Elements traverse(Elements els) {
		System.out.println("UP!");
		return els;
	}
}
