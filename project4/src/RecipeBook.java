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
   private boolean mSorted = true;
   private boolean mAscending = false;

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

      if (mList.getCount() == 1) {
         mSorted = true;
      }
      else if (mList.getCount() == 2) {
         mSorted = true;
         String first = ((Recipe) mList.get(0)).getName();
         String last = ((Recipe) mList.get(1)).getName();

         if (first.compareTo(last) == 0) {
            mAscending = true;
         }
         else if (first.compareTo(last) < 0) {
            mAscending = true;
         }
         else if (first.compareTo(last) > 0) {
            mAscending = false;
         }

      }
      else if (mList.getCount() >= 3) {
         if (mSorted) {
            String first = ((Recipe) mList.get(mList.getCount() - 1)).getName();
            String last = ((Recipe) mList.get(mList.getCount() - 2)).getName();
            if (mAscending) {

               if (first.compareTo(last) < 0) {
                  mSorted = false;
               }
            }
            else {
               if (first.compareTo(last) > 0) {
                  mSorted = false;
               }
            }//end else
         }//end if (mSorted)
      }//end else if
   }

   public Recipe get(int index) {
      return (Recipe) mList.get(index);
   }

   public boolean remove(Recipe itemToRemove) {
      return mList.remove(itemToRemove);
   }

   private Recipe binarySearchByNameAscending(String searchName, int begin,
    int end) {
      if (begin > end) {
         return null;
      }
      int index = (begin + end) / 2;
      //BASE CASE 
      if (((Recipe) mList.get(index)).getName().compareTo(searchName) == 0) {
         return (Recipe) mList.get(index);
      }
      //RECURSIVE STEP
      else if (((Recipe) mList.get(index)).getName().compareTo(searchName)
       > 0) {
         end = index - 1;
         return binarySearchByNameAscending(searchName, begin, end);
      }
      else if (((Recipe) mList.get(index)).getName().compareTo(searchName) < 0) {
         begin = index + 1;
         return binarySearchByNameAscending(searchName, begin, end);
      }
      return null;
   }

   private Recipe binarySearchByNameDescending(String searchName, int begin,
    int end) {
      if (begin > end) {
         return null;
      }
      int index = (begin + end) / 2;
      //BASE CASE
      if (((Recipe) mList.get(index)).getName().compareTo(searchName) == 0) {
         return (Recipe) mList.get(index);
      }
      //RECURSIVE STEP
      else if (((Recipe) mList.get(index)).getName().compareTo(searchName) > 0) {
         begin = index + 1;
         return binarySearchByNameDescending(searchName, begin, end);
      }
      else if (((Recipe) mList.get(index)).getName().compareTo(searchName) < 0) {
         end = index - 1;
         return binarySearchByNameDescending(searchName, begin, end);
      }
      return null;
   }

   private Recipe linearSearchByName(String searchName) {

      for (Object g : mList) {
         Recipe r = (Recipe) g;
         if (r.getName().equals(searchName)) {
            return r;
         }
      }
      return null;
   }

   public Recipe searchByName(String searchName) {
      //Switching point for linear or binary search.

      if (mSorted && mAscending) { //ASCENDING
         System.out.println("Performing binary search");
         return binarySearchByNameAscending(searchName, 0, mList.getCount()
          - 1);
      }
      else if (mSorted && !mAscending) { //DESCENDING
         System.out.println("Performing binary search");
         return binarySearchByNameDescending(searchName, 0, mList.getCount()
          - 1);
      }
      else if (!mSorted) {
         System.out.println("Performing linear search");
         return linearSearchByName(searchName);
      }
      else {
         return null;
      }
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

      RecipeBookComparator recipeBookComp = new RecipeBookComparator(sortField,
       order);
      mList.sort(recipeBookComp);
      //public static void sort(Comparator comp){
      mSorted = sortField == SORT_RECIPE_NAME ? true : false;
      mAscending = order ? true : false;
   }
}//end RecipeBook Class

 