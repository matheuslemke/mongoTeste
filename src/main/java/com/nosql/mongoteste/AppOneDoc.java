package com.nosql.mongoteste;

import mongo.dao.Connector;
import mongo.mainquery.MainQueryOneDoc;

import org.bson.Document;

import util.Constants;

import com.mongodb.client.MongoCursor;

public class AppOneDoc {
	public static void main(String[] args) {
		// String value = "*star";
		// String quote = Pattern.quote(value);
		// System.out.println(value);
		// System.out.println(quote);

		Connector connectorPentaho = new Connector(
				Constants.getHostnameMongo(), Constants.getPortMongo(),
				Constants.getDatabaseMongoPentaho());
		connectorPentaho.openConnection();
		MainQueryOneDoc mq = new MainQueryOneDoc(connectorPentaho);

		// for (MongoCursor<Document> iterator = mq.query().iterator(); iterator
		// .hasNext();)
		// System.out.println(iterator.next());

		// for (MongoCursor<Document> iterator = mq.query("boca de burro")
		// .iterator(); iterator.hasNext();)
		// System.out.println(iterator.next());

		for (MongoCursor<Document> iterator = mq.query("IDCIDADE", 9570682)
				.iterator(); iterator.hasNext();)
			System.out.println(iterator.next());

		System.out.print("Tempo de consulta = ");
		System.out.format("%.4fs\n", Constants.getExecutionTime() / 1000);
		connectorPentaho.closeConnection();
	}
}
