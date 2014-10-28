package org.sitenv.xml.xpathvalidator.engine.data;

public abstract class XPathValidatorResult {
	
	protected boolean error;
	protected boolean warning;
	protected boolean information;
	
	protected String errorMessage;
	protected String warningMessage;
	protected String infoMessage;
	
	protected String xpathExpression;
	protected int nodeIndex;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (error ? 1231 : 1237);
		result = prime * result
				+ ((errorMessage == null) ? 0 : errorMessage.hashCode());
		result = prime * result
				+ ((infoMessage == null) ? 0 : infoMessage.hashCode());
		result = prime * result + (information ? 1231 : 1237);
		result = prime * result + nodeIndex;
		result = prime * result + (warning ? 1231 : 1237);
		result = prime * result
				+ ((warningMessage == null) ? 0 : warningMessage.hashCode());
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
		XPathValidatorResult other = (XPathValidatorResult) obj;
		if (error != other.error)
			return false;
		if (errorMessage == null) {
			if (other.errorMessage != null)
				return false;
		} else if (!errorMessage.equals(other.errorMessage))
			return false;
		if (infoMessage == null) {
			if (other.infoMessage != null)
				return false;
		} else if (!infoMessage.equals(other.infoMessage))
			return false;
		if (information != other.information)
			return false;
		if (nodeIndex != other.nodeIndex)
			return false;
		if (warning != other.warning)
			return false;
		if (warningMessage == null) {
			if (other.warningMessage != null)
				return false;
		} else if (!warningMessage.equals(other.warningMessage))
			return false;
		if (xpathExpression == null) {
			if (other.xpathExpression != null)
				return false;
		} else if (!xpathExpression.equals(other.xpathExpression))
			return false;
		return true;
	}
	public boolean hasError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public boolean hasWarning() {
		return warning;
	}
	public void setWarning(boolean warning) {
		this.warning = warning;
	}
	public boolean hasInformation() {
		return information;
	}
	public void setInformation(boolean information) {
		this.information = information;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getWarningMessage() {
		return warningMessage;
	}
	public void setWarningMessage(String warningMessage) {
		this.warningMessage = warningMessage;
	}
	public String getInfoMessage() {
		return infoMessage;
	}
	public void setInfoMessage(String infoMessage) {
		this.infoMessage = infoMessage;
	}
	public String getXpathExpression() {
		return xpathExpression;
	}
	public void setXpathExpression(String xpathExpression) {
		this.xpathExpression = xpathExpression;
	}
	public int getNodeIndex() {
		return nodeIndex;
	}
	public void setNodeIndex(int nodeIndex) {
		this.nodeIndex = nodeIndex;
	}

	
	
	
	
}
