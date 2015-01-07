xpathvalidator
==============

Xpathvalidator is java-based configurable XML validator libary.

To use:

* Include the xpathvalidator.jar on your classpath
* Create your custom validator class by implementing one of the included interfaces:
	* org.sitenv.xml.xpathvalidator.engine.MultipleXPathNodeValidator
		- Use this validator interface to return multiple validation results from a single validator
	* org.sitenv.xml.xpathvalidator.engine.XPathNodeValidator
		- Use this validator interface to return a single validation result from a single validator 
* Create a configuration xml file to specify the use of the validator.  The configuration file should be int the following syntax:
 

		<configuration>
			<expression xpathExpression="ClinicalDocument/documentationOf/serviceEvent/code">
				<validator className="org.sitenv.xml.validators.ccda.CcdaCodeValidator" />
			</expression>
		</configuration>
* Initialize the Validation Engine and pass it a file to validate.
	
		private static XPathValidationEngine engine = null;

		.
		.
		.

		engine = new XPathValidationEngine();
		File file = new File("path/to/fileToBeValidate");

		engine.initialize(props.getProperty("path/to/configFile.xml"));

		List<XPathValidatorResult> results = engine.validate(file.getInputStream());
