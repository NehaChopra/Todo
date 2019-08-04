package com.quintifi.todo.exceptions;

/**
 * 
 * @author nchopra
 *
 */
public enum ApiExCode implements ExceptionCodes {

	UNAUTHORIZED("AU_501", "Full authentication is required to access this resource"),
	USER_DIASABLED("AU_503", "User is disabled!"), BAD_CREDDNETIALS("AU_504", "Bad credentials!"),
	REGISTRATION_DETAILS_INVALID("AU_505", "Registration Details are invalid"),
	EMAIL_ALREADY_EXISTS("AU_506", "Email or Username Already exists"), BAD_REQUEST("AU_507", "Bad Request"),
	EMAIL_NOT_FOUND("AU_508", "Email not found!"), USER_NOT_FOUND("AU_509", "User not found!"),
	UNABLE_TO_SAVE_DATA("AU_510", "Unable to save data");

	private String code;
	private String message;

	ApiExCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
