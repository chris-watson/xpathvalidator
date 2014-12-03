package org.sitenv.xml.xpathvalidator.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.sitenv.xml.xpathvalidator.config.data.Configuration;
import org.sitenv.xml.xpathvalidator.config.data.ValidatorConfig;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public abstract class ConfigurationLoader {
	
	public static final XPathFactory XPATH = XPathFactory.newInstance();
	public static final Logger logger = Logger.getLogger(ConfigurationLoader.class);
	
	public static List<Configuration> loadConfiguration(String configFile) 
	{
		List<Configuration> configItems = null;
		
		try {
			
			DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = domFactory.newDocumentBuilder();
			
			Document doc  = builder.parse(configFile);
			
			if (doc != null)
			{
				XPath xpath = XPATH.newXPath();
				XPathExpression expExpressionNode = xpath.compile("configuration/expression");
				XPathExpression expXpathExpression = xpath.compile("@xpathExpression");
				XPathExpression expValidatorNode = xpath.compile("validator");
				XPathExpression expValidatorClassName = xpath.compile("@className");
				
				XPathExpression expParamNodes = xpath.compile("param");
				XPathExpression expKeyName = xpath.compile("@key");
				XPathExpression expValueName = xpath.compile("@value");
				
				NodeList expressionNodes = (NodeList) expExpressionNode.evaluate(doc, XPathConstants.NODESET);
				for (int i =0; i < expressionNodes.getLength(); i++)
				{
					Node expressionNode = expressionNodes.item(i);
					String xpathExpression = (String)expXpathExpression.evaluate(expressionNode, XPathConstants.STRING);
					
					//String validatorClassname = (String)expValidatorClass.evaluate(validator, XPathConstants.STRING);
					
					Configuration config = new Configuration();
					//config.setValidatorClass(validatorClassname);
					config.setXpathExpression(xpathExpression);
					
					
					NodeList validatorNodes = (NodeList)expValidatorNode.evaluate(expressionNode, XPathConstants.NODESET);
					
					for (int j = 0; j < validatorNodes.getLength(); j++)
					{
						Node validatorNode = validatorNodes.item(j);
						String className = (String)expValidatorClassName.evaluate(validatorNode, XPathConstants.STRING);
						
						if (className != null)
						{
							if (config.getValidators() == null) 
							{
								config.setValidators(new ArrayList<ValidatorConfig>());
							}
							
							ValidatorConfig vconfig = new ValidatorConfig();
							vconfig.setValidatorClass(className);
							
							NodeList paramNodes = (NodeList)expParamNodes.evaluate(validatorNode, XPathConstants.NODESET);
							
							for (int k = 0; k < paramNodes.getLength(); k++)
							{
								Node paramNode = paramNodes.item(j);
								String key = (String)expKeyName.evaluate(paramNode, XPathConstants.STRING);
								String value = (String)expValueName.evaluate(paramNode, XPathConstants.STRING);
								
								if (vconfig.getParameters() == null) {
									vconfig.setParameters(new HashMap<String,String>());
								}
								
								vconfig.getParameters().put(key, value);
								
							}
							config.getValidators().add(vconfig);
						}
						
					}
					
					if (configItems == null) {
						configItems = new ArrayList<Configuration>();
					}
					
					configItems.add(config);
				}
				
			}
		
		} 
		catch (XPathExpressionException e) 
		{
			logger.error(e);
		} 
		catch (ParserConfigurationException e) 
		{
			logger.error(e);
		} 
		catch (SAXException e)
		{
			logger.error(e);
		}
		catch (IOException e) 
		{
			logger.error(e);
		}
		
		
		return configItems;
	}
	
	

}
