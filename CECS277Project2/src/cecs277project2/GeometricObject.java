
package cecs277project2;

public class GeometricObject implements Comparable{
  private String color = "white";
  private boolean filled;
  private java.util.Date dateCreated;

 /** Construct a default geometric object */
  public GeometricObject() {
	dateCreated = new java.util.Date();
}

/** Construct a geometric object with the specified color
	*  and filled value */
 public GeometricObject(String color, boolean filled) {
 	dateCreated = new java.util.Date();
	this.color = color;
	this.filled = filled;
   }

/** Return color */
 public String getColor() {
 return color;
   }

/** Set a new color */
 public void setColor(String color) {
 this.color = color;
   }

/** Return filled. Since filled is boolean,
	its get method is named isFilled */
 public boolean isFilled() {
 return filled;
   }

/** Set a new filled */
 public void setFilled(boolean filled) {
 this.filled = filled;
   }

/** Get dateCreated */
 public java.util.Date getDateCreated() {
 return dateCreated;
   }

/** Return a string representation of this object */
 public String toString() {
 return "created on " + dateCreated + "\ncolor: " + color +
 " and filled: " + filled;
   }

 // Checks to see if both objects are of the same type then compare their areas
 public static int max(Object o, Object p){
   if (o instanceof Circle && p instanceof Circle) {
      // Compares the Circle's areas and returns an integer
      return (int) (((Circle) o).getArea() - ((Circle) p).getArea());
   }
   else if (o instanceof Rectangle && p instanceof Rectangle) {
      // Compares the Rectangle's areas and returns an integer
      return (int) (((Rectangle) o).getArea() - ((Rectangle) p).getArea());
   }
   else if (o instanceof Triangle && p instanceof Triangle) {
      // Only executes if the triangles have different side sizes
      // Compares the Triangle's areas and returns an integer
      return (int) (((Triangle) o).getArea() - ((Triangle) p).getArea());
   }
   return 0; // Default return value
 }

   public int compareTo(Object o) {
      // Sends both this object and an outside object to max()
      return max(this, o);
   }
 }