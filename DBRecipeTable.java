
public class DBRecipeTable extends DBTable{
	
	String table;
	
	public DBRecipeTable( DBConnection DBConn, String table )
	{
		super(DBConn);
		this.table = table;
	}
	
	
}
