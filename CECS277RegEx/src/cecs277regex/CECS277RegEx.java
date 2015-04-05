/* Adam Morris
     October 23, 2014
     Purpose: This class uses regular expressions to sort through a text file
               This class accesses a class that reads in a file and puts the 
               contents into an arrayList when prompted to by the calling class.
               The class then writes a file for all the words without a u after
               a q.
     Inputs: FileIn sends an array list into the main
     Output: Prints out the totals for each of the five categories, then outputs
              a file with all the words without a u following the q
*/
package cecs277regex;

//Imports for the arraylist, regular expressions and file not found error
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.regex.*;


public class CECS277RegEx {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException{
        
        //A try block to catch null pointer exceptions
        try {

        // TODO code application logic here
        ArrayList<String> aList = new ArrayList<String>();
        
        //Create a new instance of the FileIn Constructor
        FileIn readFile = new FileIn();
         
        //Get the arrayList from the memo file
        aList = readFile.getFileData();
        
        //Create a new instance of the FileOut Constructor
        FileOut fout = new FileOut("noQUs2.txt");
        
        
        
        //1.All of the words with two z's in a row. 
        Pattern p1  = Pattern.compile("[z]{2}");
        ArrayList<String> a1List = new ArrayList<String>();
        
        //2.All of the words with two vowels in a row.
        Pattern p2 = Pattern.compile("[aeiou]{2}");
        ArrayList<String> a2List = new ArrayList<String>();
        
        //3.All of the words with more than two vowels in them.
        Pattern p3 = Pattern.compile("[aeiou].*[aeiou].*[aeiou]");
        ArrayList<String> a3List = new ArrayList<String>();
        
        //4.All of the words with two x's in them.
        Pattern p4 = Pattern.compile("[x].*[x]");
        ArrayList<String> a4List = new ArrayList<String>();
        
        //5.All of the words starting with 'Q' not followed by a 'U'.
        //   For this one item, write these words to a file.
        Pattern p5 = Pattern.compile("^[qQ][^uU]");
        ArrayList<String> a5List = new ArrayList<String>();
        
        
        //Enhanced for loop for iterating through the input list
        for(String s: aList){
            
            //Create a Matcher object of each of the five patterns
            Matcher m1 = p1.matcher(s);
            Matcher m2 = p2.matcher(s);
            Matcher m3 = p3.matcher(s);
            Matcher m4 = p4.matcher(s);
            Matcher m5 = p5.matcher(s);

            //1.All of the words with two z's in a row. 
            if(m1.find()) {
                //Add to arrayList a1List
                a1List.add(s);
            }
            
            //2.All of the words with two vowels in a row.
            if(m2.find()) {
                //Add to arrayList a2List
                a2List.add(s);
            }
            
            //3.All of the words with more than two vowels in them.
            if(m3.find()) {
                //Add to arrayList a3List
                a3List.add(s);
            }
            
            //4.All of the words with two x's in them.
            if(m4.find()) {
                //Add to arrayList a4List
                a4List.add(s);
            }
            
            //5.All of the words starting with 'Q' not followed by a 'U'.
            //   For this one item, write these words to a file.
            if(m5.find()) { 
                //Add to arrayList a5List
                a5List.add(s);
                //Write to output file
                fout.writeStr(s);
            }
        }
        
        //Output of all totals
        System.out.println("All words: " +  aList.size() + "\n\n" +
                           "Size of 1: " + a1List.size() + "\n\n" +
                           "Size of 2: " + a2List.size() + "\n\n" +
                           "Size of 3: " + a3List.size() + "\n\n" +
                           "Size of 4: " + a4List.size() + "\n\n" +
                           "Size of 5: " + a5List.size() + "\n\n" );
         
        //Close the output file
         fout.out.close();
        
        }
        catch(NullPointerException e) {
            System.out.println("File was not created successfully.");
            System.out.println(e);
        }
        finally {
            System.exit(0); 
        }
    }
    
}


/* OUTPUT FILE
qabala
qabalah
qabalahs
qabalas
qadi
qadis
qaid
qaids
qanat
qanats
qat
qats
qi
qindar
qindarka
qindars
qintar
qintars
qis
qiviut
qiviuts
qoph
qophs
qwerty
qwertys
*/

/* OUTPUT TO SCREEN
run:
Qt: Untested Windows version 6.3 detected!
Qt: Untested Windows version 6.3 detected!
Qt: Untested Windows version 6.3 detected!
Qt: Untested Windows version 6.3 detected!
The file you selected is C:\Users\Adam\Desktop\scrabble.txt
New File opened
All words: 178691

Size of 1: 385

Size of 2: 63864

Size of 3: 132420

Size of 4: 16

Size of 5: 25


BUILD SUCCESSFUL (total time: 10 seconds)
*/