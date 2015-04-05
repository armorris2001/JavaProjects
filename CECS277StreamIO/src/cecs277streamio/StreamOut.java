/* Adam Morris
     November 29, 2014
     Purpose: This class creates one file to hold objects. It then writes
               the objects to that file
     Inputs: Strings for determining the object file name and objects to write
     Output: creates a file to hold the objects
*/

package cecs277streamio;
//Exception imports
import java.io.FileNotFoundException;
import java.io.IOException;

//Output Stream imports
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Adam
 */
public class StreamOut {
    //Create a name for the ObjectOutptStream Object
    ObjectOutputStream outObjectStream;
    
    //Constructor with a parameter
    public StreamOut(String outObjectFileName) throws FileNotFoundException, IOException{
        //Create object output stream object
        outObjectStream = new ObjectOutputStream(new 
         FileOutputStream(outObjectFileName));
    }

    //Method to write an object to a file
    public void writeObject(Object o) throws IOException{
        //Write object to file
        outObjectStream.writeObject(o);
    }
    
    //Method for closing the object output stream
    public boolean closeOutStream() throws IOException{
        //Close the output object stream
        outObjectStream.close();
        
        return true;
    }
}
