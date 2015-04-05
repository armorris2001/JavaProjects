/*
 * Adam Morris
 * 010858274
 * Lab 2
 */
import java.util.*;
import java.text.*;
public class SineMe {

    public static void main(String[] args) {
      double angle;
      double convertedAngle = 0.0;
      Scanner in = new Scanner(System.in);
      System.out.println("Please enter an angle:");
      // takes in the number
      angle = in.nextDouble();
      // stored the number in a second variable for conversion
      convertedAngle = angle;
      // converts Degrees to Radians
      convertedAngle *= Math.PI / 180;
      // actions the sine of the angle in Radians
      convertedAngle = Math.sin(convertedAngle);

      DecimalFormat threePlaces = new DecimalFormat ("#.###");
         System.out.println("The sine of " + threePlaces.format(angle) + " is " +
          threePlaces.format(convertedAngle));
    }
}
