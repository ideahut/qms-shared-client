package com.github.ideahut.qms.shared.client.type;

import java.io.Serializable;

public enum ConditionType implements Serializable {
	ANY_LIKE 		("anylike"),
	ANY_START 		("anystart"),
	ANY_END 		("anyend"),
	ANY_EQUAL 		("anyeq"),
	LIKE 			("like"),
	START 			("start"),
	END 			("end"),
	EQUAL 			("eq"),
	NOT_EQUAL 		("noteq"),
	BETWEEN 		("between"),
	NOT_NULL 		("notnull"),
	IS_NULL 		("isnull"),
	GREATER_THAN 	("gt"),
	GREATER_EQUAL 	("ge"),
	LESS_THAN 		("lt"),
	LESS_EQUAL 		("le"),
	IN 				("in"),
	NOT_IN 			("notin"),
	;		
	
	private final String value;
	
	private ConditionType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public static ConditionType getConditionType(String value, ConditionType defaultValue) {
		for (ConditionType c : ConditionType.values()) {
			if (c.value.equals(value)) {
				return c;
			}
		}
		return defaultValue;
	}
	
	public static ConditionType getConditionType(String value) {
		return getConditionType(value, null);
	}
	
}
