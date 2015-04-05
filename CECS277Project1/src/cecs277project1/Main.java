/* Adam Morris
     September 04, 2014
     Purpose: This program generates a specified number of lotto tickets
     Inputs: numberOfTickets: the user’s choice of tickets to make.
             userOut: the user's choice for output or not ("y" or "n").
     Output: User prompts followed by the specified number of tickets.
*/

package cecs277project1;

import java.util.*;

public class Main {

   public static void main(String[] args) {
       
       // Input and variable instantiation
       Scanner in = new Scanner(System.in);
       String input = "";
       int numberOfTickets = 0;
       int count = 1;
       ArrayList<Roll> tickets = new ArrayList<Roll>();


       // Basic Error Check for yes or no input choice
       boolean flag = false; // Boolean flag for while loop
       while (!flag) {
          try {
             // Request for input of number of tickets required.
             System.out.println("Please pick the number of lotto tickets to "
              + "generate.");
             numberOfTickets = in.nextInt(); // Take in the number of tickets
             flag = true; // Flag to end while loop
          } // end try
          catch (InputMismatchException exception) {
             // Print the java exception
             System.out.println(exception);
             // State that an integer value was expected
             System.out.println("This is not an integer number value."
              + "\nPlease type in an integer value:  '1, 2, 3, ...'");
             in.nextLine(); // clear the in Scanner
          } // end catch
      } // end while


       // Notification and Generation of tickets into an ArrayList
       System.out.println(numberOfTickets + " Tickets are generated.\n");
       while ( numberOfTickets-- > 0){ // loop to add tickets to Arraylist
         tickets.add(new Roll());
       } // end while


       // Basic Error Check for yes or no input choice
       flag = false; // Resetting flag to false
       while (!flag) {
          // Ask the user for output or not.
          // Display formatted lotto tickets if "y"
          // Display "No tickets will be displayed" if "n"
          System.out.println("Would you like to view all tickets? (y or n)");
          input = in.next(); // Input to view tickets or not
          
          if (input.equals("y") || input.equals("n"))
            flag = true; // Flag set to true to end while loop
          else {
            while (!flag) {
               System.out.println("Please input 'y' for yes or 'n' for no");
               input = in.next(); // Take in new input String
               in.nextLine(); // Clear the in Scanner Variable

               // If the variable is y or n then end the error loop
               if (input.equals("y") || input.equals("n"))
                  flag = true; // Flag to end while loops
             } // end inner while
          } // end else
       } // end outer while
          

      if ( input.equals("y")){
          for (Roll r : tickets){ // iterate through tickets ArrayList
            // Display tickets ArrayList
            System.out.println("Ticket " +count++ + ": " + r.toString());
          }
       }
       else if (input.equals("n") ){
          // Display "No tickets will be displayed" to user
          System.out.println("No tickets will be displayed.");
       }

       // End of Program notification for user
       System.out.println("Program Ended");

   }
}

