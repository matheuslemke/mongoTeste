package mongo.mainquery;

import org.bson.Document;

import util.Constants;

import com.mongodb.client.FindIterable;

import mongo.dao.Connector;
import mongo.query.DocumentFinder;

public class MainQueryOneDoc {
	private DocumentFinder finder;

	public MainQueryOneDoc(Connector connector) {
		super();
		this.finder = new DocumentFinder(connector);
	}

	public FindIterable<Document> query() {
		return finder.findAll(Constants.getCollectionNamePentaho());
	}

	public FindIterable<Document> query(String input) {
		return finder.findAllByText(Constants.getCollectionNamePentaho(),
				Constants.getFieldsToFiltrate(), input);
	}

	public FindIterable<Document> query(String fieldName, long value) {
		return finder.findWhere(Constants.getCollectionNamePentaho(),
				fieldName, value);
	}

}
