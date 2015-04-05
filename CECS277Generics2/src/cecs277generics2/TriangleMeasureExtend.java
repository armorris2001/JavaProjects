/* Adam Morris
     September 16, 2014
     Purpose: This class creates a TriangleMeasureExtend object and implements 
               the abstract method of getMeasure() from the Measurable 
               abstract class.
     Inputs: doubles for height and base of a triangle
     Output: The toString() displays the Triangle object & its base and height
*/
package cecs277generics2;

/**
 *
 * @author Adam
 */
public class TriangleMeasureExtend extends Measurable{

    //Member variables for height and base of the triangle
    private double mheight;
    private double mbase;
    
    //Default Constructor setting a TriangleMeasureExtend object of 0,0
    public TriangleMeasureExtend(){
        mheight = 0.0;
        mbase = 0.0;
    }
    
    //Constructor taking height and base as arguments
    public TriangleMeasureExtend(double height, double base){
        //Sets the member variables to the method arguments
        mheight = height;
        mbase = base;
    }
    
    //Overriding the abstract method from the Measurable class
    @Override
    public double getMeasure() {
        return (.5 * mbase) * mheight; //Return area of a triangle
    }
    
    //Overriding the toString() method to display the type of object and its
    // member veriables
    @Override
    public String toString(){
        return "Triangle Object \nbase: " + mbase + "\nheight: " + mheight;
    }
}
