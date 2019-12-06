package org.jsoup.parser;

public class TreeBuilderFactory {
	public static XmlTreeBuilder createXmlTreeBuilder() {
		return new XmlTreeBuilder();
	}
	public static HtmlTreeBuilder createHtmlTreeBuilder() {
		return new HtmlTreeBuilder();
	}
}
