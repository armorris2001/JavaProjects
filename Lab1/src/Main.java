/*
 *Adam Morris
 * 010858274
 * CECS 274
 * Lab 1
 */

import java.util.*;

public class Main {

   public static void main(String[] args) {


      String highway = "";//String for input from user
      String highwayNumberString = "";
      boolean exitFlag = false;//controls exit of program
      boolean inputFlag = false;//Controls error check
      int highwayNumberInt = 0;//Stores highway number after parse

      //exits loop on highway = exit
      while (!exitFlag) {
         //receives input and stores as String
         highway = input(highway);
         //checking input
         inputFlag = inputCheck(inputFlag, highway);

         // requeries for bad entries
         while (!inputFlag) {
            System.out.println("I don't know that highway.\n");
            highway = input(highway);//receives input and stores as String
            inputFlag = inputCheck(inputFlag, highway);//checking input
         }

         //exits while loop
         if (highway.equals("exit")) {
            exitFlag = true;
            break;
         }
         //Pulls numbers out of String
         highwayNumberString = splitOutNumberString(highway);
         //Parse String into a integer
         highwayNumberInt = stringParse(highwayNumberString);
         //Prints Highway information
         outputHwyInfo(highwayNumberInt);
      }
   }

   public static String input(String highway) {//takes in user input
      Scanner in = new Scanner(System.in);
      System.out.print("Please enter a US Interstate Highway name: ");
      highway = in.nextLine();
      return highway;
   }

   //check input
   public static boolean inputCheck(boolean inputFlag, String highway) {
      if (highway.matches("Interstate " + "[0-9]+")
       || highway.matches("I" + "[0-9]+")
       || highway.matches("I-" + "[0-9]+")
       || highway.matches("[0-9]+") || highway.matches("exit")) {
         return inputFlag = true;
      }
      else {
         return inputFlag = false;
      }
   }

   //Pulls numbers out of String
   public static String splitOutNumberString(String highway) {
      int highwayIndex = 0;//highway.indexOf(" ");

      if (highway.matches("Interstate " + "[0-9]+")) {
         String highwayNumberString = highway.substring(11);
         return highwayNumberString;
      }
      else if (highway.matches("I" + "[0-9]+")) {
         highwayIndex = 1;
      }
      else if (highway.matches("I-" + "[0-9]+")) {
         highwayIndex = 2;
      }
      else if (highway.matches("[0-9]+")) {
         highwayIndex = 0;
      }

      String highwayNumberString = highway.substring(highwayIndex);
      return highwayNumberString;
   }

   //Parse String into a integer
   public static int stringParse(String highwayNumberString) {
      int parsedStringInt = Integer.parseInt(highwayNumberString);
      return parsedStringInt;
   }

   //Output information String about Freeway
   public static void outputHwyInfo(int highwayNumberInt) {
      String orientation = "";
      String size = "";
      String auxiliary = "";
      final int MAJOR_HWY_FACTOR = 100;
      final int MINOR_HWY_FACTOR = 99;
      final int ARTERIAL_FACTOR = 5;
      final int FIRST_DIGIT_FINDER = 100;
      final int PARENT_ROAD_FINDER = 100;

      if (highwayNumberInt < MAJOR_HWY_FACTOR) {
         if (highwayNumberInt % 2 == 0) {
            orientation = " oriented east-west";
         }
         else {
            orientation = " oriented north-south";
         }
         if (highwayNumberInt % ARTERIAL_FACTOR == 0) {
            size = " is a long-distance arterial highway";
         }
         else {
            size = " is";
         }
         System.out.println("Interstate " + highwayNumberInt + size
          + orientation + ".\n");
      }
      else if (highwayNumberInt > MINOR_HWY_FACTOR) {//Auxiliary Highways
         int firstDigit = highwayNumberInt / FIRST_DIGIT_FINDER;
         int parentRoad = highwayNumberInt % PARENT_ROAD_FINDER;

         if (firstDigit % 2 == 0) {//circumferential highway
            auxiliary = " is a circumferential highway of Interstate "
             + parentRoad;
         }
         else {
            auxiliary = " is a spur highway of Interstate " + parentRoad;
         }
         System.out.println("Interstate " + highwayNumberInt + auxiliary
          + ".\n");
      }
   }
}

/*
Please enter a US Interstate Highway name: Interstate 110
Interstate 110 is a spur highway of Interstate 10.

Please enter a US Interstate Highway name: I-95
Interstate 95 is a long-distance arterial highway oriented north-south.

Please enter a US Interstate Highway name: I880
Interstate 880 is a circumferential highway of Interstate 80.

Please enter a US Interstate Highway name: 580
Interstate 580 is a spur highway of Interstate 80.

Please enter a US Interstate Highway name: I-24
Interstate 24 is oriented east-west.

Please enter a US Interstate Highway name: exit
BUILD SUCCESSFUL (total time: 37 seconds)
 */
