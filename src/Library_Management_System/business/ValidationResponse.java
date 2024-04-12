package Library_Management_System.business;

public class ValidationResponse {
	private boolean isValid;
	private String errorMessage;
	private String fieldName;
	
	public ValidationResponse(boolean isValid,
			String errorMessage,
			String fieldName) {
		this.isValid=isValid;
		this.errorMessage=errorMessage;
		this.fieldName=fieldName;
	}
	public ValidationResponse() {
		
	}
}
