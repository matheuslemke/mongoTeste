package finders;

import org.bson.Document;

import com.mongodb.client.FindIterable;

import dao.Connector;
import names.EnderecoLocalNames;

public class EnderecoLocalFinder {

    private Connector connector;

    public EnderecoLocalFinder(Connector connector) {
	super();
	this.connector = connector;
    }

    public Connector getConnector() {
	return connector;
    }

    public void setConnector(Connector connector) {
	this.connector = connector;
    }

    public FindIterable<Document> findAll() {
	return connector.getDb().getCollection(EnderecoLocalNames.ENDERECOLOCAL).find();
    }
}
