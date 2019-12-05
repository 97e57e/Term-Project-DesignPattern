package org.jsoup.parser;

public class XmlTreeBuilderFactory extends TreeBuilderFactory {

	@Override
	protected TreeBuilder createTreeBuilder() {
		// TODO Auto-generated method stub
		return new XmlTreeBuilder();
	}

}
