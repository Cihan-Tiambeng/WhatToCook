import java.util.Date;

public class Log {
	// PROPERTIES
	private int ID;
	private long date;
	private static String user;
	private String action;
	private String description;

	DBConnection databaseConnection;
	static DBTable logTable;
	Admin admin;

	// CONTRUCTORS
	// Connection'u prrogramdan almasi lazim aslinda
	public Log(Admin currentUser, DBConnection databaseConnection) {
		user = currentUser.logName();
		this.databaseConnection = databaseConnection;
		logTable = new DBTable(databaseConnection);
	}

	// METHODS 
	public static void addLog (String action, String description, String itemID) throws Exception {
		long dateStatic = new Date().getTime();
		String insertString = logTable.generateId("LogTable") + "," + dateStatic + "," + user + "," + action + "," + description;
		logTable.insertRow( insertString , "LogTable" );
	}

	public static void logIn (String name, String password) throws Exception {
		long dateStatic = new Date().getTime();
		String insertString = logTable.generateId("LogTable") + "," + dateStatic + "," + user + "," + "Log In" + "," + " _ ";
		logTable.insertRow( insertString , "LogTable" );
	}
}