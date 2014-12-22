/* This class creates a connection to a MySql database over the Internet 
 *
 * Date: 23.02.2013
 * Author : Cihan Tiambeng
 */

/* These are the details about the database:
 * Host name: SQL09.FREEMYSQL.NET
 * Port: 3306
 * Database name: csproject
 * User name: asuleym
 * Password: asd123
 * 
 * There is 1 table in the database, here are the details:
 * 
 * name: table1
 * columns:
   1: id (INT)
   2: findDate (long)
   3: lostDateEstimate (long)
   4: returnDate (long)
   5: type (String)
   6: brand (String)
   7: color (String)
   8: lostLocation (String)
   9: otherTags (String)
  10: isReturned (BINARY)
 * jdbc:mysql://SQL09.FREEMYSQL.NET:3306/csproject" , "asuleym" , "asd123"
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class DBConnection {
	
	private Connection conn;
	private boolean connIsUp;

	//CONSTRUCTOR. assigns the connection details to con and also establishes the connection
	public DBConnection( ) throws Exception
	{
		//Accessing driver from JAR file
		Class.forName( "com.mysql.jdbc.Driver" );
	
		connIsUp = true;			// if con does not get established properly, this gets set to false
		
		//Creating a variable for connection
		try{
		conn = DriverManager.getConnection("jdbc:mysql://localhost/wtc" , "root" , "CS319");
		if (connIsUp){
		System.out.println( " connection is successful"); 
		}
		}
		catch (SQLException e){
			System.out.println(e);	
			connIsUp = false;		// if con does not get established properly, this gets set to false
		}
		
	}
	
	// Re establishes the connection
	public void coseConnection () throws Exception{
		if (conn != null) 
    		conn.close();
    	connIsUp = false;
	}
	
	// returns conIsEstablished
	public boolean getConnStatus(){
		
		// if con does not get established properly, connIsUp is set false
		try{
		conn.prepareStatement("SELECT 1 FROM ItemTable").executeQuery();
		connIsUp = true;
		}
		catch (SQLException e){
			System.out.println(e);	
			connIsUp = false;		
		}
		return connIsUp;	
	}

	
	public Connection conn()
	{
		return conn;
	}
	
}