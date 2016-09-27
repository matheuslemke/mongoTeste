package util;

public class Constants {
    private static String hostname = "PC-JAVA-47";
    private static int port = 27017;
    private static String database = "testeEstagio";

    public static String getHostname() {
	return hostname;
    }

    public static void setHostname(String hostname) {
	Constants.hostname = hostname;
    }

    public static int getPort() {
	return port;
    }

    public static void setPort(int port) {
	Constants.port = port;
    }

    public static String getDatabase() {
	return database;
    }

    public static void setDatabase(String database) {
	Constants.database = database;
    }
}
