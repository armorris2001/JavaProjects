/*
 * Adam Morris
 * 010858274
 * Lab 4 RecipeBook Class
 */

public class RecipeBook {

   private class Node {

      private Recipe mData;
      private Node mNext;
      private Node mPrev;

      //Node Constructor
      public Node(Recipe data, Node next, Node prev) {
         mData = data;
         mNext = next;
         mPrev = prev;
      }//end Node Constructor
   }//end Node Class
   private Node mHead;
   private Node mTail;
   private int mCount;

   public int getCount() {
      return this.mCount;
   }

   public void add(Recipe itemToAdd) {
      // Create a new Node to store the item.
      Node newNode = new Node(itemToAdd, null, null);
      // If this is the first item to be added, mHead will be null. Set the
      // new node as our head.
      if (mHead == null) {
         mHead = mTail = newNode;
      }
      else {
         // Otherwise, put the new Node at the end of the list and link it in.
         mTail.mNext = newNode;
         newNode.mPrev = mTail;
         mTail = newNode;
      }
      mCount++;
   }

   public Recipe get(int index) {
      // Retrieve the Song object at the given index.
      Node n = mHead;
      for (int i = 0; i < index; i++) {
         if (n == null) {
            return null;
         }
         n = n.mNext;
      }
      return n != null ? n.mData : null;
   }

   public boolean remove(Recipe itemToRemove) {
      if (itemToRemove == null) {
         return false;
      }
      else if (itemToRemove == mHead.mData) {
         mHead = mHead.mNext;
         mCount--;
         return true;
      }
      else {
         Node n = mHead;
         while (n != null) {
            if (n.mData == itemToRemove) {
               Node previous = n.mPrev;
               Node next = n.mNext;
               previous.mNext = next;
               if (next != null) {
                  next.mPrev = previous;
               }
               mCount--;
               return true;
            }
            n = n.mNext;
         }
      }
      return false;
   }

   public Recipe searchByName(String searchName) {
      Node n = mHead;
      while (n != null) {
         if (n.mData.getName().matches(searchName)) {
            return n.mData;
         }
         else {
            if (n.mNext != null) {
               n = n.mNext;
            }
            else {
               break;
            }
         }
      }//end while
      return null;//temporary CHECK for ERROR
   }

   public Recipe searchByIngredient(String searchName) {
      Node n = mHead;
      while (n != null) {
         String[] ingredients = n.mData.getIngredients();
         for (int i = 0; i < n.mData.getIngredientCount(); i++) {
            if (ingredients[i].contains(searchName)) {
               return n.mData;
            }
         }
         if (n.mNext != null) {
            n = n.mNext;
         }
         else {
            break;
         }
      }//end while
      return null;//temporary CHECK for ERROR
   }
}//end RecipeBook Class

