/* Adam Morris
     September 18, 2014
     Purpose: This program implements Inheritance, Comparators, and Polymorphism
     Inputs:  none
     Output:  Program displays each of the object's toString functions,
              compares the two similar objects, then reports the result.
*/
package cecs277project2;

public class Main {

    public static void main(String[] args) {

       // Instantiation of 2 circles, 2 rectangles and 2 triangles
       Circle circle1  = new Circle(1.0, "Blue", true);
       Circle circle2  = new Circle(3.0, "Red", true);
       Rectangle rect1 = new Rectangle(12.5, 23.0, "Green", false);
       Rectangle rect2 = new Rectangle(2.5, 3.0, "Yellow", false);
       Triangle tri1   = new Triangle(1.5, 1.5, 2, "Brown", true);
       Triangle tri2   = new Triangle(1.5, 1.5, 2, "Brown", true);

       // Display and Check of Circle comparison
       System.out.println("\nCircle 1 : \n" + circle1 + "\n");
       System.out.println("Circle 2 : \n" + circle2);

       // Find and Store the comparison of circle1 to circle 2
       int compareValue = circle1.compareTo(circle2);

       // Display Circle Comparison
       if(compareValue < 0)
         System.out.println("\n\n\tCircle 1 is Less Than Circle 2");
       else if (compareValue == 0)
          System.out.println("\n\n\tCircle 1 is Equal To Circle 2");
       else if (compareValue > 0)
          System.out.println("\n\n\tCircle 1 is Greater Than Circle 2");


       // Display and Check of Rectangle comparison
       System.out.println("\nRectangle 1 : \n" + rect1 + "\n");
       System.out.println("Rectangle 2 : \n" + rect2);

       // Find and Store the comparison of rectangle1 to rectangle 2
       compareValue = rect1.compareTo(rect2);

       // Display Rectangle Comparison
       if(compareValue < 0)
         System.out.println("\n\n\tRectangle 1 is Less Than Rectangle 2");
       else if (compareValue == 0)
          System.out.println("\n\n\tRectangle 1 is Equal To Rectangle 2");
       else if (compareValue > 0)
          System.out.println("\n\n\tRectangle 1 is Greater Than Rectangle 2");


       // Display and Check of Triangle comparison
       System.out.println("\nTriangle 1 : \n" + tri1 + "\n");
       System.out.println("Triangle 2 : \n" + tri2);

       // Check for Triangle sides to be the same
       double side1 = tri1.getSide1() - tri2.getSide1();
       double side2 = tri1.getSide2() - tri2.getSide2();
       double side3 = tri1.getSide3() - tri2.getSide3();

       // Display Triangle Comparison
       if (side1 == 0 && side2 == 0 && side3 == 0)
          System.out.println("\n\n\tThe Triangles are the same size");
       else{
          System.out.println("\tThe Triangles are not the same size");
          compareValue = tri1.compareTo(tri2);
          if (compareValue > 0)
             System.out.println("\tTriangle 1 is Less Than Triangle 2");
          else
             System.out.println("\tTriangle 1 is Greater Than Triangle 2");
       }
    }
}
