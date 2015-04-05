/* Adam Morris
     September 16, 2014
     Purpose: This is an abstract class called Measurable the Measurable class
               has a single static method and an abstract method for getMeasure
     Inputs: takes in a generic Arraylist for the largest() static method
     Output: largest() returns the largest generic object
*/
package cecs277generics2;

//Import ArrayList in order to run the static method
import java.util.ArrayList;

/**
 *
 * @author Adam
 * @param <T>
 * 
 */
public abstract class Measurable <T> {

    //Declare the abstract method for returning a quantifiable double value
    public abstract double getMeasure();
    
    //A static method that takes in a generic arrayList and then returns the 
    //largest object of that list.
    public static <T extends Measurable> T largest(ArrayList<T> objects){
        
        //Placeholder for finding the largest element, set to the first index
        T largest = objects.get(0);
        
        //If the arrayList has no elements then return null
        if (objects.isEmpty()){
            return null;
        }
                
        //Enhanced for loop for iterating throught the arrayList
        for(T obj : objects){
            
            //Conditional using the subclass implementation of getMeasure()
            //If the measure of the next element of the array is greater
            //than the measure of the current largest item, then that is the new
            //largest item
            if(obj.getMeasure() > largest.getMeasure()){
                largest = obj;
            }
        }
        
        //returns the largest item
        return largest;
        
    } 
}
