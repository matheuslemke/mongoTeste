package com.nosql.mongoteste;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import dao.Connector;
import util.Constants;
import util.DateParser;

import java.util.Date;

import org.bson.Document;

public class App {

    public static void main(String[] args) {
	Connector connector = new Connector(Constants.getHostname(), Constants.getPort(), Constants.getDatabase());
	connector.openConnection();
	MongoDatabase db = connector.getDb();

	MongoCollection<Document> parceiroCollection = db.getCollection("parceiro");
	FindIterable<Document> iterableParceiro = parceiroCollection.find(Filters.eq("HOMEPAGE", ""));

	for (Document parceiro : iterableParceiro) {
	    System.out.println(parceiro.getString("HOMEPAGE").isEmpty());
	    break;
	}
	connector.closeConnection();
    }
}
