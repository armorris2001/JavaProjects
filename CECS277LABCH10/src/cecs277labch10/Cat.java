/* Adam Morris
     September 09, 2014
     Project: Lab for Chapter 10 Cat class implementing Speakable
     Purpose: This program shows implementation of an interface in an ArrayList
     Inputs:  none
     Output:  Each class prints the speak() method depending on it's class
              implementation
*/
package cecs277labch10;

public class Cat implements Speakable {
   private String name;
   
   public Cat(String name){
      this.name = name;
   }
   
   public void speak(){
      System.out.println("Meow! Meow!");
   }
   
   @Override public String toString(){
      return "Cat: " + name;
   }
}
