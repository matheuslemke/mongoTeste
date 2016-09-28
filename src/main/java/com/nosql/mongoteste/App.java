package com.nosql.mongoteste;

import mongo.dao.Connector;
import mongo.mainquery.MainQuery;
import util.Constants;

import java.util.HashMap;
import java.util.List;

public class App {

    public static void main(String[] args) {
	Connector connector = new Connector(Constants.getHostnameMongo(), Constants.getPortMongo(), Constants.getDatabaseMongo());
	connector.openConnection();

	MainQuery query = new MainQuery(connector);
	List<HashMap<String, Object>> result = query.query();
	for (HashMap<String, Object> row : result) {
	    System.out.println(row);
	}

	connector.closeConnection();
    }
}
