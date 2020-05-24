package com.github.ideahut.qms.shared.client.object;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class Page<T> implements Serializable {
	
	public static final Integer DEFAULT_PAGE_SIZE = 20;

	private Integer index;

	private Integer size;
	
	private Integer total;
	
	private Long records;
	
	private List<T> data;
	
	private Map<String, Serializable> info;
	
	private Boolean count = Boolean.TRUE;

	public Page() {
		this(1, DEFAULT_PAGE_SIZE);
	}

	public Page(Integer index) {
		this(index, DEFAULT_PAGE_SIZE);
	}

	public Page(Integer index, Integer size) {
		setIndex(index);
		setSize(size);
	}

	public int getIndex() {
		return index;
	}

	public Page<T> setIndex(Integer index) {
		this.index = index != null && index > 0 ? index : 1;
		return this;
	}

	public Integer getSize() {
		return size;
	}

	public Page<T> setSize(Integer size) {
		this.size = size != null && size > 0 ? size : DEFAULT_PAGE_SIZE;
		return this;
	}

	public Integer getTotal() {
		return total;
	}

	public Page<T> setTotal(Integer total) {
		this.total = total;
		return this;
	}

	public Long getRecords() {
		return records;
	}

	public Page<T> setRecords(Long records) {
		this.records = records;
		total = ((int)(Math.ceil((float) records / size)));
		return this;
	}

	public List<T> getData() {
		return data;
	}

	public Page<T> setData(List<T> data) {
		this.data = data;
		return this;
	}
	
	public Map<String, Serializable> getInfo() {
		return info;
	}

	public Page<T> setInfo(Map<String, Serializable> info) {
		this.info = info;
		return this;
	}
	
	public Page<T> setInfo(String key, Serializable value) {
		if (info == null) {
			info = new HashMap<String, Serializable>();
		}
		info.put(key, value);
		return this;
	}
	
	public Boolean getCount() {
		return count;
	}

	public void setCount(Boolean count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "[index=" + index + ", size=" + size + ", total=" + total + ", records=" + records + ", data="
				+ data + ", info=" + info + ", count=" + count + "]";
	}

	public static<T> Page<T> create() {
		return create(1, DEFAULT_PAGE_SIZE);
	}

	public static<T> Page<T> create(Integer index) {
		return create(index, DEFAULT_PAGE_SIZE);
	}

	public static<T> Page<T> create(Integer index, Integer size) {
		if (index < 1) {
			index = 1;
		}
		if (size <= 0) {
			size = DEFAULT_PAGE_SIZE;
		}
		return new Page<T>(index, size);
	}
	
	public static<T> Page<T> createEmpty() {
		Page<T> page = create();
		page.setData(new ArrayList<T>());
		return page;
	}

}
