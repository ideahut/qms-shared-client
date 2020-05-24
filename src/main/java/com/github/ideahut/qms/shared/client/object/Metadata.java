package com.github.ideahut.qms.shared.client.object;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class Metadata implements Serializable {

	private Map<String, Boolean> exports = new LinkedHashMap<String, Boolean>();
	
	private List<Integer> pageRows = new ArrayList<Integer>();
	
	private Grid grid = new Grid();

	public Map<String, Boolean> getExports() {
		return exports;
	}

	public void setExports(Map<String, Boolean> exports) {
		this.exports = exports;
	}

	public List<Integer> getPageRows() {
		return pageRows;
	}

	public void setPageRows(List<Integer> pageRows) {
		this.pageRows = pageRows;
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}	
	
}
