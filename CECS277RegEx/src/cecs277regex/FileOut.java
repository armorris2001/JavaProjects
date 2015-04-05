/* Adam Morris
     September 07, 2014
     Purpose: This class writes to a file either to a default file or to a 
               user specified location
     Inputs: Scanner takes in input from user as to what file needs to be
              created. Strings go into writeStr in order to output to a file.
     Output: writeStr outputs a string to a file created by the FileOut object.
             Creates a toString() method stating the object type and what
              file the object is attached to.  
*/
package cecs277regex;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileOut{
   public String mdefName = "defaultFile.txt";
   public String mfileName = "";
   public File mfileOut;
   public PrintWriter out;
   
   public FileOut(){
      System.out.println("Created a default named file: " + mdefName);
   }
   
   public FileOut(String fileName) throws FileNotFoundException{
      Scanner in = new Scanner(System.in);
      mfileName = fileName;
      mfileOut = new File(fileName + ".txt");
      
      if(!mfileOut.exists()){
         System.out.println("New File opened");
         out = new PrintWriter(mfileOut);
      }
      else {
         System.out.println("File already exists. Do you want to "
          + "override? (y or n)");
         
         if(in.next().equals("y"))
            System.out.println("File overridden.");
         else{
            System.out.println("Enter a new file name (without .txt)");
            mfileName = in.next();
            mfileOut = new File(fileName + ".txt");
            System.out.println("New File Created.");
         }
      } 
   }
   
   //Takes in a string and outputs it to the file attached to the object
   public void writeStr(String s) throws FileNotFoundException{
      out.println(s);
   }
   
   //toString() to display the type of object and the file associated with it
   @Override public String toString(){
      
      //Returning the message in string form
      return "This is a FileOut object attached to file: \n"
       + mfileOut;
   }
}
