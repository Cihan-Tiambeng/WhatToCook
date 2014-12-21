package proje;

public class Recipe {
    int num;
    String name;
    int cal;
    Ingredient[] ingredientList;
    int numOfLikes;
    int reqCookTime;
    string tarif;
    public Recipe(int id, String nam, int calori,Ingredient[] ingredients, int likes, int cookTime, String instructions){
        num = id;
        name  = nam;
        cal = calori;
        ingredientList = ingredients;
        numOfLikes = likes;
        reqCookTime = cookTime;
        tarif = instructions;
        System.out.println("Recipe " + nam + " has been created.");
    }
    public int getId(){
        return num;
    }
    public String getName(){
        return name;
    }
    public int getCalori(){
        return cal;
    }
    public int getNumOfLikes(){
        return numOfLikes;
    }
    public int getCookTime(){
        return reqCookTime;
    }
    public String getInstructions(){
        return tarif;
    }
    public void setId(int newId){
        num = newId;
    }
    public void setName(String newName){
        name = newName;
    }
    public void setCalori(int newCal){
        cal = newCal;
    }
    public void setNumOfLikes(int newNumOfLikes){
        numOfLikes = newNumOfLikes;
    }
    public void setCookTime(int newCookTime){
        reqCookTime = newCookTime;
    }
    public void setInstructions(String newIns){
        tarif = newIns;
    }
    public String toString(){
        String out = "Recipe id: " + num + "\nRecipe name: " + name + "\nCalori: " + cal + "\nNumber of likes: " + numOfLikes + "\nCook time: " + reqCookTime "\nInstructions: " + tarif + "\nIngredients are as follows: \n";
        int n=0;
        for(int i = 0; i < ingredientList.length;i++){
            n= i+1;
            out += "\t" + n + ". " + ingredientList[i].getName() + "\n";
        }
        return out;
    }
    public boolean searchIngredient(String look){
        boolean out = false;
        for(int i= 0;i<ingredientList.length;i++){
            if(ingredientList[i].getName() == look){
                out = true;
            }
        }
        return out;
    }
}
