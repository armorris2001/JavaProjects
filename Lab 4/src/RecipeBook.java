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

   public void remove(Recipe itemToRemove) {
      mCount--;
      Node n = mHead;
      while (n != null) {
         if (n.mData == itemToRemove) {
            // we found the node holding the item.
            // what to do now?
            Node previous = n.mPrev;
            Node next = n.mNext;
            previous.mNext = next;
            next.mPrev = previous;
            // What does the list look like now?
            break;
         }
         n = n.mNext;
      }//end while
   }//end remove
}//end RecipeBook Class
