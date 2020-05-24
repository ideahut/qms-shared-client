package com.github.ideahut.qms.shared.client.object;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.github.ideahut.qms.shared.client.type.GridControlType;
import com.github.ideahut.qms.shared.client.type.GridMatrixType;
import com.github.ideahut.qms.shared.client.type.GridValidationType;
import com.github.ideahut.qms.shared.client.type.HorizontalAlignType;
import com.github.ideahut.qms.shared.client.type.IdType;

@SuppressWarnings("serial")
public class Grid implements Serializable {
	
	private String name;
	
	private String title;
	
	private String admin; // untuk akses ke admin resource (common)
	
	private String path; // untuk akses ke model resource(cth: UserResource) yg mengimplementasi CRUD
	
	private Set<String> idFields;
	
	private Set<String> embeddedIdFields;
	
	private IdType idType;
	
	private Grid.Table table = new Grid.Table();
	
	private Grid.Order order = new Grid.Order();
	
	private Grid.Filter filter = new Grid.Filter();
	
	private Map<String, Grid.Column> columns = new LinkedHashMap<String, Grid.Column>();
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Set<String> getIdFields() {
		return idFields;
	}

	public void setIdFields(Set<String> idFields) {
		this.idFields = idFields;
	}

	public Set<String> getEmbeddedIdFields() {
		return embeddedIdFields;
	}

	public void setEmbeddedIdFields(Set<String> embeddedIdFields) {
		this.embeddedIdFields = embeddedIdFields;
	}

	public IdType getIdType() {
		return idType;
	}

	public void setIdType(IdType idType) {
		this.idType = idType;
	}

	public Grid.Table getTable() {
		return table;
	}

	public void setTable(Grid.Table table) {
		this.table = table;
	}

	public Grid.Order getOrder() {
		return order;
	}

	public void setOrder(Grid.Order order) {
		this.order = order;
	}

	public Grid.Filter getFilter() {
		return filter;
	}

	public void setFilter(Grid.Filter filter) {
		this.filter = filter;
	}

	public Map<String, Grid.Column> getColumns() {
		return columns;
	}

	public void setColumns(Map<String, Grid.Column> columns) {
		this.columns = columns;
	}

	
	public static class Table implements Serializable {
		private List<Grid.Table.Header> headers = new ArrayList<Grid.Table.Header>();
		private Boolean multiselect = Boolean.FALSE;
		private Boolean footer = Boolean.FALSE;
		public List<Grid.Table.Header> getHeaders() {
			return headers;
		}
		public void setHeaders(List<Grid.Table.Header> headers) {
			this.headers = headers;
		}
		public Boolean getMultiselect() {
			return multiselect;
		}
		public void setMultiselect(Boolean multiselect) {
			this.multiselect = multiselect;
		}
		public Boolean getFooter() {
			return footer;
		}
		public void setFooter(Boolean footer) {
			this.footer = footer;
		}

		public static class Header extends Sort {
			private String label;
			private String column;
			private HorizontalAlignType titleAlign;
			private HorizontalAlignType contentAlign;
			public String getLabel() {
				return label;
			}
			public void setLabel(String label) {
				this.label = label;
			}
			public String getColumn() {
				return column;
			}
			public void setColumn(String column) {
				this.column = column;
			}
			public HorizontalAlignType getTitleAlign() {
				return titleAlign;
			}
			public void setTitleAlign(HorizontalAlignType titleAlign) {
				this.titleAlign = titleAlign;
			}
			public HorizontalAlignType getContentAlign() {
				return contentAlign;
			}
			public void setContentAlign(HorizontalAlignType contentAlign) {
				this.contentAlign = contentAlign;
			}						
		}
	}
	
