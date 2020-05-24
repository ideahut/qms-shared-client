package com.github.ideahut.qms.shared.client.type;

import java.io.Serializable;

public enum LogicalType implements Serializable {
	and, 
	or,
	;
	
	public static LogicalType getLogicalType(String value, LogicalType defaultValue) {
		for (LogicalType logicalType : LogicalType.values()) {
			if (logicalType.name().equalsIgnoreCase(value)) {
				return logicalType;
			}
		}
		return defaultValue;
	}
	
	public static LogicalType getLogicalType(String value) {
		return getLogicalType(value, null);
	}
	
}
