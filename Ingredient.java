public class Ingredient {
    String name;
    public Ingredient(String nam){
        name = nam;
        // This constructor has one parameter
        System.out.println("Ingredient " + name + " has been created.");
    }
    public String getName(){
        return name;
    }
    public void setName(String newName){
        name = newName;
    }
}
