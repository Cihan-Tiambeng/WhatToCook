/* This class creates a connection to a MySql database over the Internet 
 *
 * Author : Cihan Tiambeng
 */

/* These are the details about the database:
 * Host name: SQL09.FREEMYSQL.NET
 * Port: 3306
 * Database name: wtc
 * User name: root
 * Password: CS319
 * 
 * There is 1 table in the database, here are the details:
 * 
 * name: table1
 * columns:
   1: id (INT)
   2: name (VARCHAR)
   3: cal (INT)
   4: likes (INT)
   5: cookingtime (INT)
   6: ingredients (MEDIUMTEXT)
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