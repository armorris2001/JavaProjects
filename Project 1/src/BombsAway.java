/*******************************************************************************
 * Adam Morris
 * 010858274
 * Project 1
 ******************************************************************************/
import java.util.*;
import java.text.*;

public class BombsAway {

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int seedValue = 0;
      double angle = 0, gunPowder = 0, targetDistance = 0, finalDistance = 0;
      DecimalFormat twoPlaces = new DecimalFormat("#.##");

      while (true) { //receive Seed value
         System.out.println("Please enter a positive integer seed value:");
         if (in.hasNextInt()) {//error check
            seedValue = in.nextInt();
         }
         else {
            in.next();
            continue;
         }
         if (seedValue > 0) {
            targetDistance = randomWithSeed(seedValue);
            System.out.println("The target is "
             + twoPlaces.format(targetDistance) + "m away.\n");
            break;
         }
         else {
            continue;
         }
      }//end while for Seed Value

      while (true) {//game loop
         while (true) {// receive Angle
            final double MAX_ANGLE = 90;
            //in.next();
            System.out.print("Please enter an angle between 0 and "
             + "90 degrees:\n");
            if (in.hasNextDouble()) {//error check
               angle = in.nextDouble();
               if (angle >= 0 && angle <= MAX_ANGLE) {
                  break;
               }
               else {
                  continue;
               }
            }
            else {
               in.next();
               continue;
            }
         }//end while for angle

         while (true) {// receive Gun Powder
            //in.next();
            System.out.print("Please enter an amount of gunpowder "
             + "in kilograms:\n");
            if (in.hasNextDouble()) {//error check
               gunPowder = in.nextDouble();
               if (gunPowder > 0) {
                  break;
               }
               else {
                  continue;
               }
            }
            else {
               in.next();
               continue;
            }
         }//end while for Gun Powder

         finalDistance = physicsHitMiss(angle, gunPowder) - targetDistance;
         if (Math.abs(finalDistance) <= 1) {
            System.out.println("It's a hit!");
            break;
         }
         else if (finalDistance > 1) {
            System.out.println("You were "
             + twoPlaces.format(finalDistance) + "m long.\n");
            continue;
         }
         else {
            System.out.println("You were "
             + twoPlaces.format(Math.abs(finalDistance)) + "m short.\n");
            continue;
         }//end else
      }//end outer while loop
   }//end main

   public static double randomWithSeed(int randomSeed) {
      final double GENERATOR_MULTIPLE = 1000;
      Random gen = new Random(randomSeed);
      return gen.nextDouble() * GENERATOR_MULTIPLE;
   }//end randomWithSeed

   public static double physicsHitMiss(double angle, double powder) {
      final double GRAVITY = 9.8, METERS_PER_SECOND = 50, DIVISIBLE_ANGLE = 180;
      angle *= Math.PI / DIVISIBLE_ANGLE;
      double vy = (powder * METERS_PER_SECOND) * Math.sin(angle);
      double time = 2 * (vy / GRAVITY);
      double distance = time * (powder * METERS_PER_SECOND) * Math.cos(angle);
      return distance;
   }
}//end BombsAway class