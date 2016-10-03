package mongo.query;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import org.bson.Document;

import util.Parser;

import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;

import mongo.dao.Connector;
import mongo.exceptions.DocumentNotFoundException;
import mongo.names.EnderecoLocalNames;

public class DocumentFinder {

	private Connector connector;

	public DocumentFinder(Connector connector) {
		super();
		this.connector = connector;
	}

	public Connector getConnector() {
		return connector;
	}

	public void setConnector(Connector connector) {
		this.connector = connector;
	}

	public Document getOneByForeign(Document document, String foreignFieldName)
			throws DocumentNotFoundException, ClassCastException {
		Document documentReturn = (Document) document.get(foreignFieldName);
		if (documentReturn != null)
			return documentReturn;
		else
			throw new DocumentNotFoundException();
	}

	public Document getOneByForeign(Document document, String foreignFieldName,
			String filterFieldName, long filterValue)
			throws DocumentNotFoundException {
		return filtrate((Document) document.get(foreignFieldName), filterFieldName,
				filterValue);
	}

	public List<Document> findAll(String collectionName, Filter filter) {
		filter.setDocuments(connector.getDb().getCollection(collectionName).find());
		return filter.filtrate();
	}

	public FindIterable<Document> findAll(String collectionName) {
		return connector.getDb().getCollection(collectionName).find();
	}

	public Document findOneByForeign(String collectionName, String foreignFieldName,
			long foreignValue) throws DocumentNotFoundException {
		Document document = connector.getDb().getCollection(collectionName)
				.find(Filters.eq(foreignFieldName, foreignValue)).first();
		if (document != null)
			return document;
		throw new DocumentNotFoundException();
	}

	public Document findOneByForeignAndByText(String collectionName,
			String foreignFieldName, long foreignValue,
			MongoNestedFilder mongoNestedFilder, String text)
			throws DocumentNotFoundException {
		Document document = connector
				.getDb()
				.getCollection(collectionName)
				.find(Filters.and(Filters.eq(foreignFieldName, foreignValue),
						Filters.or(new Document(mongoNestedFilder
								.getNestedForeignFields().get(0), new Document()
								.append("$regex", "(?)" + Pattern.quote(text))
								.append("$options", "i"))))).first();
		if (document != null)
			return document;
		throw new DocumentNotFoundException();
	}

	public Document findOneByForeign(String collectionName, String foreignFieldName,
			long foreignValue, String filterFieldName, long filterValue)
			throws DocumentNotFoundException {
		return filtrate(
				connector.getDb().getCollection(collectionName)
						.find(Filters.eq(foreignFieldName, foreignValue)).first(),
				filterFieldName, filterValue);
	}

	private Document filtrate(Document documentReturn, String filterFieldName,
			long filterValue) throws DocumentNotFoundException {
		if (documentReturn.getInteger(filterFieldName) == filterValue)
			return documentReturn;
		else
			throw new DocumentNotFoundException();
	}

	public List<Document> findAllByText(String collectionName, String fieldName,
			String text) {
		Document regQuery = new Document();
		regQuery.append("$regex", "(?)" + Pattern.quote(text));
		regQuery.append("$options", "i");

		Document findQuery = new Document();
		findQuery.append(fieldName, regQuery);
		FindIterable<Document> iterable = connector.getDb()
				.getCollection(collectionName).find(findQuery);
		return Parser.toList(iterable);
	}

	/**
	 * Find all EnderecoLocal that attends to the requirements of the text
	 * 
	 * @param text
	 *            to filter
	 * @return all documents that attends to the filter
	 */
	public List<Document> findAllEnderecoLocalByText(MongoNestedFilder filder,
			Filter filter, String text) {
		List<Document> filterList = new LinkedList<Document>();
		for (String nestedForeignField : filder.getNestedForeignFields())
			filterList.add(new Document(nestedForeignField, new Document().append(
					"$regex", "(?)" + Pattern.quote(text)).append("$options", "i")));

		filter.setDocuments(connector.getDb()
				.getCollection(EnderecoLocalNames.COLLECTION)
				.find(Filters.or((Document[]) filterList.toArray())));
		return filter.filtrate();
	}
}
