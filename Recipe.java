public class Recipe {
    String name;
    int cal;
    Ingredient[] ingredientList;
    int numOfLikes;
    int reqCookTime;
    public Recipe(String nam, int calori,Ingredient[] ingredients, int likes, int cookTime){
        name  = nam;
        cal = calori;
        ingredientList = ingredients;
        numOfLikes = likes;
        reqCookTime = cookTime;
        System.out.println("Recipe " + nam + " has been created.");
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
    public String toString(){
        String out = "Recipe name: " + name + "\nCalori: " + cal + "\nNumber of likes: " + numOfLikes + "\nCook time: " + reqCookTime + "\nIngredients are as follows: \n";
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
