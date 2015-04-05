/*
 * Adam Morris
 * 010858274
 * Lab 5
 */
import java.util.*;

public class Parentheses {

    public static void main(String[] args) {
       String input = "";
       Scanner in = new Scanner(System.in);
       System.out.println("Please enter a string: ");
       input = in.nextLine();

       CharArrayStack c = new CharArrayStack();

       for(int i = 0; i < input.length(); i++){

          if(input.charAt(i) == '(' || input.charAt(i) == '[' ||
           input.charAt(i) == '{'){
            c.push(input.charAt(i));
          }
          else if(input.charAt(i) == ')' || input.charAt(i) == ']'
           || input.charAt(i) == '}'){
             if(c.getCount()==0){//close bracket into empty string
                System.out.println("String not balanced");
                return;
             }else{
                switch(input.charAt(i)){
                   case ')':
                      if(c.pop()!= '('){
                         System.out.println("String not balanced");
                         return;
                      }
                      break;
                   case ']':
                      if(c.pop()!= '['){
                         System.out.println("String not balanced");
                         return;
                      }
                      break;
                   case '}':
                      if(c.pop()!= '{'){
                         System.out.println("String not balanced");
                         return;
                      }
                      break;
                }//end switch
             }//end else
          }//end else if
       }//end for
       if(c.getCount() == 0)
          System.out.println(input + " is balanced.");
    }//end main
}//end Paranthesis

/*
 run:
Please enter a string:
[(hello)]{goodbye}{[(a b)(cd)e](f)g}h
[(hello)]{goodbye}{[(a b)(cd)e](f)g}h is balanced.
BUILD SUCCESSFUL (total time: 3 seconds)

 run:
Please enter a string:
cat[a(b]c)dog
String not balanced
BUILD SUCCESSFUL (total time: 3 seconds)

 */