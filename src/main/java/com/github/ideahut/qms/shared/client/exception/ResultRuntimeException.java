package com.github.ideahut.qms.shared.client.exception;

import com.github.ideahut.qms.shared.client.object.Result;

@SuppressWarnings("serial")
public class ResultRuntimeException extends RuntimeException {

	private final Result result;
	
	public ResultRuntimeException(Result result) {
		this.result = result;
	}

	public Result getResult() {
		return result;
	}
	
}