	public static class Order implements Serializable {
		private GridMatrixType matrixType = GridMatrixType.single;
		private List<Grid.Order.Item> items = new ArrayList<Grid.Order.Item>();
		private Integer matrixNum; // jumlah kolom
		public GridMatrixType getMatrixType() {
			return matrixType;
		}
		public void setMatrixType(GridMatrixType matrixType) {
			this.matrixType = matrixType;
		}
		public List<Grid.Order.Item> getItems() {
			return items;
		}
		public void setItems(List<Grid.Order.Item> items) {
			this.items = items;
		}
		public Integer getMatrixNum() {
			return matrixNum;
		}
		public void setMatrixNum(Integer matrixNum) {
			this.matrixNum = matrixNum;
		}

		public static class Item extends Sort {
			private String label;
			private String column;
			private String orderType;
			public String getLabel() {
				return label;
			}
			public void setLabel(String label) {
				this.label = label;
			}
			public String getColumn() {
				return column;
			}
			public void setColumn(String column) {
				this.column = column;
			}
			public String getOrderType() {
				return orderType;
			}
			public void setOrderType(String orderType) {
				this.orderType = orderType;
			}			
		}
	}
	
	public static class Filter implements Serializable {
		private GridMatrixType matrixType = GridMatrixType.single;
		private Integer matrixNum;
		private List<Grid.Filter.Item> items = new ArrayList<Grid.Filter.Item>();
		public GridMatrixType getMatrixType() {
			return matrixType;
		}
		public void setMatrixType(GridMatrixType matrixType) {
			this.matrixType = matrixType;
		}
		public Integer getMatrixNum() {
			return matrixNum;
		}
		public void setMatrixNum(Integer matrixNum) {
			this.matrixNum = matrixNum;
		}
		public List<Grid.Filter.Item> getItems() {
			return items;
		}
		public void setItems(List<Grid.Filter.Item> items) {
			this.items = items;
		}

		public static class Item extends Sort {
			private String label;
			private String column;
			private String condition;
			private String logical;
			public String getLabel() {
				return label;
			}
			public void setLabel(String label) {
				this.label = label;
			}
			public String getColumn() {
				return column;
			}
			public void setColumn(String column) {
				this.column = column;
			}
			public String getCondition() {
				return condition;
			}
			public void setCondition(String condition) {
				this.condition = condition;
			}
			public String getLogical() {
				return logical;
			}
			public void setLogical(String logical) {
				this.logical = logical;
			}			
		}
	}
	
	public static class Column extends Sort {
		private String name = "";
		private String label;
		private GridControlType controlType;
		private String metadata;
		private HorizontalAlignType align;
		private Boolean editable = Boolean.TRUE;
		private Boolean insertable = Boolean.TRUE;
		private Boolean visible = Boolean.TRUE;
		private Boolean readOnly = Boolean.FALSE;
		private Boolean required = Boolean.TRUE;
		private String defaultValue;
		
		// Menyimpan value berdasarkan @GridControlType
		private List<KeyValue<String, String>> options;
		private Admin admin;
		
		// Melakukan pemanggilan ke admin berdasarkan id
		private String recall;
		
		private String viewColumn;
		private Boolean isModel;
		private Set<String> idFields;		
		private Map<String, String> embeddedIdFields;
		private IdType idType;
		
