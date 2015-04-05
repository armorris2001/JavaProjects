
package cecs277project2;

public class Circle extends GeometricObject {
   // The radius of the circle member variable
   private double mRadius;

   // Default Constructor
   public Circle(){
      super(); // Calls super constructor
      mRadius = 1.0; // Sets the radius member variable to a default of 1.0
   }

   // Constructor with parameters
   public Circle(double radius, String color, boolean filled ){
      super(color, filled); // Calls super constructor with parameters
      mRadius = radius; // Sets the radius to the parameter
   }

   // Accessor and Mutator for the Radius
   public double getRadius(){return mRadius;}
   public void   setRadius(double radius){
      if (radius >= 0.0)
         mRadius = radius;
      else
         System.out.println("Radius not set. Negative value entered.");
   }

   // getArea()returns the area of a circle ( pi * r^2 )
   public double getArea(){
      return Math.PI * mRadius * mRadius;
   }

   // getPerimeter returns the perimeter ( 2 * pi * r)
   public double getPerimeter(){
      return 2 * Math.PI * mRadius;
   }

   // getDiameter returns double the radius value
   public double getDiameter(){
      return 2 * mRadius;
   }

   // Returns a string with the type of object, the radius, the area
   // and the super class member variables
   @Override public String toString() {
      return "Circle:"
       + "\nradius = " + mRadius
       + "\nArea = " + this.getArea()
       + "\n" + super.toString();
   }
}
