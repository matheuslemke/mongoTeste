package dao;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import names.EnderecoLocalNames;

public class Selector {

    private Connector connector;

    public Selector(Connector connector) {
	super();
	this.connector = connector;
    }

    public FindIterable<Document> findEnderecoLocal() {
	
	return null;
    }
}
