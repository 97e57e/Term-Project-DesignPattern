package org.jsoup.parser;

public class TreeBuilderFactory {
	public static TreeBuilder createXmlTreeBuilder() {
		return new XmlTreeBuilder();
	}
	public static TreeBuilder createHtmlTreeBuilder() {
		return new HtmlTreeBuilder();
	}
}
