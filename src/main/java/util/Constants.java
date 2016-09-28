package util;

public class Constants {
    private static String hostnameMongo = "PC-JAVA-47";
    private static int portMongo = 27017;
    private static String databaseMongo = "testeEstagio";

    public static String getHostnameMongo() {
	return hostnameMongo;
    }

    public static void setHostnameMongo(String hostnameMongo) {
	Constants.hostnameMongo = hostnameMongo;
    }

    public static int getPortMongo() {
	return portMongo;
    }

    public static void setPortMongo(int portMongo) {
	Constants.portMongo = portMongo;
    }

    public static String getDatabaseMongo() {
	return databaseMongo;
    }

    public static void setDatabaseMongo(String databaseMongo) {
	Constants.databaseMongo = databaseMongo;
    }

}
