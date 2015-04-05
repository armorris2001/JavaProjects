/*
 * Adam Morris
 * 010858274
 * Project3
 */

import java.io.*;

public class RecipeWriter {

   private PrintStream mWriter;

   public RecipeWriter(String fileName) throws IOException {
      mWriter = new PrintStream(fileName, "UTF-8");
   }

   public void writeRecipe(Recipe r) {

      String ingredients = "";
      String[] ingredientListToWrite = r.getIngredients();

      for (int i = 0; i < r.getIngredientCount(); i++) {
         if (i != r.getIngredientCount() - 1) {
            ingredients += ingredientListToWrite[i] + "@";
         }
         else {
            ingredients += ingredientListToWrite[i];
         }
      }

      String steps = "";
      String[] stepListToWrite = r.getSteps();

      for (int i = 0; i < r.getStepCount(); i++) {
         if (i != r.getStepCount() - 1) {
            steps += stepListToWrite[i] + "@";
         }
         else {
            steps += stepListToWrite[i];
         }
      }

      mWriter.println(r.getName() + "|" + r.getDescription() + "|"
       + r.getServings() + "|" + r.getPrepTime() + "|" + r.getCookTime() + "|"
       + ingredients + "|" + steps);

   }

   public void close() {
      mWriter.close();
   }
}//end RecipeWriter

