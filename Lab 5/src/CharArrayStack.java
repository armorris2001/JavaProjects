//Implement a LIFO stack of integers using an array as the data store.
public class CharArrayStack {
   private char[] mArray;
   private static final int DEFAULT_SIZE = 10;
   private int mCount;

   public CharArrayStack() {
      mArray = new char[DEFAULT_SIZE];
      //System.out.println("Array has size " + mArray.length);
   }

   public int getCount() {
      return mCount;
   }

   public void push(char newValue) {
      if (mCount == mArray.length) {
         // the array is currently full. need to resize before we continue.
         resize(mArray.length * 2);
      }
      //System.out.println("Pushing " + newValue + " into array index " + mCount);
      mArray[mCount++] = newValue;
   }

   private void resize(int newSize) {
      //System.out.println("Resizing...");
      char[] newArray = new char[newSize];
      System.arraycopy(mArray, 0, newArray, 0, mArray.length);

      mArray = newArray;
      //System.out.println("Array has size " + mArray.length);
      // There is a better way to do this.
   }

   public char pop() {
      //System.out.println("Popping from index " + (mCount-1));
      if (mCount > 0)
         return mArray[--mCount];

      throw new IllegalStateException("Tried to pop from an empty stack.");
   }

}
