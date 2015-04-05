/*
 * Adam Morris
 * 010858274
 * Project3
 */

import java.io.*;
import java.util.*;

public class RecipeProgram {

   private static final int LOAD_RECIPE_FILE = 1;
   private static final int SAVE_RECIPE_FILE = 2;
   private static final int SHOW_RECIPE_NAMES = 3;
   private static final int SHOW_RECIPE_DETAILS = 4;
   private static final int REMOVE_RECIPE = 5;
   private static final int FIND_INGREDIENT = 6;
   private static final int SORT_RECIPES = 7;
   private static final int MENU_QUIT = 8;
   private static final int ASCENDING_SORT = 1;
   private static final int DESCENDING_SORT = 2;

   public static void main(String[] args) throws IOException {
      RecipeBook recipeBook = new RecipeBook();
      Scanner in = new Scanner(System.in);
      int menuChoice = -1;

      do {
         menuChoice = getMenuSelect(in);
         switch (menuChoice) {
            case LOAD_RECIPE_FILE:
               
               System.out.println("Please enter the name of a recipe"
                + " database file:");
               String fileName = in.nextLine();

               try { //try catch blocks
                  RecipeLoader rL1 = new RecipeLoader(fileName);

                  int count = 0;
                  Recipe fromFile = rL1.readNextRecipe();
                  while (fromFile != null) {
                     recipeBook.add(fromFile);
                     fromFile = rL1.readNextRecipe();
                     count++;
                  }

                  String recipe = count == 1 ? " recipe!" : " recipes!";
                  System.out.println("Loaded " + count
                   + recipe);
               }
               catch (Exception e) {//"e" is an object of type exception
                  System.out.println("Could not open the file " + fileName);
               }
               break;

            case SAVE_RECIPE_FILE:
               
               System.out.println("Please enter the name of the file"
                + " to save to:");
               RecipeWriter rw = new RecipeWriter(in.nextLine());
               int count = 0;

               for (Object r : recipeBook) {
                  rw.writeRecipe(((Recipe) r));
                  count++;
               }
               String sCount = "Saved ";
               sCount += count == 1 ? count + " recipe!" : count + " recipes!";
               System.out.println(sCount);
               break;

            case SHOW_RECIPE_NAMES:
               
               System.out.println("All " + recipeBook.getCount()
                + " recipes:");
               for (int j = 0; j < recipeBook.getCount(); j++) {
                  System.out.println(recipeBook.get(j).getName());
               }
               break;

            case SHOW_RECIPE_DETAILS:
               
               System.out.println("Please enter a recipe name:");
               Recipe m = recipeBook.searchByName(in.nextLine());
               if (m != null) {
                  System.out.println(m);
               }
               else {
                  System.out.println("Could not find a recipe with that name");
               }
               break;

            case REMOVE_RECIPE:
               
               System.out.println("Please enter a recipe name:");
               boolean flag = recipeBook.remove(
                recipeBook.searchByName(in.nextLine()));
               if (flag) {
                  System.out.println("Recipe removed");
               }
               else {
                  System.out.println("Could not find a recipe with that name");
               }
               break;

            case FIND_INGREDIENT:
               
               System.out.println("Please enter an ingredient name:");
               List n = recipeBook.searchByIngredient(in.nextLine());
               String grammar = n.getCount() != 1
                ? "These recipes use that ingredient:\n"
                : "This recipe uses that ingredient:";

               if (n.getCount() != 0) {
                  System.out.println(grammar);

                  for (Object o : n) {
                     System.out.println(((Recipe) o).getName());
                  }

               }
               else {
                  System.out.println("No recipes use that ingredient");
               }
               break;
            case SORT_RECIPES:
               
               int sortField = 0;
               int orderChoice = 0;
               boolean order = false;
               String sort = "";
               String ord = "";
               do {

                  System.out.println("Please choose a sort field - name (1),"
                   + " servings (2), or time (3):");
                  sortField = in.nextInt();

               } while (sortField != RecipeBook.SORT_RECIPE_NAME && sortField
                != RecipeBook.SORT_NUMBER_SERVINGS && sortField
                != RecipeBook.SORT_TOTAL_TIME);

               do {

                  System.out.println("Ascending (1) or descending (2):");
                  orderChoice = in.nextInt();

                  if (orderChoice == 1) {
                     order = true;
                  }
                  else if (orderChoice == 2) {
                     order = false;
                  }

               } while (orderChoice != ASCENDING_SORT && orderChoice
                != DESCENDING_SORT);

               recipeBook.sortBook(sortField, order);

               switch (sortField) {

                  case RecipeBook.SORT_RECIPE_NAME:
                     sort = "name";
                     break;

                  case RecipeBook.SORT_NUMBER_SERVINGS:
                     sort = "servings";
                     break;

                  case RecipeBook.SORT_TOTAL_TIME:
                     sort = "time";
                     break;
               }

               ord = order ? "ascending" : "descending";

               System.out.println("Sorted recipes by " + sort
                + " in " + ord + " order");

               break;
         }

      } while (menuChoice != MENU_QUIT);
   }

   private static int getMenuSelect(Scanner in) {
      int menuChoice = -1;
      do {

         System.out.println(
          "Main Menu:\n"
          + "1. Load recipe file\n"
          + "2. Save recipe file\n"
          + "3. Show all recipe names\n"
          + "4. Show recipe details\n"
          + "5. Remove a recipe\n"
          + "6. Find ingredient\n"
          + "7. Sort recipes\n"
          + "8. Exit\n"
          + "Please enter a selection:");

         menuChoice = in.nextInt();
      } while (menuChoice < 1 || menuChoice > MENU_QUIT);

      in.nextLine();
      return menuChoice;
   }
}//end RecipeProgram
