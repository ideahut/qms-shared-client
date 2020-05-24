package com.github.ideahut.qms.shared.client.object;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class Result implements Serializable {
	
	public enum Status implements Serializable {
		SUCCESS,
		INPROGRESS,
		FAILED,
		ERROR
	}
	
	public static Result SUCCESS(Object data) {
		return new Result(Status.SUCCESS, data, null);
	}
	
	public static Result SUCCESS() {
		return new Result(Status.SUCCESS, null, null);
	}
	
	public static Result STATUS(Status status, Object data) {
		return new Result(status, data, null);
	}
	
	public static Result ERROR(List<CodeMessage> error) {
		return new Result(Status.ERROR, null, error);
	}
	
	public static Result ERROR() {
		return new Result(Status.ERROR, null, null);
	}
	
	public static Result ERROR(CodeMessage error) {
		List<CodeMessage> list = new ArrayList<CodeMessage>();
		list.add(error);
		return ERROR(list);
	}
	
	public static Result ERROR(String code, String message) {
		return ERROR(new CodeMessage(code, message));
	}
	
	public static Result ERROR(String code) {
		return ERROR(new CodeMessage(code, null));
	}
	
	private final Status status;
	
	private final List<CodeMessage> error;
	
	private final Object data;
	
	private Map<String, Serializable> info;

	private Result(Status status, Object data, List<CodeMessage> error) {
		this.status = status;
		this.data   = data;
		this.error  = error;
	}	

	public List<CodeMessage> getError() {
		return error;
	}

	public Status getStatus() {
		return status;
	}

	public Object getData() {
		return data;
	}
	
	public Result setInfo(String key, Serializable value) {
		if (info == null) {
			info = new HashMap<String, Serializable>();
		}
		info.put(key, value);
		return this;
	}
	
	public Map<String, Serializable> getInfo() {
		return info;
	}

	public boolean hasError() {
		return error != null && !error.isEmpty();
	}

}
