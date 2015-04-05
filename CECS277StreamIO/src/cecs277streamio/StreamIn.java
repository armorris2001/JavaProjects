/* Adam Morris
     November 29, 2014
     Purpose: This class reades in a file specified by the user and then returns
               an ArrayList of the objects found in the file
     Inputs: Strings for determining the object file name
     Output: creates an ArrayList to hold objects
*/

package cecs277streamio;
//Exception Imports
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

//Input Stream imports
import java.io.FileInputStream;
import java.io.ObjectInputStream;

//Data Handling import
import java.util.ArrayList;
/**
 *
 * @author Adam
 */
public class StreamIn{
    //Create an ArrayList for reading in objects of any type
    ArrayList<Object> aL = new ArrayList<>();
    
    //Create an ObjectInputStream Object
    ObjectInputStream inStream;
    
    //Constructor to take in objects from a file specified by the parameter
    public StreamIn(String fileName) throws FileNotFoundException, IOException, 
     ClassNotFoundException{
        //file pointer for ObjectInputStream 
        inStream = new ObjectInputStream(new FileInputStream(fileName));
        
        //Read in objects until the function throws an EOF Exception
        try{
            while(true){
                aL.add(inStream.readObject());
            }
        }
        catch(ClassNotFoundException e){
            //If no objects could be found
            System.out.println("No Objects Read in: " + e);
        }
        catch(EOFException eof){
            //Statement of how many objects were read in.
            System.out.println("Objects Read in: " + aL.size());
        }
                
        //Close the input stream
        inStream.close();
        
    }
    
    //Method to send out ArrayList
    public ArrayList<Object> getObjArrayL(){
        return aL;
    }
                
}
