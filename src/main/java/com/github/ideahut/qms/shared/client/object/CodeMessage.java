package com.github.ideahut.qms.shared.client.object;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CodeMessage implements Serializable {
	
	private String code;
	
	private String object;
	
	private String field;
	
	private String message;

	public CodeMessage() {}
	
	public CodeMessage(String code, String message) {
		this(code, message, null, null);
	}
	
	public CodeMessage(String code, String message, String object, String field) {
		this.code 	 = code;
		this.object  = object;
		this.field 	 = field;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public CodeMessage setCode(String code) {
		this.code = code;
		return this;
	}

	public String getObject() {
		return object;
	}

	public CodeMessage setObject(String object) {
		this.object = object;
		return this;
	}

	public String getField() {
		return field;
	}

	public CodeMessage setField(String field) {
		this.field = field;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public CodeMessage setMessage(String message) {
		this.message = message;
		return this;
	}

	@Override
	public String toString() {
		return "[code=" + code + ", object=" + object + ", field=" + field + ", message=" + message + "]";
	}	
	
}
