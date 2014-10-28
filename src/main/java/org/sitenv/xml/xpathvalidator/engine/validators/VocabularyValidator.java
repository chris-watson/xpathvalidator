package org.sitenv.xml.xpathvalidator.engine.validators;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;

import org.apache.log4j.Logger;
import org.sitenv.xml.xpathvalidator.engine.XPathNodeValidator;
import org.sitenv.xml.xpathvalidator.engine.data.XPathValidatorResult;
import org.w3c.dom.Node;

public class VocabularyValidator implements XPathNodeValidator {

	private static final Logger logger = Logger.getLogger(VocabularyValidator.class);
	
	public XPathValidatorResult validateNode(String expression, XPath xpath, Node node, int nodeIndex) {
		
		try
		{
			XPathExpression expCode = xpath.compile("@code");
			XPathExpression expCodeSystemName = xpath.compile("@codeSystemName");
			
			String code = (String)expCode.evaluate(node, XPathConstants.STRING);
			System.out.println("code: " + code);
			
			String codeSystem = (String)expCodeSystemName.evaluate(node, XPathConstants.STRING);
			System.out.println("codeSystemName: " + codeSystem);
		}
		catch (XPathExpressionException e)
		{
			logger.error(e);
		}
		
		// TODO Auto-generated method stub
		return null;
		
	}

	
	
}
