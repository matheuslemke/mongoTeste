package dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

// To directly connect to a single MongoDB server (note that this will
// not auto-discover the primary even
// if it's a member of a replica set:
// MongoClient mongoClient = new MongoClient();
// or
// MongoClient mongoClient = new MongoClient("localhost");
// or
public class Connector {
    private MongoDatabase db;
    private MongoClient mongoClient;
    private String hostName;
    private int port;
    private String database;

    public Connector(String hostName, int port, String database) {
	super();
	this.hostName = hostName;
	this.port = port;
	this.database = database;
    }

    /**
     * The connection must to be opened
     * 
     * @return MongoDatabase from MongoClient of Connector
     */
    public MongoDatabase getDb() {
	return db;
    }

    public void setDb(MongoDatabase db) {
	this.db = db;
    }

    public void openConnection() {
	mongoClient = new MongoClient(hostName, port);
	db = mongoClient.getDatabase(database);
    }

    public void closeConnection() {
	mongoClient.close();
    }

}
