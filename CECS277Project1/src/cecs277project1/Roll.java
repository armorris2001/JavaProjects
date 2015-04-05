/* Adam Morris
     September 04, 2014
     Purpose: This class generates a single lotto ticket
     Inputs: none
     Output: none. Creates a toString() method only.
*/

package cecs277project1;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Roll {

   // Input and variable instantiation
   private Random mRand = new Random();
   private ArrayList<Integer> mPick = new ArrayList<Integer>();
   private int mPickSize = 6; // Tells program to look for 6 random numbers

   // Constructor creates and sorts the randomly picked lotto numbers
   // from 1 to 49
   Roll() {
/* ORIGINAL VERSION
      // Adds the random lotto tickets to the ArrayList called mPick
      for (int i = 0; i < pickSize; i++) {
         mPick.add(mRand.nextInt(49)+1);
      } // end for
*/


      // NEW VERSION
      // Adds the random lotto tickets to the ArrayList called mPick
      for (int i = 0; i < mPickSize; i++) {
         boolean flag = false; // flag for finding duplicate values
         int temp = mRand.nextInt(49) + 1; // instantiate a random temp value

         for(int value : mPick){ // improved for loop to check for temp value
            if (temp == value){
               flag = true; // sets a flag for finding equivalent values
            } // end if
         } // end improved for loop

         if (flag){
            i--; // Decrements the count in case a equivalent value is found
         } // end if
         else
            mPick.add(temp); // Adds the temporary value to the ArrayList
      } // end outer for

      // END NEW VERSION


      // Sorts the ArrayList into ascending order
      Collections.sort(mPick);
   }; // end Roll()

   // toString() overide iterates through the Array list to
   //  create a string of the lotto numbers.
   @Override public String toString() {
      String outPut = "";
      for(int out : mPick){ // Iterates mPick to create the outPut String
         outPut += out + " "; // Adds spacing to outPut String
      }
      return outPut; // Sends outPut String out of the class.
   }; // end toString()
} // end Roll class
