import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class RecipeCollection {
    ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
    public RecipeCollection(ArrayList<Recipe> recipeL){
        recipeList = recipeL;
    }
    public RecipeCollection(){
    }
    public void addRecipe(Recipe r){
        recipeList.add(r);
    }
    public void deleteRecipe(Recipe r){
        recipeList.remove(r);        
    }
    public static Comparator<Recipe> cookTimeComparator = new Comparator<Recipe>() {

	public int compare(Recipe r1, Recipe r2) {
	   int cookTime1 = r1.getCookTime();
	   int cookTime2 = r2.getCookTime();

	   //ascending order
	   return cookTime1-cookTime2;
        }
    };
    public static Comparator<Recipe> numOfLikesComparator = new Comparator<Recipe>() {

	public int compare(Recipe r1, Recipe r2) {
	   int numOfLikes1 = r1.getNumOfLikes();
	   int numOfLikes2 = r2.getNumOfLikes();

	   //ascending order
	   return numOfLikes2-numOfLikes1;
        }
    };
    public static Comparator<Recipe> caloriComparator = new Comparator<Recipe>() {

	public int compare(Recipe r1, Recipe r2) {
	   int calori1 = r1.getCalori();
	   int calori2 = r2.getCalori();

	   //ascending order
	   return calori1-calori2;
        }
    };
    public void sortByCookTime(){
        Collections.sort(recipeList, cookTimeComparator);
        System.out.println("Your collection has been sorted by cook time.");
    }
    public void sortByLikes(){
        Collections.sort(recipeList, numOfLikesComparator);
        System.out.println("Your collection has been sorted by number of likes.");
    }
    public void sortByCalori(){
        Collections.sort(recipeList, caloriComparator);
        System.out.println("Your collection has been sorted by calori.");
    }
    public void print(){
        System.out.println("---List of Recipes---");
        for(int i = 0; i < recipeList.size();i++){
            System.out.println(recipeList.get(i).toString());
        }
    }
    public String searchByIngredient(String in){
        String out = "";
        Boolean exist = false;
        for(int i=0 ; i<recipeList.size() ; i++){
            if(recipeList.get(i).searchIngredient(in)){
                exist = true;
                out += (recipeList.get(i).toString());
                out += "\n";
            }
        }
        if(exist == false){
            out = "This ingredient does not exist in any recipe.";
        }
        return out;
    }
    public String searchByName(String in){
        String out = "";
        Boolean exist = false;
        for(int i=0 ; i<recipeList.size() ; i++){
            if(recipeList.get(i).getName() == in){
                exist = true;
                out += (recipeList.get(i).toString());
                out += "\n";
            }
        }
        if(exist == false){
            out = "This recipe does not exist.";
        }
        return out;
    }
    public String searchByRestriction(String in){
        String out = "";
        Boolean exist = false;
        for(int i=0 ; i<recipeList.size() ; i++){
            if(!recipeList.get(i).searchIngredient(in)){
                exist = true;
                out += (recipeList.get(i).toString());
                out += "\n";
            }
        }
        if(exist == false){
            out = "This ingredient exists in all recipes.";
        }
        return out;
    }
    public String supriseMe(){
        String out = "";
        if(recipeList.isEmpty()){
            out = "This collection does not exist any recipe.";
            return out;
        }
        else{
            Random generator = new Random();
            int randIndex = generator.nextInt(recipeList.size());
            out = "Here is your surprise food: \n"+ recipeList.get(randIndex).toString();
            return out;
        }
    }
}
