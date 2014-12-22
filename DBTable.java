import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.ResultSetMetaData;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.ArrayList;


// holds functions for manipulating the tables in the database
// takes the DBConnection object in the constructor
class DBTable {
	
	DBConnection DBConn;
	
	//constructor
	public DBTable( DBConnection DBConn )
	{
		this.DBConn = DBConn;
	}
	
	/////////
	//USEFUL methods
	////////////
	// Inserts a new row with custom insert statement
	public void insertRow( String values , String table ) throws Exception {	
		
		//Accessing driver from JAR file
		Class.forName( "com.mysql.jdbc.Driver" );
		
		long findDate = System.currentTimeMillis();
		int id = generateId(table);					// getting an id

		//executing an insert statement in a try block
		try{
			DBConn.conn().createStatement().executeUpdate("INSERT INTO " + table + " VALUES (" + toDbString( values ) + ")");
		}
		catch (SQLException e){
			System.out.println(e);
		}
	}
	// reads a table and returns it as a ItemContainer
	public RowContainer readTable( String table ) throws Exception {
			
		//Accessing driver from JAR file
		Class.forName( "com.mysql.jdbc.Driver" );
		
		//VARIABLES
		ResultSet rs = null;
		PreparedStatement statement;
		RowContainer cont = new RowContainer(); 
		Row row;
		//ArrayList<String> list = new ArrayList<String>();
		
		//PROGRAM CODE
		//Creating a "select" query

		statement = DBConn.conn().prepareStatement("SELECT " + "*" + " FROM " + table + " ORDER BY ID ASC");

		
		//Creating a variable to execute query
		try{
			rs = statement.executeQuery();
		}
		catch (SQLException e){
			System.out.println(e);
		}
		
		ResultSetMetaData rsmd = rs.getMetaData();
     	int colsNum = rsmd.getColumnCount();
     	String tag; 
     	//System.out.println(colsNum);
		try {
	        while (rs.next()) {
	        	row = new Row( colsNum );
				for ( int i = 1 ; i < colsNum ; i++ )
				{
					tag = rsmd.getColumnName(i);
					row.addTag( tag );
					row.setValue( tag , rs.getString(tag) );
					
	        	}
				// adds a new DBRow to the rowlist
     			cont.addRow(row);
											    
        	}
    	} 
    	catch (SQLException e ){
    	}
		
		
		return cont;
	}
	// Deletes a row
	public void deleteRow( int id, String table ) throws Exception
	{
		//Accessing driver from JAR file
		Class.forName( "com.mysql.jdbc.Driver" );

		//executing a delete statement in a try block
		try{
			DBConn.conn().createStatement().executeUpdate("DELETE FROM " + table + " WHERE ID=" + id);
		}
		catch (SQLException e){
			System.out.println(e);
		}
		
	}
	// returns the last ID
	private int getLastID( String table ) throws Exception
	{
		int id = 0;
		
		// Selecting ID from table, ordering them, and getting the largest 
		String statement = "SELECT ID FROM " + table + " ORDER BY ID DESC LIMIT 1";
		ResultSet result = DBConn.conn().prepareStatement( statement ).executeQuery();
		
		// if resultSet is not empty, assign id to the integer in the resultSet and add 1		
		if (result.next())
			id = result.getInt(1);
		return id;
	}
	
	// eg for setString type='phone',color='blue',... . eg for whereString: type='phone' AND color='blue' . or u can just use ID=40 
	// can set multiple columns of one row at once. and can even do that to multiple rows if you screw up your whereString. so dont :)
	public void editRow( String setString, String whereString , String table ) throws Exception
	{
		//Accessing driver from JAR file
		Class.forName( "com.mysql.jdbc.Driver" );
		//executing a set statement in a try block
		try{
			DBConn.conn().createStatement().executeUpdate("UPDATE " + table + " SET " + setString + " WHERE " + whereString);
		}
		catch (SQLException e){
			System.out.println(e);
		}	
	}
	
	////////////////
	///////////////
	
	// generates an ID for the next row insertion
	public int generateId( String table ) throws Exception
	{
		int id = 1;
		
		// Selecting ID from table, ordering them, and getting the largest 
		String statement = "SELECT ID FROM " + table + " ORDER BY ID DESC LIMIT 1";
		ResultSet result = DBConn.conn().prepareStatement( statement ).executeQuery();
		
		// if resultSet is not empty, assign id to the integer in the resultSet and add 1		
		if (result.next())
			id = result.getInt(1) + 1;
		return id;
	}
	// whereString must be in the form "[column name]=[content]"
	public ResultSet read( String whereString, String column , String table ) throws Exception {
			
		//Accessing driver from JAR file
		Class.forName( "com.mysql.jdbc.Driver" );
		
		//VARIABLES
		ResultSet result = null;
		PreparedStatement statement;
		
		//PROGRAM CODE
		//Creating a "select" query

		statement = DBConn.conn().prepareStatement("SELECT " + column + " FROM " + table + " " + whereString + " ORDER BY ID ASC");
		System.out.println( "SELECT " + column + " FROM " + table + " " + whereString + " ORDER BY ID ASC");
		
		//Creating a variable to execute query
		try{
			result = statement.executeQuery();
		}
		catch (SQLException e){
			System.out.println(e);
		}
		
		
		return result;
	}
	
