package com.nosql.mongoteste;

import mongo.dao.Connector;
import mongo.mainquery.MainQuery;
import mongo.query.MongoQueryResult;
import util.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import model.Cidade;
import model.GrupoEmpresarial;

public class App {

	public static void main(String[] args) {
		Connector connector = new Connector(Constants.getHostnameMongo(), Constants.getPortMongo(), Constants.getDatabaseMongo());
		connector.openConnection();
		MongoDatabase db = connector.getDb();

		// MainQuery query = new MainQuery(connector);
		// // MongoQueryResult result = query.query();
		// // System.out.println(result.getFieldNames());
		//
		// List<Document> result = query.query("PA");
		// for (Document document : result) {
		// System.out.println(document);
		// }

		// for (ArrayList<Object> row : result.getValues()) {
		// for (Object object : row) {
		// System.out.println(object.toString());
		// }
		// }

		// FindIterable<Document> testar = db.getCollection("cidade").find();
		// Document t = testar.first();
		// System.out.println("teste " + t);
		//
		// Cidade c = Cidade.toObject(t);
		// System.out.println(c.toString());

		// GrupoEmpresarial ge = new GrupoEmpresarial(02, 444846464, "teste
		// inserção", 22);
		// MongoCollection<Document> collection =
		// db.getCollection("grupoempresarial");
		//
		// Document teste = Document.parse(ge.toJson());
		// collection.insertOne(teste);
		// System.out.println(teste);

		connector.closeConnection();
	}
}
