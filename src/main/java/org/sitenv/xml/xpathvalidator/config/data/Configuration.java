package org.sitenv.xml.xpathvalidator.config.data;

public class Configuration {

	private String xpathExpression;
	private String validatorClass;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((validatorClass == null) ? 0 : validatorClass.hashCode());
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
		if (validatorClass == null) {
			if (other.validatorClass != null)
				return false;
		} else if (!validatorClass.equals(other.validatorClass))
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

	public String getValidatorClass() {
		return validatorClass;
	}

	public void setValidatorClass(String validatorClass) {
		this.validatorClass = validatorClass;
	}

	
}
