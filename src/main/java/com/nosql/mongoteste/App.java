package com.nosql.mongoteste;

import mongo.dao.Connector;
import mongo.mainquery.MainQuery;
import mongo.names.CidadeNames;
import mongo.query.DocumentFinder;
import mongo.query.MongoQueryResult;
import util.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import model.Cidade;
import model.GrupoEmpresarial;

public class App {

	public static void main(String[] args) {
		Connector connector = new Connector(Constants.getHostnameMongo(),
				Constants.getPortMongo(), Constants.getDatabaseMongo());
		connector.openConnection();

		MainQuery mainQuery = new MainQuery(connector);

		MongoQueryResult result1 = mainQuery.queryInsideDocsWithFilter();

		MongoQueryResult result2 = mainQuery.queryInsideDocsWithoutFilter();

		List<Document[]> result3 = mainQuery.queryBlockForeach();

		mainQuery.queryIndividualsDocsWithoutFilter();

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
