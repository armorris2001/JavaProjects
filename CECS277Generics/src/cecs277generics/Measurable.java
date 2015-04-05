package cecs277generics;
import java.util.*;

/**
   Describes any class whose objects can be measured.
 * @param <T>
*/

public abstract class Measurable <T>
{
   /**
      Computes the measure of the object.
      @return the measure
   */
   public abstract T getMeasure();
   
 
   
   public static <T extends Measurable> T getLargest(ArrayList<T> objects){
        
       T largest = objects.get(0);
        
        for (T obj : objects) {
            if(obj.getMeasure() > largest.getMeasure()) {
                largest = obj;
            }
        }
        
        return largest;
    } 

   @Override public String toString(){
        return "Measure Larger Object";
    }
}


