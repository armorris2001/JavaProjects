/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
import java.util.*;

public class BinarySearch {
   private static String [] mArray = {"0", "5", "10", "15", "20", "25", "30",
   "35", "40", "45", "50", "55", "60", "65", "70", "75", "80", "85", "90", "95",
   "100"};


    public static void main(String[] args) {
        String result;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a search number:");
        result = binarySearch(in.nextLine());

        System.out.println("Result is : " + result);
    }

    public static String binarySearch(String search){

      return binarySearch(0, mArray.length, search);
    }

    private static String binarySearch(int begin, int end, String search){
      int index = (begin + end) / 2;
       System.out.println("     Index position = " + index);
       //BASE CASE
       if(mArray[index].compareTo(search) == 0){
          System.out.println("Equal to");
          return mArray[index];
       }
      //RECURSIVE STEP
       else if (mArray[index].compareTo(search) > 0){
          System.out.println("less than");
          end = index;
          return binarySearch(begin, end, search);
       }
       else if (mArray[index].compareTo(search) < 0){
          System.out.println("Greater than");
          begin = index;
          return binarySearch(begin, end, search);
       }
      return "CAN'T FIND";
    }
}
