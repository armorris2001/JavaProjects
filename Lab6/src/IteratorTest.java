
public class IteratorTest {

   public static void main(String [] args){
      RecipeBook rBook = new RecipeBook();

      Recipe guac = new Recipe(
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

      Recipe pbAndJ = new Recipe(
       "Peanut Butter and Jelly Sandwich",
       "Always there when you need it.",
       1,
       0,
       0,
       new String[]{
          "Fresh, White Bread",
          "Your favorite Jelly or Jam",
          "A quality Peanut Butter"
       },
       new String[]{
          "Lay open two slices of bread.",
          "Spread peanut butter on one piece",
          "Spread jelly or jam on the other piece",
          "Put the two pieces of bread together",
          "Make sure the spread is on the inside!"
       });

      rBook.add(guac);
      rBook.add(cereal);
      rBook.add(pbAndJ);

      for(Object o : rBook ){

      }

      
   }
}
