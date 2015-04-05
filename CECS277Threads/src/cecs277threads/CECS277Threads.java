/* Adam Morris
     December 4th, 2014
     Purpose: This class creates multiple runnable objects in order to test how
               fast each process runs. The objects represent animals with a
               speed and a rest rate. The program will display which object
               finished its processes first in a race complete area.
     Inputs: Integers and Strings for the distance of the race, the number of 
               animals, the number of laps, the name of the animal, and the 
               speed of the animal.
     Output: User prompts for input to the runnable objects representing the 
               animals.
*/
package cecs277threads;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author Adam
 */
public class CECS277Threads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Holder for number of runnable objects to be run as threads
        int threadCount;
        //ArrayList for all Runnable objects
        ArrayList<RunningAnimal> raceList = new ArrayList<>();
        //ArrayList for holding the finishers as they come in
        ArrayList<RunningAnimal> finishList = new ArrayList<>();
        //Input Scanner
        Scanner in = new Scanner(System.in);
        //Temporary holder for distance value
        int tempDistance = 1;
        //Distance value
        int distance;
        
        
        //User prompt for number of runnable objects (animals) in a try catch
        while(true){
            System.out.print("Enter number of Animals you wish to race: ");
            try{
                threadCount = in.nextInt();
                //Break if lap number is at least 1
                if(threadCount >= 1)
                    break;
            }
            catch(InputMismatchException e){
                //Print out error message
                System.out.println(e + " expected an integer.");
                //Clear the input buffer
                in.nextLine();
            }
        }
        
        
        
        while((double)tempDistance % 50 != 0){
            try{
            System.out.print("Enter total race distance in multiples of 50: ");
            tempDistance = in.nextInt();
            }
            catch(InputMismatchException e){
                //Print out error message
                System.out.println(e + " expected an integer.");
                //Clear the input buffer
                in.nextLine();
            }
        }
        
        //Clear the input buffer
        in.nextLine();
        //set the distance to the correct value
        distance = tempDistance;
        //Create a blank lap number
        int lapNumber = 0;
        
        //Get user input for the number of laps with error correction
        while(lapNumber  <= 0){
            try{
                System.out.print("Enter number of laps (1 or greater)");
                lapNumber = in.nextInt();
            }
            catch (InputMismatchException e){
                //Print out error message
                System.out.println(e + " expected an integer.");
                //Clear the input buffer
                in.nextLine();
            }
        }

        //Clear the input buffer
        in.nextLine();    
        
        //Data input for Runnable object initialization
        for(int i = 0; i < threadCount; i++){
            
            System.out.print("Enter Name of Animal " + (i+1) + ": ");
            String name = in.nextLine();
            int speed;
            int rest;
            
            while(true){
                try{
                    System.out.print("Enter Speed of " + name + ": ");
                    speed = in.nextInt();
                    break;
                }
                catch(InputMismatchException e){
                    //Print out error message
                    System.out.println(e + " expected an integer.");
                    //Clear the input buffer
                    in.nextLine();
                }
            }
            while(true){
                try{
                    System.out.print("Enter Rest Rate of " + name + ": ");
                    rest = in.nextInt();
                    break;
                }
                catch(InputMismatchException e){
                    //Print out error message
                    System.out.println(e + " expected an integer.");
                    //Clear the input buffer
                    in.nextLine();
                }
            }
            
            //Add the runnable object to the arraylist
            raceList.add(new RunningAnimal(name, speed, rest, distance, 
             lapNumber));
            
            //Clear the input buffer
            in.nextLine();
        }

        //For each to start the threads held in the arraylist
        for(RunningAnimal a: raceList){
            Thread t = new Thread(a);
            t.start();
        }
        
        //Superloop to poll every object for completion
        while(true){
            //For each to see if each runnable completed
            for(RunningAnimal a: raceList){
                //if finished and not already in the finish list, then add
                if(a.getFinish() && !finishList.contains(a))
                    finishList.add(a);
            }
            
            //If all runnables are finished, then show finisher data
            if(finishList.size() == threadCount){
                //Holder value for placement iterator for winners
                int finishCount = 1;
                System.out.println("\n\nRace Complete!\n");
                System.out.println("__________________");
                //For each to print out all finishers of the race
                for(RunningAnimal a: finishList){
                    System.out.println( finishCount++ + " place: " + a );
                }
                //break to end program
                break;
            }//end if
        }//end polling superloop
    }//end main
}//end class

/* OUTPUT
run:
Enter number of Animals you wish to race: errorcheck
java.util.InputMismatchException expected an integer.
Enter number of Animals you wish to race: 3
Enter total race distance in multiples of 50: errorcheck
java.util.InputMismatchException expected an integer.
Enter total race distance in multiples of 50: 51
Enter total race distance in multiples of 50: 200
Enter number of laps (1 or greater)errorcheck
java.util.InputMismatchException expected an integer.
Enter number of laps (1 or greater)5
Enter Name of Animal 1: Turtle
Enter Speed of Turtle: 2
Enter Rest Rate of Turtle: 1
Enter Name of Animal 2: Dog
Enter Speed of Dog: 8
Enter Rest Rate of Dog: 4
Enter Name of Animal 3: Horse
Enter Speed of Horse: 10
Enter Rest Rate of Horse: 5
Turtle FINISHED LAP 1
Turtle rests...
Turtle rests...
Turtle FINISHED LAP 2
Turtle rests...
Turtle rests...
Turtle FINISHED LAP 3
Turtle rests...
Turtle rests...
Turtle FINISHED LAP 4
Turtle rests...
Turtle rests...
Turtle FINISHED LAP 5
Turtle rests...
Turtle rests...

TURTLE FINISHED!!

Horse FINISHED LAP 1
Horse rests...
Horse rests...
Dog FINISHED LAP 1
Dog rests...
Dog rests...
Horse rests...
Horse rests...
Horse rests...
Horse rests...
Dog rests...
Dog rests...
Dog rests...
Dog FINISHED LAP 2
Dog rests...
Dog rests...
Dog rests...
Dog rests...
Horse FINISHED LAP 2
Horse rests...
Horse rests...
Horse rests...
Dog rests...
Horse rests...
Dog FINISHED LAP 3
Horse rests...
Horse rests...
Dog rests...
Dog rests...
Horse FINISHED LAP 3
Horse rests...
Horse rests...
Horse rests...
Horse rests...
Horse rests...
Horse rests...
Dog rests...
Horse FINISHED LAP 4
Horse rests...
Dog rests...
Dog rests...
Dog FINISHED LAP 4
Horse rests...
Dog rests...
Horse rests...
Dog rests...
Horse rests...
Horse rests...
Horse rests...
Horse FINISHED LAP 5
Dog rests...
Dog rests...
Horse rests...
Dog rests...
Horse rests...
Horse rests...
Horse rests...
Horse rests...
Horse rests...
Dog FINISHED LAP 5
Dog rests...

HORSE FINISHED!!

Dog rests...
Dog rests...
Dog rests...
Dog rests...

DOG FINISHED!!



Race Complete!

__________________
1 place: Turtle
2 place: Horse
3 place: Dog
BUILD SUCCESSFUL (total time: 1 minute 33 seconds)
*/
