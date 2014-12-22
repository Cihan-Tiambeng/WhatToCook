import java.util.ArrayList;
import java.util.Arrays;  
import java.util.List;  

public class AdminHandler {

	// properties
	
	private String[] tagNames = { "id", "name", "cal", "likes", "cookingtime", "ingredients"};
	private DBHandler 	dBHandler;
	private Admin		admin;
	
	// Constructor
	
	public AdminHandler( DBHandler dBHandler, Admin admin){
		this.dBHandler = dBHandler;
		this.admin = admin;
		
	}
	
	// Methods
	
	public void addRecipe( Recipe recipe) throws Exception{
		ArrayList<String> tags = new ArrayList<String> (Arrays.asList(tagNames));
		ArrayList<String> values = new ArrayList<String>();
		
		values.add( Recipe.getId() + "");
		values.add( Recipe.getName());
		values.add( Recipe.getCalori() + "");
		values.add( Recipe.getNumOfLikes);
		values.add( Recipe.getCookTime);
		
	}
	
	public void deleteRecipe( Recipe recipe) throws Exception{
		
		
	}
	
	
}