	public Row readRow( String whereString, String column , String table ) throws Exception {
			
		//Accessing driver from JAR file
		Class.forName( "com.mysql.jdbc.Driver" );
		
		//VARIABLES
		ResultSet rs;
		Row row;
		ResultSetMetaData rsmd;
     	int colsNum;
     	String tag; 
     		
     	//PROGRAM CODE
     	rs = read( whereString, column , table );
     	rsmd = rs.getMetaData();
     	colsNum = rsmd.getColumnCount();
		if ( rs.next() )
		{
			System.out.println( colsNum +"");
	        row = new Row( colsNum );
			for ( int i = 1 ; i < colsNum + 1 ; i++ )
			{
				tag = rsmd.getColumnName(i);
				row.addTag( tag );
				row.setValue( tag , rs.getString(tag) );
	        }										    
        }
        else
        {
        	row = null;
		}
		
		return row;
	}
	
	public RowContainer readTable( String whereString, String column , String table ) throws Exception {
			
		//Accessing driver from JAR file
		Class.forName( "com.mysql.jdbc.Driver" );
		
		//VARIABLES
		ResultSet rs = null;
		RowContainer cont = new RowContainer(); 
		Row row;
		
		//PROGRAM CODE
		rs = read( whereString, column , table );

		ResultSetMetaData rsmd = rs.getMetaData();
	 	int colsNum = rsmd.getColumnCount();
	 	String tag; 
	 	//System.out.println(colsNum);
		try {
	        while (rs.next()) {
	        	row = new Row( colsNum );
				for ( int i = 1 ; i < colsNum ; i++ )
				{
					tag = rsmd.getColumnName(i);
					row.addTag( tag );
					row.setValue( tag , rs.getString(tag) );
	        	}
				// adds a new DBRow to the rowlist
	 			cont.addRow(row);						    
	    	}
		} 
		catch (SQLException e ){
		}
		return cont;
	}
	
	
	// prints some columns from the table from MySql server
	public void printTable( String table ) throws Exception {
			
		//Accessing driver from JAR file
		Class.forName( "com.mysql.jdbc.Driver" );
		
		//VARIABLES
		ResultSet result;
		PreparedStatement statement;
		
		//PROGRAM CODE
		//Creating a "select" query
		statement = DBConn.conn().prepareStatement("SELECT * FROM " + table + " ORDER BY ID ASC");
		
		//Creating a variable to execute query
		result = statement.executeQuery();
		
		while (result.next())
		{
			System.out.format("%4d", result.getInt(1));												
			System.out.println(" " + convertTime(result.getLong(2)) + " " + result.getString(5));		
		}
		
	}
	
	// converts from Unix time (epoch) to conventional time format
	public String convertTime( long epoch ){
			
		Date date = new Date(epoch);
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		//format.setTimeZone(TimeZone.getTimeZone("Australia/Sydney"));
		String formattedTime = format.format(date);
		return formattedTime;
	}
	
	//	String getItem( String column, String row);
	
		// prints the complete table from MySql server
	public void printCompleteTable( ) throws Exception {	
		//Accessing driver from JAR file
		Class.forName( "com.mysql.jdbc.Driver" );
		
		//VARIABLES
		ResultSet result;
		PreparedStatement statement;
		
		//PROGRAM CODE
		//Creating a "select" query
		statement = DBConn.conn().prepareStatement("select * from table1");
		
		//Creating a variable to execute query
		result = statement.executeQuery();
		
		while (result.next())
		{
			System.out.println(result.getString(1) + " " + convertTime(result.getInt(2)) + " " + result.getString(3) + " " + result.getString(4) + " " + result.getString(5) + " " + result.getString(6) + " " + result.getString(7) );		
		}
		
	}
	
	
	// converts "item1,item2,item3" to "'item1','item2','item3'" 
	public String toDbString( String values )
	{
		String convertedValuesString;
		String temp;
		int i = 0;
		convertedValuesString = "";
		for ( ; i <= values.lastIndexOf(',') ; )
		{
			temp = values.substring( i , values.indexOf( ',' , i ) );
			
			if ( temp.matches("-?\\d+(\\.\\d+)?") )
				convertedValuesString = convertedValuesString + temp;	
			else
				convertedValuesString = convertedValuesString + "'" + temp + "'";
			
			i = values.indexOf( ',' , i ) + 1;
			convertedValuesString = convertedValuesString + "," ;
		}
		temp = values.substring( i , values.length() );
		convertedValuesString = convertedValuesString + "'" + temp + "'";
		return convertedValuesString;
	}
	
	
}

