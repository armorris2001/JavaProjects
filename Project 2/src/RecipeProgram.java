/*
 * Adam Morris
 * 010858274
 * Project 2
 * RecipeProgram Class
 */

import java.io.*;
import java.util.*;

public class RecipeProgram {

   private static final int MENU_QUIT = 6;

   public static void main(String[] args) throws IOException {
      RecipeBook RecipeBook = new RecipeBook();
      Scanner in = new Scanner(System.in);

      int menuChoice = -1;


      do {
         menuChoice = getMenuSelect(in);
         switch (menuChoice) {
            case 1:
               //Load Recipes
               System.out.println("Please enter the name of a recipe"
                + " database file:");
               String fileName = in.nextLine();

               try { //try catch blocks
                  RecipeLoader rL1 = new RecipeLoader(fileName);
                  
                  int count = 0;
                  Recipe fromFile = rL1.readNextRecipe();
                  while(fromFile != null){
                     RecipeBook.add(fromFile);
                     fromFile = rL1.readNextRecipe();
                     count++;
                  }
                  
                  System.out.println("Loaded " + count
                   + " recipes!");
               }
               catch (Exception e) {//"e" is an object of type exception
                  System.out.println("Could not open the file " + fileName);
               }
               break;

            case 2:
               //Show All Recipe Names
               System.out.println("\n\nAll " + RecipeBook.getCount()
                + " recipes:");
               for (int j = 0; j < RecipeBook.getCount(); j++) {
                  System.out.println(RecipeBook.get(j).getName());
               }
               break;

            case 3:
               //Show Recipe Details
               System.out.println("Please enter a recipe name:");
               Recipe m = RecipeBook.searchByName(in.nextLine());
               if (m != null) {
                  System.out.println(m);
               }
               else {
                  System.out.println("Could not find a recipe with that name");
               }
               break;

            case 4:
               //Delete a Recipe
               System.out.println("Please enter a recipe name:");
               boolean flag = RecipeBook.remove(
                RecipeBook.searchByName(in.nextLine()));
               if (flag) {
                  System.out.println("Recipe removed");
               }
               else {
                  System.out.println("Could not find a recipe with that name");
               }
               break;

            case 5:
               //Find ingredient
               System.out.println("Please enter an ingredient name:");
               Recipe n = RecipeBook.searchByIngredient(in.nextLine());
               if (n != null) {
                  System.out.println("This recipe uses that ingredient:\n"
                   + n.getName());
               }
               else {
                  System.out.println("No recipes use that ingredient");
               }
               break;
         }

      } while (menuChoice != MENU_QUIT);
   }

   private static int getMenuSelect(Scanner in) {
      int menuChoice = -1;
      do {

         System.out.println("Main Menu:\n"
          + "1. Load recipe file\n"
          + "2. Show all recipe names\n"
          + "3. Show recipe details\n"
          + "4. Remove a recipe\n"
          + "5. Find ingredient\n"
          + "6. Exit");
         System.out.println("Please enter a selection:");
         menuChoice = in.nextInt();
      } while (menuChoice < 1 || menuChoice > MENU_QUIT);
      in.nextLine();
      return menuChoice;
   }
}//end RecipeProgram

