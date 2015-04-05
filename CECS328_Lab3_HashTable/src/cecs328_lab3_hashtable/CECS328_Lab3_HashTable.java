/*
Name: Adam Morris
Course: CECS 328
Class Name: CECS328_Lab3_HashTable
Purpose: Holds the main class to load and test the functionality of the Hash
         Table class. (this is the driver class)
 */

package cecs328_lab3_hashtable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Adam
 */
public class CECS328_Lab3_HashTable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a hash table of the specified size of 509.
        HashTable h = new HashTable(509);

        // Start a scanner object called in.
        Scanner in = new Scanner(System.in);

        // Declare the file name in a string.
        String fileIn = "players_homeruns.csv";

        // Open a  Buffered Reader Object.
	BufferedReader br = null;

        // Blank holder for each line of the text file.
	String line = "";

        // Specify the comma as a delimiter.
	String delimiter = ",";


	try {
            // Open the file stream.
            br = new BufferedReader(new FileReader(fileIn));

            // Read each line until the end of the file.
            while ((line = br.readLine()) != null) {

                // Temporary key and value holders.
                String tempKey;
                int tempValue;

                // Use a comma as a delimiter for the CSV file.
                String[] splitString = line.split(delimiter);

                // Broke this split String apart for readability.
                tempKey = splitString[0];
                tempValue = Integer.parseInt(splitString[1]);

                // Insert the found key into the hash table.
                h.insert(tempKey, tempValue);

            }

	}
        catch (FileNotFoundException e) {
            System.out.print("File Not Found: ");
	}
        catch (IOException e) {
            System.out.print("Input Output Exception: ");
	} finally {
            // If the file is empty then try to close.
            if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
                            System.out.println(e);
                        }
		}
	}
        // Flag for part 4 loop.
        boolean flag = false;

        // Program part 4 LOOP
        while(!flag){
            // Blank string for holding user input
            String temp = "";
            System.out.print("Please Enter a Player Name: (exit to exit)");
            temp = in.nextLine();

            if(temp.equals("exit")){
                flag = true;
            }
            else{
                // Check to see if key is present, then find the key in HTable.
                if(h.containsKey(temp)){
                    try{
                        System.out.println(h.find(temp));

                    } catch (HashTableNotFoundException findError){
                        System.out.println(findError +
                         "Trying Find Player Not Found: ");
                    }
                }
                else
                    System.out.println("Player Name Not Found.");
            }
        } // end find while
    }
}

/*

run:
Please Enter a Player Name: (exit to exit)Babe Ruth
714
Please Enter a Player Name: (exit to exit)Ted Williams
521
Please Enter a Player Name: (exit to exit)Albert Pujols
520
Please Enter a Player Name: (exit to exit)Reggie Willits
0
Please Enter a Player Name: (exit to exit)Neal Terrell
Player Name Not Found.
Please Enter a Player Name: (exit to exit)exit
BUILD SUCCESSFUL (total time: 52 seconds)

*/