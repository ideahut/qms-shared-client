package com.github.ideahut.qms.shared.client.type;

public enum GridControlType {
	none,
	text,
	password,
	textarea,
	select,
	date,
	checkbox,
	grid, // Lookup ke metadata lain (contoh untuk field group di entity User)
	admin, // Mengambil list dari entity, lihat @GridAdmin
	upload
}
