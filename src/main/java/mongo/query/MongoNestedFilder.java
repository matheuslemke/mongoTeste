package mongo.query;

import java.util.LinkedList;
import java.util.List;

public class MongoNestedFilder {

	private List<String> nestedForeigns = new LinkedList<String>();
	private List<String> fieldNames = new LinkedList<String>();

	public MongoNestedFilder(List<String> nestedForeignFieldNames, List<String> fieldNames) {
		super();
		this.nestedForeigns = nestedForeignFieldNames;
		this.fieldNames = fieldNames;
	}

	public List<String> getNestedForeignFields() {
		List<String> list = new LinkedList<String>();
		for (int i = 0; i < nestedForeigns.size(); i++)
			list.add(nestedForeigns.get(i) + "." + fieldNames.get(i));
		return list;
	}

	public List<String> getNestedForeigns() {
		return nestedForeigns;
	}

	public void setNestedForeigns(List<String> nestedForeigns) {
		this.nestedForeigns = nestedForeigns;
	}

	public List<String> getFieldNames() {
		return fieldNames;
	}

	public void setFieldNames(List<String> fieldNames) {
		this.fieldNames = fieldNames;
	}

}
