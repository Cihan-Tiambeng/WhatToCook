
public class DBHandler {
	
	// properties
	
	private DBConnection 	dBConnector;
	private DBTable			table;
	private DBAdminTable	adminTable;
	
	// Constructor
	
	public DBHandler( DBConnection  dBConnector, DBTable table, DBAdminTable adminTable ){
		this.dBConnector = dBConnector;
		this.table = table;
		this.adminTable = adminTable;
		
	}
	
	// Methods
	
	public void addRecipe( Recipe recipe) throws Exception{
		
		
	}
	
	public void deleteRecipe( Recipe recipe) throws Exception{
		
		
	}
	

}
