package com.github.ideahut.qms.shared.client.object;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.github.ideahut.qms.shared.client.type.ConditionType;
import com.github.ideahut.qms.shared.client.type.LogicalType;

@SuppressWarnings("serial")
public class AdminRequest implements Serializable {
	
	private String manager;
	
	private String model;
	
	private Object id;
	
	@SuppressWarnings("rawtypes")
	private List ids;
	
	private String mapkey;
	
	private Page<?> page;
	
	private Integer start;
	
	private Integer limit;
	
	private List<AdminRequest.Filter> filter;
	
	private List<String> order; // descending startwith '-' 
	
	private List<String> group;
	
	private List<String> field;
	
	private List<String> loadlazy;
	
	private Map<String, Object> value;
	
	private List<Map<String, Object>> values;
	
	public String getManager() {
		return manager;
	}

	public AdminRequest setManager(String manager) {
		this.manager = manager;
		return this;
	}

	public String getModel() {
		return model;
	}

	public AdminRequest setModel(String model) {
		this.model = model;
		return this;
	}

	@SuppressWarnings("unchecked")
	public <T> T getId() {
		return (T)id;
	}

	@SuppressWarnings("rawtypes")
	public <T> AdminRequest setId(T id) {
		if (id != null) {
			Class clazz = id.getClass();
			if (Collection.class.isAssignableFrom(clazz) || clazz.isArray()) {
				throw new RuntimeException("Collection or Array is not acceptable for id");
			}
		}
		this.id = id;
		return this;
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> getIds() {
		return (List<T>)ids;
	}

	public <T> AdminRequest setIds(List<T> ids) {
		this.ids = ids;
		return this;
	}

	public String getMapkey() {
		return mapkey;
	}

	public AdminRequest setMapkey(String mapkey) {
		this.mapkey = mapkey;
		return this;
	}

	public Page<?> getPage() {
		return page;
	}

	public AdminRequest setPage(Page<?> page) {
		this.page = page;
		return this;
	}

	public Integer getStart() {
		return start;
	}

	public AdminRequest setStart(Integer start) {
		this.start = start;
		return this;
	}

	public Integer getLimit() {
		return limit;
	}

	public AdminRequest setLimit(Integer limit) {
		this.limit = limit;
		return this;
	}

	public List<AdminRequest.Filter> getFilter() {
		return filter;
	}

	public AdminRequest setFilter(List<AdminRequest.Filter> filter) {
		this.filter = filter;
		return this;
	}
	
	public AdminRequest addFilter(AdminRequest.Filter filter) {
		this.filter.add(filter);
		return this;
	}

	public List<String> getOrder() {
		return order;
	}

	public AdminRequest setOrder(List<String> order) {
		this.order = order;
		return this;
	}
	
	public AdminRequest addOrder(String order) {
		this.order.add(order);
		return this;
	}

	public List<String> getGroup() {
		return group;
	}

	public AdminRequest setGroup(List<String> group) {
		this.group = group;
		return this;
	}
	
	public AdminRequest addGroup(String group) {
		this.group.add(group);
		return this;
	}

	public List<String> getField() {
		return field;
	}

	public AdminRequest setField(List<String> field) {
		this.field = field;
		return this;
	}
	
	public List<String> getLoadlazy() {
		return loadlazy;
	}

	public AdminRequest setLoadlazy(List<String> loadlazy) {
		this.loadlazy = loadlazy;
		return this;
	}

	public Map<String, Object> getValue() {
		return value;
	}

	public AdminRequest setValue(Map<String, Object> value) {
		this.value = value;
		return this;
	}
	
	public List<Map<String, Object>> getValues() {
		return values;
	}

	public AdminRequest setValues(List<Map<String, Object>> values) {
		this.values = values;
		return this;
	}



	public static class Filter implements Serializable {
		
		private String field;
		
		private ConditionType condition;
		
		private LogicalType logical;
		
		private String value;
		
		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public ConditionType getCondition() {
			return condition;
		}

		public void setCondition(ConditionType condition) {
			this.condition = condition;
		}

		public LogicalType getLogical() {
			return logical;
		}

		public void setLogical(LogicalType logical) {
			this.logical = logical;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return "[field=" + field + ", condition=" + condition + ", logical=" + logical + ", value=" + value + "]";
		}

		public static Filter NEW(LogicalType logical, String field, ConditionType condition, String value) {
			Filter o = new Filter();
			o.condition = condition;
			o.logical = logical;
			o.field = field;
			o.value = value;
			return o;
		}
		
		public static Filter AND(String field, ConditionType condition, String value) {
			return NEW(LogicalType.and, field, condition, value);
		}
		
		public static Filter OR(String field, ConditionType condition, String value) {
			return NEW(LogicalType.or, field, condition, value);
		}
		
	}
	
}
