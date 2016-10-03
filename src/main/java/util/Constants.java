package util;

public class Constants {
	private static String hostnameMongo = "PC-JAVA-47";
	private static int portMongo = 27017;
	private static String databaseMongo = "testeEstagio";

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

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
