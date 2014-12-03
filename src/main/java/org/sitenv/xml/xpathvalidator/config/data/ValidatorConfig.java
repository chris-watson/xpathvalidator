package org.sitenv.xml.xpathvalidator.config.data;

import java.util.Map;

public class ValidatorConfig {

	private String validatorClass;
	private Map<String, String> parameters;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((parameters == null) ? 0 : parameters.hashCode());
		result = prime * result
				+ ((validatorClass == null) ? 0 : validatorClass.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ValidatorConfig other = (ValidatorConfig) obj;
		if (parameters == null) {
			if (other.parameters != null)
				return false;
		} else if (!parameters.equals(other.parameters))
			return false;
		if (validatorClass == null) {
			if (other.validatorClass != null)
				return false;
		} else if (!validatorClass.equals(other.validatorClass))
			return false;
		return true;
	}
	public String getValidatorClass() {
		return validatorClass;
	}
	public void setValidatorClass(String validatorClass) {
		this.validatorClass = validatorClass;
	}
	public Map<String, String> getParameters() {
		return parameters;
	}
	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}
	
	
	
}
