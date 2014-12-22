import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Arrays;  
import java.util.Iterator;
import java.util.List;  

public class DBHandler {
	
	// properties
	
//	private String[] tagNames = { "id", "name", "cal", "likes", "cookingtime", "ingredients"};
	private DBConnection 	dBConnector;
	private DBTable			table;
//	private DBAdminTable	adminTable;
	ArrayList<String> tags;
	
	// Constructor
	
	public DBHandler() throws Exception{
		
		String[] tagNames = { "id", "name", "cal", "likes", "cookingtime", "ingredients"};
		
		this.dBConnector = new DBConnection();
		this.table = new DBTable( dBConnector);
	//	this.adminTable = adminTable;
		ArrayList<String> tags = new ArrayList<String> (Arrays.asList(tagNames));
		
	}
	
	// Methods
	
	// returns if the client is connected to the database or not
	public boolean getConnStatus(){
		return dBConnector.getConnStatus();
	}
	
	// not so random method, just gets the row where id = 1, the first row
	public Recipe getRandom() throws Exception{
		
		Row row = table.readRow(  "WHERE ID = 1", "*" , "recipe" );
		return rowToRecipe(row);
		
	}
	
	// adds recipe to the DBTable, MySQL queries only take strings
	public void addRecipe( Recipe recipe) throws Exception{
		
		
		ArrayList<String> values = recipeToArrayList(recipe); // converts recipe properties to an array list
		
		table.insertRow( toStringDB( tags, values) , "recipe"); // adds to the table
		
	}
	
	public void deleteRecipe( Recipe recipe) throws Exception{
		table.deleteRow(recipe.getId(), "recipe"); 
	}
	
	public void addLike( Recipe recipe) throws Exception {
		
		ArrayList<String> values = recipeToArrayList(recipe);
		
		
		table.editRow(setString(tags, values),"ID=" + recipe.getId(), "recipe");
	}
	
	// converts string arrays to a string so the MySQL database can process it as a querry.
	 public String toStringDB( ArrayList<String> tags, ArrayList<String> values) {
		 
		 	
			String rep = "";

			for (Iterator<String> iterator = values.iterator(); iterator.hasNext();) {
			        rep += iterator.next() + (iterator.hasNext() ? "," : "");
			}
			return rep;
		}
	    
	 
	 // creates a set string. used for set metods in MySQl for editing a row
	 public String setString( ArrayList<String> tags, ArrayList<String> values){
	    	
	    	ArrayList<String> setStringUnit = new ArrayList<String>();
			for (int i = 0; i < values.size(); i++) {
				setStringUnit.add(tags.get(i) + "='" + values.get(i) + "'");
			}

			String setString = "";
			for (Iterator<String> iterator = setStringUnit.iterator(); iterator.hasNext();) {
			        setString += iterator.next() + (iterator.hasNext() ? "," : "");
			}

	    	return setString;
	    }
	 
	 // converts the recipe property to an ArrayList so that it can be processed into Strings for calling SQL functions
	 public ArrayList<String> recipeToArrayList( Recipe recipe){
		 ArrayList<String> values = new ArrayList<String>();
			
		values.add( recipe.getId() + "");
		values.add( recipe.getName());
		values.add( recipe.getCalori() + "");
		values.add( recipe.getNumOfLikes() + "");
		values.add( recipe.getCookTime()  + "");
		values.add( recipe.getInstructions() );
		 
		return values;
	 }
	 
	 public Recipe rowToRecipe( Row row){
		 
		 ArrayList<String> values = row.getValues();
		 Recipe recipe;
		 
		 recipe = new Recipe( Integer.parseInt(values.get(0) ) , values.get(1), Integer.parseInt(values.get(2) ),
				 Integer.parseInt(values.get(3)),  Integer.parseInt(values.get(4)),  values.get(5));
		 
		 if ( recipe == null){
			 System.out.println( "null recipe returned");
		 }
		 else System.out.println( "healthy" );
		 System.out.println( recipe.getName());
		 
		 
		 return recipe;
	 }
	
	
}
