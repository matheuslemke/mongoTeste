package mongo.query;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MongoQueryResult {
	private String[] fieldNames;
	private List<ArrayList<Object>> values = new LinkedList<ArrayList<Object>>();

	public MongoQueryResult() {
		super();
	}

	public MongoQueryResult(String[] fieldNames) {
		super();
		this.fieldNames = fieldNames;
	}

	public String[] getFieldNames() {
		return fieldNames;
	}

	public void setFieldNames(String[] fieldNames) {
		this.fieldNames = fieldNames;
	}

	public List<ArrayList<Object>> getValues() {
		return values;
	}

	public void setValues(List<ArrayList<Object>> values) {
		this.values = values;
	}
}
