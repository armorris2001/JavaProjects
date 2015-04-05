/* Adam Morris
     December 4th, 2014
     Purpose: This class creates a runnable object in order to test how
               fast each threading process runs. The objects represent an animal
               with a speed and a rest rate. Boolean values are also polled for 
               completion status
     Inputs: Integers and Strings for the distance of the race, the number of 
               animals, the number of laps, the name of the animal, and the 
               speed of the animal.
     Output: Data about lap completion is printed to the screen. 
*/

package cecs277threads;

/**
 *
 * @author Adam
 */
public class RunningAnimal implements Runnable {
    private int mSpeed;
    private String mName = "";
    private int mRestFactor;
    private int mDistance;
    private int mLength;
    private int mLap;
    private int mLapNumber;
    private int mLapLength;
    private boolean mFinish = false;
    
    //Constructor with input parameters
    public RunningAnimal(String name, int speed, int rest, int distance, 
     int laps){
        mName = name;
        mSpeed = speed;
        mRestFactor = rest;
        mDistance = distance;
        mLap = laps;
        mLapLength = mDistance/mLap;
        mLapNumber = 1;
    }
    
    //Implement the run function from the runnable interface
    @Override
    public void run() {
        //Run a while loop that increases the length the onject animal travels
        // then check it against the distance of the race
        while ( mLength++ < mDistance){
            //A placeholder line of code if need to demonstrate each iteration
            //System.out.println(mName + ": " + mLength + " traveled.");
            //Add the speed value of the animal to the length traveled
            mLength += mSpeed;
            //Checking for a lap even if the animal goes past a specific value
            if(mLength >= (mLapNumber * mLapLength)){
                //state the lap finished
                System.out.println(mName + " FINISHED LAP " + mLapNumber++);
                //place holder for the rest time required for the animal
                int restTime = 0;
                //while loop to run through the rest of the animal
                while (restTime++ <= mRestFactor)
                    System.out.println(mName + " rests...");
                    
            }
        }
        //Print out the animal's finishing the race
        System.out.println("\n" + mName.toUpperCase() + " FINISHED!!\n");
        //Set the boolean holder for the object's finish status
        mFinish = true;
    }
    
    //Override the toString method
    @Override
    public String toString(){
        return mName;
    }
    
    //Setters and Getters
    public int getSpeed(){return mSpeed;}
    public boolean setSpeed(int speed){
        if(speed >= 0){
            mSpeed = speed;
            return true;
        }
        return false;
    }
        
    public String getName(){return mName;}
    public boolean setName(String name){
        mName = name;
        return true;
    }
    
    public int getRest(){return mRestFactor;}
    public boolean setRest(int rest){
        if(rest >= 0){
            mRestFactor = rest;
            return true;
        }
        return false;
    }
    
    public int getDistance(){return mDistance;}
    public boolean setDistance(int distance){
        if(distance >= 0){
            mDistance = distance;
            return true;
        }
        return false;
    }
    
    public boolean getFinish(){return mFinish;}
    public boolean setFinish(boolean finish){
        mFinish = finish;
        return true;
    }
        
}
