package org.sitenv.xml.xpathvalidator.engine;

import java.util.Map;

import javax.xml.xpath.XPath;

import org.sitenv.xml.xpathvalidator.engine.data.XPathValidatorResult;
import org.w3c.dom.Node;

public interface XPathNodeValidator {

	public XPathValidatorResult validateNode(String expression, XPath xpath, Node node, int nodeIndex, Map<String, String> params);
	
}
