package org.sitenv.xml.xpathvalidator.engine;

import java.util.List;

import javax.xml.xpath.XPath;

import org.sitenv.xml.xpathvalidator.engine.data.XPathValidatorResult;
import org.w3c.dom.Node;

public interface MultipleXPathNodeValidator {
	
	public List<XPathValidatorResult> validateNode(String expression, XPath xpath, Node node, int nodeIndex);

}
