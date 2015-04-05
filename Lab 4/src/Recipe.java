/*
 * Adam Morris
 * 0108585274
 * Lab 4 Recipe Class
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
   }//end Recipe Constructor

   public int getStepCount() {
      return mSteps.length;
   }

   public int getIngredientCount() {
      return mIngredients.length;
   }

   public int getTotalRecipeTime() {
      return mPrepTime + mCookTime;
   }

   public String toString() {
      String ingredientList = "";
      String stepList = "";

      for (int i = 0; i < mIngredients.length; i++) {
         ingredientList += mIngredients[i] + "\n";
      }

      for (int i = 0; i < mSteps.length; i++) {
         stepList += mSteps[i] + "\n";
      }

      return mName + "\n" + mDescription + "\n" + mPrepTime + " minutes prep, "
       + mCookTime + " minutes cooking\n\nIngredients:\n" + ingredientList
       + "\nSteps:\n" + stepList;
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
