package org.sitenv.xml.xpathvalidator.engine.data;

public class XPathValidatorResult {
	
	private boolean hasError;
	private boolean hasWarning;
	private boolean hasInfo;
	
	private String errorMessage;
	private String warningMessage;
	private String infoMessage;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((errorMessage == null) ? 0 : errorMessage.hashCode());
		result = prime * result + (hasError ? 1231 : 1237);
		result = prime * result + (hasInfo ? 1231 : 1237);
		result = prime * result + (hasWarning ? 1231 : 1237);
		result = prime * result
				+ ((infoMessage == null) ? 0 : infoMessage.hashCode());
		result = prime * result
				+ ((warningMessage == null) ? 0 : warningMessage.hashCode());
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
		if (errorMessage == null) {
			if (other.errorMessage != null)
				return false;
		} else if (!errorMessage.equals(other.errorMessage))
			return false;
		if (hasError != other.hasError)
			return false;
		if (hasInfo != other.hasInfo)
			return false;
		if (hasWarning != other.hasWarning)
			return false;
		if (infoMessage == null) {
			if (other.infoMessage != null)
				return false;
		} else if (!infoMessage.equals(other.infoMessage))
			return false;
		if (warningMessage == null) {
			if (other.warningMessage != null)
				return false;
		} else if (!warningMessage.equals(other.warningMessage))
			return false;
		return true;
	}

	public boolean isHasError() {
		return hasError;
	}

	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}

	public boolean isHasWarning() {
		return hasWarning;
	}

	public void setHasWarning(boolean hasWarning) {
		this.hasWarning = hasWarning;
	}

	public boolean isHasInfo() {
		return hasInfo;
	}

	public void setHasInfo(boolean hasInfo) {
		this.hasInfo = hasInfo;
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

	
	
}
