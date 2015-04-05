/* Adam Morris
     September 09, 2014
     Project: Lab for Chapter 10
     Purpose: This program shows implementation of an interface in an ArrayList
     Inputs:  none
     Output:  Each class prints the speak() method depending on it's class
              implementation
*/
package cecs277labch10;

import java.util.ArrayList;
public class AnimalRunner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Original Code
       //ArrayList<Dog> dogcatList = new ArrayList<Dog>();
       //dogcatList.add(new Dog("Fred"));
       // dogcatList.add(new Cat("Wanda"));

       //Code after implementing Speakable
       ArrayList<Speakable> dogcatList = new ArrayList<Speakable>();
       dogcatList.add(new Dog("Fred"));
       dogcatList.add(new Cat("Wanda"));

       for (Speakable obj : dogcatList){
         obj.speak();
       }
    }

}

/*Output:

run:
Woof! Woof!
Meow! Meow!
BUILD SUCCESSFUL (total time: 0 seconds)

 */