import java.util.ArrayList;
import java.util.Date;

/* Hub.java
 * 
 * 
 * description
 */

public class Hub {

	//PROPERTIES
	public DBTable connectionTable; //Attention
	public DBConnection connection; //Attention
	
	private DBHandler	dBHandler;
	private GUI			gui; 
	private RecipeCollection	recipeCollection;
	private Admin	admin;
	private ItemContainer found, returned, all;
	
	public static final int ALL_ITEMS = 0;
	public static final int FOUND_ITEMS = 1;
	public static final int RETURNED_ITEMS = 2;
	
	//CONSTRUCTORS
	public Hub() throws Exception {
		
		dBHandler = new DBHandler();
		
		connection = new DBConnection();
		connectionTable = new DBTable( connection);
		gui = new GUI( );
		gui.addHub(this);
		
		admin = null;
		
		dBHandler.getRandom();
		
	}
	
	//METHODS
	public boolean isConnected() {
		
		if( dBHandler.getConnStatus())
			return true;
		return false;
	}
	
	public void addRecipe(Recipe recipe) throws Exception{
		dBHandler.addRecipe(recipe) ;
	}
	
	
	public Recipe getRandom() throws Exception{
		
		return dBHandler.getRandom();
	}
	
	//Admin and log on methods
	public boolean isFirstTime() {
		
		return false;
	}
	
	public boolean logIn( String username, String password) {
		
		return false;
	}
	
	public void addNewAdmin( String username, String password) {
		
		
	}
	
	public Admin getAdmin() {
		
		return null;
	}
	
	public void changePassword( String username, String oldPassword, String newPassword) {
		
		
	}
	
//	Item methods
	public ItemContainer getItems( int condition) throws Exception {
		
		ItemContainer returnedContainer = new ItemContainer();
		RowContainer  cont = new RowContainer();
		
		if( condition == ALL_ITEMS) {
			cont = connectionTable.readTable( "", "*" , "ItemTable" );
		}
		
		else if( condition == RETURNED_ITEMS) {
			cont = connectionTable.readTable( "WHERE status='Returned'", "*" , "ItemTable" );
		}
		
		else{
			
			cont = connectionTable.readTable( "WHERE status='Found'", "*" , "ItemTable" );
		}
		
		for( int i = 0; i < cont.size(); i++) {
			
			returnedContainer.addItem( new Item( connection,cont.getRow( i).getValues( cont.getRow(i).getTags())));
		}
		
		return returnedContainer;
	}
	
	public ItemContainer search( String keywords) {
		
		return null;
	}
	
	public Item getItem( String id) {
		
		//Returns the item according to its id.
		return null;
	}
	
	public void addNewItem( String type, String brand, String model, String color, String description, String lostLocation, String keptLocation, String imagePath) {
		
		
	}
	
	public ItemContainer filter( ArrayList<String> tags, ArrayList<String> values) {
		
		return null;
	}
	
	public void returnItem( Item item, String reclaimerInformation) throws Exception {
		
		item.returnItem( reclaimerInformation);
	}
	
	//Log methods
	public ArrayList<Log> getLogs() {
		
		return null;
	}
	
	public ArrayList<Log> getLogs( Date date) {
		
		//Returns all logs before the date in the parameters
		return null;
	}
	
	public ArrayList<Log> getLogs( Date dateAfter, Date dateBefore) {
		
		//Returns all logs between the dates given in the parameters.
		return null;
	}
	
	//Claims
	/*public ArrayList<Claim> getClaims() {
		
		return null;
	}*/


public static void main( String[] args) throws Exception {
	
	//VARIABLES
	Hub a = new Hub();
	a.isConnected();
}

}

