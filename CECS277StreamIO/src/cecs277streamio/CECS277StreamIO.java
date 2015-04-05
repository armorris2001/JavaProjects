/* Adam Morris
     November 29, 2014
     Purpose: This class creates one file to hold three objects. It then reads
               in the objects and gives the user a choice of what ice cream cone
               to choose
     Inputs: Strings for determining which cone object to display
     Output: creates a file to hold the objects and outputs data to the screen
*/

package cecs277streamio;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
/**
 *
 * @author Adam
 */
public class CECS277StreamIO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, 
     FileNotFoundException, ClassNotFoundException {
        
        try{
            //Add in three cones with toppings
            AdvancedIceCreamCone choc = new AdvancedIceCreamCone(1, "Chocolate", 
             "Sugar");
            choc.addToppings("Cherries");
            choc.addToppings("Walnuts");
            choc.addToppings("Marshmallows");

            AdvancedIceCreamCone van = new AdvancedIceCreamCone(2, "Vanilla", 
             "dipped waffle");
            van.addToppings("Chocolate Syrup");

            AdvancedIceCreamCone straw = new AdvancedIceCreamCone(23, 
             "Strawberry", "Waffle");
            straw.addToppings("Graham Crackkers");
            straw.addToppings("Bananas");

            //Create a new Output stream file to write to object2.bin
            StreamOut out = new StreamOut("object2.bin");

            //Write each object to the output file
            out.writeObject(choc);
            out.writeObject(van);
            out.writeObject(straw);

            //Close the output file
            out.closeOutStream();

            //Create new input object stream coming from the output file
            StreamIn in = new StreamIn("object2.bin");

            //Create an arrayList to take in the objects
            ArrayList<Object> cones = in.getObjArrayL();

            //Ask which flavor you would prefer
            System.out.println("Which would you prefer?");

            //Iterate through the flavors to display the flavor types
            for(Object o: cones){
                System.out.println(((AdvancedIceCreamCone)o).getFlavor());
            }

            System.out.println("___________________________\n");

            //Create a Scanner object to take in the user's choice
            Scanner input = new Scanner(System.in);

            //Take in the user's choice into a string
            String choice = input.next();

            //Iterate through the arrayList in order to find the object with the 
            // matching flavor. Once there, display the toString of that object
            for(Object o: cones){
                
           if((((AdvancedIceCreamCone)o).getFlavor()).equalsIgnoreCase(choice)){
                    System.out.println(((AdvancedIceCreamCone)o));
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            System.exit(0);
        }
    }
}

/*
OUTPUT

run:
Objects Read in: 3
Which would you prefer?
Chocolate
Vanilla
Strawberry
___________________________

Strawberry
The number of scoops is 23. The flavor is Strawberry. And the type of cone is 
 Waffle and the toppings are: [Graham Crackkers, Bananas]
BUILD SUCCESSFUL (total time: 5 seconds)
*/