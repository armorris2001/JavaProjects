public class RecipeTester {
   public static void main(String[] args) {
      Recipe guacamole = new Recipe(
       "Neal's Guacamole",
       "Simple guacamole without tomatoes. Adapted from Alton Brown.",
       1,
       20,
       0,
       new String[]{
          "3 Hass avocados, halved, seeded and peeled",
          "1 lime, juiced",
          "1/2 teaspon kosher salt",
          "1/2 teaspoon ground cumin",
          "1/2 teaspoon ground red pepper",
          "1/2 teaspoon ground black pepper",
          "1/2 medium onion, diced",
          "1 clove garlic, minced",
          "1 tablespoon cilantro, chopped"
       },
       new String[]{
          "Place scooped avocado pulp in large bowl and coat with lime juice.",
          "Add salt, cumin, and pepper; mash with a potato masher.",
          "Fold in onion, garlic, and cilantro.",
          "Let sit at room temperature for 1 hour, then serve."
       });
      System.out.println(guacamole);
      System.out.println(guacamole.getName() + " has "
       + guacamole.getIngredientCount() + " ingredients");

      Recipe cereal = new Recipe(
       "Cereal with milk",
       "Best breakfast ever.",
       1,
       1,
       0,
       new String[]{
          "Your favorite cereal",
          "1 cup 2% milk"
       },
       new String[]{
          "Pour cereal into bowl.",
          "Pour milk over cereal.",
          "Enjoy."
       });
      cereal.setCookTime(1);
      cereal.setServings(0);
      cereal.setPrepTime(-1);
      System.out.println(cereal);
      System.out.println(cereal.getTotalRecipeTime() + " minutes total");
   }
}
