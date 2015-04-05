
import java.util.*;
import java.io.*;

public class RecipeLoader {

   private Scanner mFileScanner;

   public RecipeLoader(String fileName) throws IOException {
      mFileScanner = new Scanner(new FileReader(fileName));
      mFileScanner.useDelimiter("\n|\\|");
   }

   public Recipe readNextRecipe() {
      // format:
      // name|descr|serves|prep|cook|ingredient1@ingredient2@...|step1@step2@...
      if (mFileScanner.hasNext()) {
         String name = mFileScanner.next();
         String descr = mFileScanner.next();
         int serves = mFileScanner.nextInt();
         int prep = mFileScanner.nextInt();
         int cook = mFileScanner.nextInt();

         String[] ingredients = mFileScanner.next().split("@");
         String[] steps = mFileScanner.next().split("@");
         return new Recipe(name, descr, serves, prep, cook, ingredients, steps);
      }
      return null;
   }

   public static void main(String[] args) throws IOException {
      RecipeLoader loader = new RecipeLoader("test.txt");
      System.out.println(loader.readNextRecipe());
      System.out.println(loader.readNextRecipe());
   }
}
