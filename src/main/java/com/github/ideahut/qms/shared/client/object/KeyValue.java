package com.github.ideahut.qms.shared.client.object;

import java.io.Serializable;

@SuppressWarnings("serial")
public class KeyValue<KEY, VALUE> implements Serializable {

	private KEY key;
	
	private VALUE value;
	
	public KeyValue() {		
	}
	
	public KeyValue(KEY key, VALUE value) {
		this.key = key;
		this.value = value;
	}

	public KEY getKey() {
		return key;
	}

	public void setKey(KEY key) {
		this.key = key;
	}

	public VALUE getValue() {
		return value;
	}

	public void setValue(VALUE value) {
		this.value = value;
	}	
	
}
