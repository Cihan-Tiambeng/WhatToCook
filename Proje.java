public class Proje {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ingredient sucuk = new Ingredient("Sucuk");
        Ingredient yumurta = new Ingredient("Yumurta");
        Ingredient yag = new Ingredient("Yag");
        Ingredient tuz = new Ingredient("Tuz");
        Ingredient biber = new Ingredient("Biber");
        Ingredient kasar = new Ingredient("Kasar");
        Ingredient domates = new Ingredient("Domates");
        Ingredient un = new Ingredient("Un");
        Ingredient seker = new Ingredient("Seker");
        
        Ingredient[] yemek1 = new Ingredient[5];
        yemek1[0] = sucuk;
        yemek1[1] = yumurta;
        yemek1[2] = yag;
        yemek1[3] = tuz;
        yemek1[4] = kasar;
        Ingredient[] yemek2 = new Ingredient[5];
        yemek2[0] = yumurta;
        yemek2[1] = biber;
        yemek2[2] = yag;
        yemek2[3] = tuz;
        yemek2[4] = domates;
        Ingredient[] yemek3 = new Ingredient[4];
        yemek3[0] = un;
        yemek3[1] = yumurta;
        yemek3[2] = yag;
        yemek3[3] = seker;
        
        Recipe recipe1 = new Recipe("Sucuklu Yumurta", 100, yemek1, 420, 440);
        Recipe recipe2 = new Recipe("Menemen", 200, yemek2, 220, 840);
        Recipe recipe3 = new Recipe("Kek", 300, yemek3, 520, 140);
        RecipeCollection collection = new RecipeCollection();
        collection.addRecipe(recipe1);
        collection.addRecipe(recipe2);
        collection.addRecipe(recipe3);
        Scanner scan = new Scanner(System.in);
        /*System.out.println("What do you want to do?");
        System.out.println("1. Search recipe");
        System.out.println("2. Search by ingredient");
        System.out.println("2. Search by restriction");*/
        /*collection.print();
        collection.sortByCalori();
        collection.print();
        collection.sortByCookTime();
        collection.print();
        collection.sortByLikes();
        collection.print();*/
        String in="Sucuk";
        //System.out.println(collection.searchByIngredient(in));
        System.out.println(collection.searchByName(in));
        System.out.println(collection.searchByRestriction(in));
        System.out.println(collection.supriseMe());
    }
}
