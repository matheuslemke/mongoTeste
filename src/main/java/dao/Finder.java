package dao;

import org.bson.Document;

import com.mongodb.client.FindIterable;

public class Finder {

    private Connector connector;

    public Finder(Connector connector) {
	super();
	this.connector = connector;
    }

    public Connector getConnector() {
	return connector;
    }

    public void setConnector(Connector connector) {
	this.connector = connector;
    }

    public Document findFrom(Document document, String fieldName) {
	return (Document) document.get(fieldName);
    }

    public FindIterable<Document> findAll(String collectionName) {
	return connector.getDb().getCollection(collectionName).find();
    }
}
