/* Adam Morris
     September 16, 2014
     Purpose: This class creates an array list of TriangleMeasureExtend objects
               then checks for the largest item in the list
     Inputs: none
     Output: Shows the objects as they are created and added to the arrayList,
              then shows a smallest last object, then shows the largest object.
*/

package cecs277generics2;

//include ArrayList and Collections for objects
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Adam
 */
public class CECS277Generics2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Create an Arraylist of TriangleMeasureExtend Objects
        ArrayList<TriangleMeasureExtend> aList = 
         new ArrayList<TriangleMeasureExtend>();
        
        
        //Have a for loop create 10 TriangleMeasureExtend Objects and add them
        //to the arrayList
        for(int i = 0; i < 10; i++){
            if(i % 2 == 0) //if the iterator is an even number
                aList.add(new TriangleMeasureExtend(i+2, i+1)); //add to aList
            else if( i % 2 != 0){ //if iterator is odd
                aList.add(new TriangleMeasureExtend(i+3, i+5)); //add to aList
            }
            //Print each obj as it's created
            System.out.println(i+ ".\n" + aList.get(i)+ "\n"); 
        }
        
        //Add one additional object of size 0 in order to make sure that the 
        //algorithm works
        aList.add(new TriangleMeasureExtend(0,0));
        
        //Print out the last triangle in the arrayList
        System.out.println("Last Triangle Position:\n" +
         aList.get(aList.size()-1) + "\n");
        
        //Shuffle the arrayList to make sure that largest works
        Collections.shuffle(aList);
        
        //Create an object for the largest method to go into
        TriangleMeasureExtend t = Measurable.largest(aList);
        
        //Print out the largest object
        System.out.println("Largest Triangle: \n" +t);
    }
    
}
