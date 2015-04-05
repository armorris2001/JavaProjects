
package cecs277project2;

public class Rectangle extends GeometricObject {
   public double mWidth;  // Width of the Rectangle
   public double mHeight; // Height of the Rectangle

   // Default Constructor
   public Rectangle(){
      super(); // Calls super constructor
      this.mWidth  = 1.0; // Sets the width to a default value of 1.0
      this.mHeight = 1.0; // Sets the height to a default value of 1.0
   }

   // Constructor with parameters
   public Rectangle(double width, double height, String color, boolean filled ){
      super(color, filled);  // Calls super constructor with parameters
      this.mWidth = width;   // Sets the width to the parameter's value
      this.mHeight = height; // Sets the height to the parameter's value
   }

   // Accessor and Mutator for the mWidth member variable
   public double getWidth(){return mWidth;}
   public void   setWidth(double width){
      if (width >= 0.0)
         mWidth = width;
      else
         System.out.println("Width not set. Negative value entered.");
   }

   // Accessor and Mutator for the mHeight member variable
   public double getHeight(){return mHeight;}
   public void   setHeight(double height){
      if (height >= 0.0)
         mHeight = height;
      else
         System.out.println("Height not set. Negative value entered.");
   }

   // getArea calculates the area of a rectangle by taking width times height
   public double getArea(){
      return mWidth * mHeight;
   }

   // getPerimeter calculates the perimeter of a rectangle by multiplying
   // the sum of the width and the height by 2 (width + width + height + height)
   public double getPerimeter(){
      return 2 * (mWidth + mHeight);
   }

   // Returns a String with the type of object, it's width, height, area
   // and super class member variables
   @Override public String toString() {
      return "Rectangle:"
       + "\nwidth = "  + mWidth
       + "\nheight = " + mHeight
       + "\narea = " + this.getArea()
       + "\n" + super.toString();
   }
}
