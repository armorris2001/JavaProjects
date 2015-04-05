/* Adam Morris
     September 09, 2014
     Project: Lab for Chapter 10 Class that implements Speakable
     Purpose: This program shows implementation of an interface in an ArrayList
     Inputs:  none
     Output:  Each class prints the speak() method depending on it's class
              implementation
*/
package cecs277labch10;

public class Dog implements Speakable {
   private String name;

   public Dog(String name){
      this.name = name;
   }

   public void speak(){
      System.out.println("Woof! Woof!");
   }

   @Override public String toString(){
      return "Dog: " + name;
   }
}
