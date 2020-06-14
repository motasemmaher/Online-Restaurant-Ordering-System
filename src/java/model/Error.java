package model;

public final class Error {
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	String message;

	public Error(String message) {
		super();
		this.message = message;
	}
	
}
