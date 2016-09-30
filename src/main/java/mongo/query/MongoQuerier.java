package mongo.query;

public interface MongoQuerier {

	public MongoQueryResult query();

	public void defineRow(MongoQueryResult result);
}
