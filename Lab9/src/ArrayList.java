/*
 * Adam Morris
 * 010858274
 * Project3
 */

import java.util.*;
import java.util.Comparator;

public class ArrayList implements List {

   private class ArrayListIterator implements Iterator {

      private int mIndex = -1;

      public boolean hasNext() {
         return mIndex + 1 < mCount;
      }

      public Object next() {
         return mArray[++mIndex];
      }

      public void remove() {
         throw new UnsupportedOperationException("Not supported yet.");
      }
   }
   
   private Object[] mArray;
   private static final int DEFAULT_SIZE = 10;
   private int mCount;

   /**
   Initializes a new array list with a default capacity.
    */
   public ArrayList() {
      mArray = new Object[DEFAULT_SIZE];
   }

   /**
   Initializes a new array list with a specified capacity.
   @param initialCapacity the size of the initial storage array.
    */
   public ArrayList(int initialCapacity) {
      mArray = new Object[initialCapacity];
   }

   public Iterator iterator() {
      return new ArrayListIterator();
   }

   /**
   Returns the number of elements in the list.
    */
   public int getCount() {
      return mCount;
   }

   /**
   Removes all elements from the list.
    */
   public void clear() {
      mCount = 0;
   }

   /**
   Adds an item to the end of the list.
    */
   public void addLast(Object item) {
      resizeIfNecessary();
      mArray[mCount++] = item;
   }

   /**
   Inserts an item at the given index. Shifts the element currently at
   the index (and all elements that follow it) to the right, increasing their
   indices by 1.
   @param index the 0-based position where the item should be inserted.
   @param item the new element to insert.
    */
   public void insert(int index, Object item) {
      resizeIfNecessary();
      shiftRight(index);
      mArray[index] = item;
      mCount++;
   }

   /**
   Determines the index position where the given element is stored in the list.
   @return -1 if the element is not found; otherwise its 0-based index.
    */
   public int indexOf(Object item) {
      for (int i = 0; i < mCount; i++) {
         if (mArray[i] == item) {
            return i;
         }
      }
      return -1;
   }

   /**
   Removes an element at the specified index, returning the element that was
   just removed. All elements to the right of the specified index will be
   shifted to the left, decreasing their indices by 1.
    */
   public Object removeAt(int index) {
      Object toReturn = mArray[index];
      shiftLeft(index);
      mCount--;
      return toReturn;
   }

   /**
   Removes a specific element from the list without knowing its index.
    */
   public boolean remove(Object toRemove) {
      int index = indexOf(toRemove);
      if (index >= 0) {
         removeAt(index);
         return true;
      }
      return false;
   }

   /**
   Retrieves the element at a given index.
    */
   public Object get(int index) {
      return mArray[index];
   }

   private void resizeIfNecessary() {
      if (mCount == mArray.length) {
         Object[] newArray = new Object[mArray.length * 2];
         System.arraycopy(mArray, 0, newArray, 0, mCount);
         mArray = newArray;
      }
   }

   private void shiftRight(int startNdx) {
      System.arraycopy(mArray, startNdx, mArray, startNdx + 1,
       mCount - startNdx);
   }

   private void shiftLeft(int startNdx) {
      System.arraycopy(mArray, startNdx + 1, mArray, startNdx,
       mCount - startNdx - 1);
   }

   // void sort(Comparator comp);
   //comparator insertion sort
   public void sort(Comparator comp) {
      for (int i = 1; i < mCount; i++) {
         Object elementI = mArray[i];
         int j;

         for (j = i; j > 0; j--) {
            if (comp.compare(elementI, mArray[j - 1]) < 0) {
               mArray[j] = mArray[j - 1];
            }
            else {
               break;
            }
         }
         mArray[j] = elementI;
      }
   }
}
