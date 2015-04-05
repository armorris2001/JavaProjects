/* Adam Morris
     September 07, 2014
     Purpose: This class reads in a file and puts the contents into an arrayList
               when prompted to by the calling class
     Inputs: JFileChooser - pulls in file from user specifed location
     Output: Creates a toString() method stating the object type and what
              file the object is attached to.  
*/
package cecs277regex;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;


public class FileIn {
   //Create a Scanner for the file
   Scanner minFile;
   //Create a File to access
   File mselectedFile;
   
   //Default Constructor pulls up the JFileChooser
   FileIn() throws FileNotFoundException{
      //New JFileChooser Object
      JFileChooser chooser = new JFileChooser();
      if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
      {
         //Sets the selected file member variable
         mselectedFile = chooser.getSelectedFile();
         //Sets the Scanner related to the file
         minFile = new Scanner(mselectedFile);
         //Displays what file was selected
         System.out.println("The file you selected is " + mselectedFile );
      }
   }
   
   //Retreives data from the file and places it in an arrayList
   public ArrayList getFileData() throws NullPointerException{
      
      //Create a new arrayList object to return to the calling object
      ArrayList<String> arrayL = new <String> ArrayList();
      
      //Read in lines of the file to the arrayList
      while(minFile.hasNext()){
         
         //Add a line of the file to the arrayList
         arrayL.add(minFile.nextLine());
      }
      
      //Send the arrayList back to the calling function
      return arrayL;
   }
   
   //toString() to display the type of object and the file associated with it
   @Override public String toString(){
      
      //Returning the message in string form
      return "This is a FileIn object attached to file: \n"
       + mselectedFile;
   }
}
