package org.sitenv.xml.xpathvalidator.config.data;

import java.util.List;

public class Configuration {

	private String xpathExpression;
	private List<String> validators;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((validators == null) ? 0 : validators.hashCode());
		result = prime * result
				+ ((xpathExpression == null) ? 0 : xpathExpression.hashCode());
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
		Configuration other = (Configuration) obj;
		if (validators == null) {
			if (other.validators != null)
				return false;
		} else if (!validators.equals(other.validators))
			return false;
		if (xpathExpression == null) {
			if (other.xpathExpression != null)
				return false;
		} else if (!xpathExpression.equals(other.xpathExpression))
			return false;
		return true;
	}

	public String getXpathExpression() {
		return xpathExpression;
	}

	public void setXpathExpression(String xpathExpression) {
		this.xpathExpression = xpathExpression;
	}

	public List<String> getValidators() {
		return validators;
	}

	public void setValidators(List<String> validators) {
		this.validators = validators;
	}
	
	
	
}
