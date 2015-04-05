/*
 * Adam Morris
 * 010858274
 * Lab 4 RecipeBook Class
 */
import java.util.*;
public class RecipeBook implements Iterable {
   public Iterator iterator(){
      return mList.iterator();
   }

   private List mList;
   public RecipeBook(){
      mList = new ArrayList();
   }

   public int getCount() {
      return mList.getCount();
   }

   public void add(Recipe itemToAdd) {
      mList.addLast(itemToAdd);

       }

   public Recipe get(int index) {
 
      return (Recipe)mList.get(index);
   }

   public boolean remove(Recipe itemToRemove) {

   return mList.remove(itemToRemove);
   }

   public Recipe searchByName(String searchName) {
 
      for(Object g : mList){
         
        Recipe r = (Recipe)g;
        if(r.getName().equals(searchName))
            return r;
     
      }
      return null;
   }

   public Recipe searchByIngredient(String searchName) {
      for(Object g : mList){

        for(int i = 0; i < ((Recipe)g).getIngredientCount(); i++){
           if( ((Recipe)g).hasIngredient(searchName) )
            return (Recipe)g;
        }

      }
      return null;
   }

}//end RecipeBook Class

