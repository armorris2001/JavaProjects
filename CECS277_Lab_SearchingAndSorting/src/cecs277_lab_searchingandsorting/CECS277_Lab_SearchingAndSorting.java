/* Adam Morris
     November 04, 2014
     Purpose: This class loads random numbers into an array then sorts them
               using bubble sort
     Inputs: None
     Output: Outputs the unsorted and sorted array
*/
package cecs277_lab_searchingandsorting;

import static java.lang.Math.abs;
import java.util.Random;

/**
 *
 * @author Adam
 */
public class CECS277_Lab_SearchingAndSorting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //size of array to create
        int arraySize = 12;
        
        //size of seed value
        int seed = 6;
        
        //temporary holder for bubble sort
        int swap = 0;
        
        //Create a new array
        int[] array = new int[arraySize];
        
        //Set up the randome number generator
        Random rnd = new Random();
        rnd.setSeed(seed);
        
        //Create an array of ints truncated to 10000
        for (int i = 0; i < array.length; i++){
            array[i] = abs(rnd.nextInt() % 10000);
        }
        
        //Print out presorted array
        for(int i: array){
            System.out.println("Array Int: " + i);
        }
        
        //Sort the array
        for (int i = 0; i < array.length; i++) {
            //Inner for loop goes through entire array and sorts one number
            for (int j = 0; j < array.length - i - 1; j++) {
                //If the j spot is larger than the next one, then swap them
                if (array[j] > array[j+1])
                {
                    //Swap hold the value to be moved
                    swap       = array[j];
                    //Move the smaller element to the left
                    array[j]   = array[j+1];
                    //Move the larger element to the right
                    array[j+1] = swap;
                }
            }
        }
        
        //Spacer for formating
        System.out.println("\n");
        
        //Print out the sorted array
        for(int i: array){
            System.out.println("Sorted Int: " + i);
        }
          
    }
    
}

/*
run:
Array Int: 4074
Array Int: 3752
Array Int: 5963
Array Int: 8357
Array Int: 13
Array Int: 2489
Array Int: 8755
Array Int: 9608
Array Int: 5181
Array Int: 6014
Array Int: 5879
Array Int: 8537


Sorted Int: 13
Sorted Int: 2489
Sorted Int: 3752
Sorted Int: 4074
Sorted Int: 5181
Sorted Int: 5879
Sorted Int: 5963
Sorted Int: 6014
Sorted Int: 8357
Sorted Int: 8537
Sorted Int: 8755
Sorted Int: 9608
BUILD SUCCESSFUL (total time: 0 seconds)
*/