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

class DBAdminTable extends DBTable{
	
	String table;
	
	public DBAdminTable( DBConnection DBConn, String table )
	{
		super(DBConn);
		this.table = table;
	}
	
	public boolean check( String name, String MD5 ) throws Exception
	{
		ResultSet rs = read( "WHERE name='" + name + "'" , "MD5" , table );
		if ( rs != null && rs.next() )
			if ( rs.getString(1).equals(MD5) )
			{
				return true;
			}
			else
			{
				return false;
			}
		else
			return false;
	}
	
}