		// Validation
		private List<Grid.Validation> validations;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getLabel() {
			return label;
		}
		public void setLabel(String label) {
			this.label = label;
		}
		public GridControlType getControlType() {
			return controlType;
		}
		public void setControlType(GridControlType controlType) {
			this.controlType = controlType;
		}
		public Set<String> getIdFields() {
			return idFields;
		}
		public void setIdFields(Set<String> idFields) {
			this.idFields = idFields;
		}
		public Map<String, String> getEmbeddedIdFields() {
			return embeddedIdFields;
		}
		public void setEmbeddedIdFields(Map<String, String> embeddedIdFields) {
			this.embeddedIdFields = embeddedIdFields;
		}
		public String getMetadata() {
			return metadata;
		}
		public void setMetadata(String metadata) {
			this.metadata = metadata;
		}
		public HorizontalAlignType getAlign() {
			return align;
		}
		public void setAlign(HorizontalAlignType align) {
			this.align = align;
		}
		public Boolean getEditable() {
			return editable;
		}
		public void setEditable(Boolean editable) {
			this.editable = editable;
		}
		public Boolean getInsertable() {
			return insertable;
		}
		public void setInsertable(Boolean insertable) {
			this.insertable = insertable;
		}
		public Boolean getVisible() {
			return visible;
		}
		public void setVisible(Boolean visible) {
			this.visible = visible;
		}
		public Boolean getReadOnly() {
			return readOnly;
		}
		public void setReadOnly(Boolean readOnly) {
			this.readOnly = readOnly;
		}
		public Boolean getRequired() {
			return required;
		}
		public void setRequired(Boolean required) {
			this.required = required;
		}
		public String getDefaultValue() {
			return defaultValue;
		}
		public void setDefaultValue(String defaultValue) {
			this.defaultValue = defaultValue;
		}
		public List<KeyValue<String, String>> getOptions() {
			return options;
		}
		public void setOptions(List<KeyValue<String, String>> options) {
			this.options = options;
		}
		public Admin getAdmin() {
			return admin;
		}
		public void setAdmin(Admin admin) {
			this.admin = admin;
		}
		public String getRecall() {
			return recall;
		}
		public void setRecall(String recall) {
			this.recall = recall;
		}
		public Boolean getIsModel() {
			return isModel;
		}
		public void setIsModel(Boolean isModel) {
			this.isModel = isModel;
		}
		public String getViewColumn() {
			return viewColumn;
		}
		public void setViewColumn(String viewColumn) {
			this.viewColumn = viewColumn;
		}
		public IdType getIdType() {
			return idType;
		}
		public void setIdType(IdType idType) {
			this.idType = idType;
		}
		public List<Grid.Validation> getValidations() {
			return validations;
		}
		public void setValidations(List<Grid.Validation> validations) {
			this.validations = validations;
		}		
	}
	
	public static class Admin implements Serializable {
		private String pattern;
		private AdminRequest request;
		public String getPattern() {
			return pattern;
		}
		public void setPattern(String pattern) {
			this.pattern = pattern;
		}
		public AdminRequest getRequest() {
			return request;
		}
		public void setRequest(AdminRequest request) {
			this.request = request;
		}		
	}
	
	public static class Validation implements Serializable {
		private GridValidationType type;		
		private String format;
		private int minLength;
		private int maxLength;		
		private int rangeLength;
		private String minValue;
		private String maxValue;		
		private String rangeValue;
		public GridValidationType getType() {
			return type;
		}
		public void setType(GridValidationType type) {
			this.type = type;
		}
		public String getFormat() {
			return format;
		}
		public void setFormat(String format) {
			this.format = format;
		}
		public int getMinLength() {
			return minLength;
		}
		public void setMinLength(int minLength) {
			this.minLength = minLength;
		}
		public int getMaxLength() {
			return maxLength;
		}
		public void setMaxLength(int maxLength) {
			this.maxLength = maxLength;
		}
		public int getRangeLength() {
			return rangeLength;
		}
		public void setRangeLength(int rangeLength) {
			this.rangeLength = rangeLength;
		}
		public String getMinValue() {
			return minValue;
		}
		public void setMinValue(String minValue) {
			this.minValue = minValue;
		}
		public String getMaxValue() {
			return maxValue;
		}
		public void setMaxValue(String maxValue) {
			this.maxValue = maxValue;
		}
		public String getRangeValue() {
			return rangeValue;
		}
		public void setRangeValue(String rangeValue) {
			this.rangeValue = rangeValue;
		}					
	}
	
	public static class Sort implements Serializable {
		private Integer sort = new Integer(0);
		public Integer getSort() {
			return sort;
		}
		public void setSort(Integer sort) {
			this.sort = sort;
		}		
	}
		
}
