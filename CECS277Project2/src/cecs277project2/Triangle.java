
package cecs277project2;

public class Triangle extends GeometricObject {
   // The three sides of the triangle
   public double mSide1;
   public double mSide2;
   public double mSide3;

   // Default Constructor setting all sides to 1.0 and calling the default
   // super class Constructor
   public Triangle(){
      super(); // Calls super constructor
      this.mSide1 = 1.0;
      this.mSide2 = 1.0;
      this.mSide3 = 1.0;
   }

   // Constructor with parameters
   public Triangle(double side1, double side2, double side3, String color,
    boolean filled ){
      super(color, filled); // Calls super constructor with parameters
      this.mSide1 = side1;  // Sets the side 1 member variable to the parameter
      this.mSide2 = side2;  // Sets the side 2 member variable to the parameter
      this.mSide3 = side3;  // Sets the side 3 member variable to the parameter
   }

   // Accessor and Mutator for Side 1
   public double getSide1(){return mSide1;}
   public void   setSide1(double side1){
      if (side1 >= 0.0)
         mSide1 = side1;
      else
         System.out.println("Side 1 not set. Negative value entered.");
   }

   // Accessor and Mutator for Side 2
   public double getSide2(){return mSide2;}
   public void   setSide2(double side2){
      if (side2 >= 0.0)
         mSide2 = side2;
      else
         System.out.println("Side 2 not set. Negative value entered.");
   }

   // Accessor and Mutator for Side 3
   public double getSide3(){return mSide3;}
   public void   setSide3(double side3){
      if (side3 >= 0.0)
         mSide3 = side3;
      else
         System.out.println("Side 3 not set. Negative value entered.");
   }

   // getArea() method returns the square root of 1/2 the perimeter
   // times the quantity of 1/2 the perimeter minus each side respectively
   public double getArea(){
      double s = 0.5 * getPerimeter(); // 1/2 the total perimeter size
      return Math.sqrt(s * (s - mSide1) * (s - mSide2) *(s - mSide3));
   }

   // getPerimeter() returns the summation of the 3 sides
   public double getPerimeter(){
      return mSide1 + mSide2 + mSide3;
   }

   // Returns a string of the type of object, the three sides, the area
   // and the super class member variables
   @Override public String toString() {
      return "Triangle:"
       + "\nside 1 = " + mSide1
       + "\nside 2 = " + mSide2
       + "\nside 3 = " + mSide3
       + "\narea = " + this.getArea()
       + "\n" + super.toString();
   }
}
