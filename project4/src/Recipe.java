/*
 * Adam Morris
 * 010858274
 * Project3
 */

public class Recipe {

   private String mName, mDescription;
   private int mServings, mPrepTime, mCookTime;
   private String[] mIngredients, mSteps;

//constructor
   public Recipe(String name, String description, int servings, int prepTime,
    int cookTime, String[] ingredients, String[] steps) {
      mName = name;
      mDescription = description;
      mServings = servings;
      mPrepTime = prepTime;
      mCookTime = cookTime;
      mIngredients = ingredients;
      mSteps = steps;
   }

   public int getStepCount() {
      return mSteps.length;
   }

   public int getIngredientCount() {
      return mIngredients.length;
   }

   public int getTotalRecipeTime() {
      return mPrepTime + mCookTime;
   }

   public String getName() {
      return mName;
   }

   public void setName(String name) {
      this.mName = name;
   }

   public int getServings() {
      return mServings;
   }

   public void setServings(int servings) {
      if (servings > 0) {
         this.mServings = servings;
      }
   }

   public String getDescription() {
      return mDescription;
   }

   public void setDescription(String description) {
      this.mDescription = description;
   }

   public int getPrepTime() {
      return mPrepTime;
   }

   public void setPrepTime(int prepTime) {
      if (prepTime >= 0) {
         this.mPrepTime = prepTime;
      }
   }

   public int getCookTime() {
      return mCookTime;
   }

   public void setCookTime(int cookTime) {
      if (cookTime >= 0) {
         this.mCookTime = cookTime;
      }
   }

   public String[] getIngredients() {
      return mIngredients;
   }

   public void setIngredients(String[] ingredients) {
      this.mIngredients = ingredients;
   }

   public String[] getSteps() {
      return mSteps;
   }

   public void setSteps(String[] steps) {
      this.mSteps = steps;
   }

   public boolean hasIngredient(String target) {
      for (int i = 0; i < mIngredients.length; i++) {
         if (mIngredients[i].contains(target)) {
            return true;
         }
      }
      return false;
   }//end hasIngredient

   @Override
   public String toString() {
      String ingredientList = "";
      String stepList = "";
      String servings = "";
      String prepTime = "";
      String cookTime = "";

      servings = mServings != 1 ? " servings\n" : " serving\n";
      prepTime = mPrepTime != 1 ? " minutes prep, " : " minute prep, ";
      cookTime = mCookTime != 1 ? " minutes cooking\n\nIngredients:\n"
       : " minute cooking\n\nIngredients:\n";

      for (int i = 0; i < mIngredients.length; i++) {
         ingredientList += mIngredients[i] + "\n";
      }

      for (int i = 0; i < mSteps.length; i++) {
         stepList += mSteps[i] + "\n";
      }

      return "\nRecipe:\n" + mName + "\n" + mDescription + "\n" + mServings
       + servings + mPrepTime + prepTime + mCookTime + cookTime + ingredientList
       + "\nSteps:\n" + stepList;

   }//end toString
}//end Recipe

/*
run:
Neal's Guacamole
Simple guacamole without tomatoes. Adapted from Alton Brown.
20 minutes prep, 0 minutes cooking

Ingredients:
3 Hass avocados, halved, seeded and peeled
1 lime, juiced
1/2 teaspon kosher salt
1/2 teaspoon ground cumin
1/2 teaspoon ground red pepper
1/2 teaspoon ground black pepper
1/2 medium onion, diced
1 clove garlic, minced
1 tablespoon cilantro, chopped

Steps:
Place scooped avocado pulp in large bowl and coat with lime juice.
Add salt, cumin, and pepper; mash with a potato masher.
Fold in onion, garlic, and cilantro.
Let sit at room temperature for 1 hour, then serve.

Neal's Guacamole has 9 ingredients
Cereal with milk
Best breakfast ever.
1 minutes prep, 1 minutes cooking

Ingredients:
Your favorite cereal
1 cup 2% milk

Steps:
Pour cereal into bowl.
Pour milk over cereal.
Enjoy.

2 minutes total
BUILD SUCCESSFUL (total time: 0 seconds)

 */
