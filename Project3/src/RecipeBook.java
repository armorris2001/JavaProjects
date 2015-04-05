/*
 * Adam Morris
 * 010858274
 * Project3
 */

import java.util.*;

public class RecipeBook implements Iterable {

   public static final int SORT_RECIPE_NAME = 1;
   public static final int SORT_NUMBER_SERVINGS = 2;
   public static final int SORT_TOTAL_TIME = 3;
   public static final int REVERSE_ORDER = -1;
   public static final int INVALID_COMPARE = 2;//non comparator return value

   public Iterator iterator() {
      return mList.iterator();
   }
   private List mList;

   public RecipeBook() {
      mList = new ArrayList();
   }

   public int getCount() {
      return mList.getCount();
   }

   public void add(Recipe itemToAdd) {
      mList.addLast(itemToAdd);
   }

   public Recipe get(int index) {
      return (Recipe) mList.get(index);
   }

   public boolean remove(Recipe itemToRemove) {
      return mList.remove(itemToRemove);
   }

   public Recipe searchByName(String searchName) {

      for (Object g : mList) {

         Recipe r = (Recipe) g;
         if (r.getName().equals(searchName)) {
            return r;
         }

      }
      return null;
   }

   public List searchByIngredient(String searchName) {
      List IngredList = new ArrayList();

      for (Object g : mList) {

         if (((Recipe) g).hasIngredient(searchName)) {
            IngredList.addLast((Recipe) g);
         }

      }//end enhanced for

      return IngredList;

   }

   private class RecipeBookComparator implements Comparator {

      private int mSortField;
      private boolean mOrder;

      public RecipeBookComparator(int sortField, boolean order) {
         mSortField = sortField;
         mOrder = order;
      }

      public int compare(Object o1, Object o2) {

         Recipe r1 = (Recipe) o1, r2 = (Recipe) o2;
         if (mSortField == SORT_RECIPE_NAME) {

            if (mOrder) {
               return r1.getName().compareTo(r2.getName());
            }
            else {
               return r1.getName().compareTo(r2.getName()) * REVERSE_ORDER;
            }

         }
         else if (mSortField == SORT_NUMBER_SERVINGS) {

            if (r1.getServings() < r2.getServings()) {
               return mOrder ? -1 : 1;
            }
            else if (r1.getServings() > r2.getServings()) {
               return mOrder ? 1 : -1;
            }
            else {
               return 0;
            }

         }//end Sort Number of Servings
         else if (mSortField == SORT_TOTAL_TIME) {

            if (r1.getCookTime() + r1.getPrepTime()
             < r2.getCookTime() + r2.getPrepTime()) {
               return mOrder ? -1 : 1;
            }
            else if (r1.getCookTime() + r1.getPrepTime()
             > r2.getCookTime() + r2.getPrepTime()) {
               return mOrder ? 1 : -1;
            }
            else {
               return 0;
            }

         }
         return INVALID_COMPARE;
      }
   }

   public void sortBook(int sortField, boolean order) {
      RecipeBookComparator recipeBookComp = new RecipeBookComparator(sortField, order);
      mList.sort(recipeBookComp);
      //public static void sort(Comparator comp){

   }
}//end RecipeBook Class

