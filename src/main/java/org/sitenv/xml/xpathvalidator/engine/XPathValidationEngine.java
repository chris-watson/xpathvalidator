package org.sitenv.xml.xpathvalidator.engine;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.sitenv.xml.xpathvalidator.config.ConfigurationLoader;
import org.sitenv.xml.xpathvalidator.config.data.Configuration;
import org.sitenv.xml.xpathvalidator.engine.data.XPathValidatorResult;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XPathValidationEngine {
	
	private static final XPathFactory XPATH = XPathFactory.newInstance();
	private static final Logger logger = Logger.getLogger(XPathValidationEngine.class);
	
	private List<Configuration> configs;
	private DocumentBuilderFactory domFactory;
	private DocumentBuilder builder;

	private static NodeList findNodes(XPath xpath, Configuration config, Document doc) throws XPathExpressionException
	{
		NodeList result = (NodeList) xpath.compile(config.getXpathExpression()).evaluate(doc, XPathConstants.NODESET);
		
		return result;
	}
	
	public void initialize(String configurationFile)
	{
		this.configs = ConfigurationLoader.loadConfiguration(configurationFile);
		
		try {
			
			this.domFactory = DocumentBuilderFactory.newInstance();
			this.builder = domFactory.newDocumentBuilder();
		} 
		catch (ParserConfigurationException e) 
		{
			logger.error(e);
		} 
		
	}
	
	public List<XPathValidatorResult> validate(String uri) throws IOException, SAXException {
		Document doc = builder.parse(uri);
		
		return this.validate(doc);
	}
	
	public List<XPathValidatorResult> validate(InputStream stream) throws IOException, SAXException {
		Document doc = builder.parse(stream);
		
		return this.validate(doc);
	}
	
	public List<XPathValidatorResult> validate(Document doc) 
	{
		List<XPathValidatorResult> results = null;
		
		if (doc != null)
		{
			
			try {
				
				for (Configuration config : configs) {
					// Instantiate the validator dynamically
					XPath xpath = XPATH.newXPath();
					
					// Find all of the Nodes from the XML parser
					NodeList nodes = findNodes(xpath, config, doc);
					
					for (int i = 0; i < nodes.getLength(); i++) {
						
						for (String validatorClass : config.getValidators()) {
						
							XPathNodeValidator validator = (XPathNodeValidator)Class.forName(validatorClass).newInstance();
							
							XPathValidatorResult result = validator.validateNode(config.getXpathExpression(), xpath, nodes.item(i), i);
							
							if (results == null) {
								results = new ArrayList<XPathValidatorResult>();
							}
							
							if (results != null && result != null)
							{
								results.add(result);
							}
						}
					}
					
					
				}
			}
			catch (ClassNotFoundException e) {
				logger.error(e);
			}
			catch (IllegalAccessException e) {
				logger.error(e);
			}
			catch (InstantiationException e) {
				logger.error(e);
			}
			catch (XPathExpressionException e) {
				logger.error(e);
			}
		}
		
		return results;
	}
	
	
	
}
