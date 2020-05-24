package com.github.ideahut.qms.shared.client.exception;

import com.github.ideahut.qms.shared.client.object.Result;

@SuppressWarnings("serial")
public class ResultException extends Exception {

	private final Result result;
	
	public ResultException(Result result) {
		this.result = result;
	}

	public Result getResult() {
		return result;
	}	
	
}
