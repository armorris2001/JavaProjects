/* Adam Morris
     November 18, 2014
     Purpose: This class creates a wordprocessor object to handle a string of 
               text between two stacks
     Inputs: Strings from an outside class giving arguments for word processor
     Output: Strings to screen showing the wordprocessor's functions
*/
package cecs277.stack.word.processor;

import java.util.Stack;

/**
 *
 * @author Adam
 */
public class WordProcessor implements MiniWPI {

    public WordProcessor(){ // default constructor
        System.out.println("WordProcessor Object Created");
    }
    
    public WordProcessor(String s){ // default constructor
        System.out.println("WordProcessor Object Created");
        processCommand(s);
    }
    
    @Override
    /** Is cursor at the start of the text? */
    public boolean isAtStart() {
        //"isAtStart" is command
        if(left.empty()) // if left is empty
           return true; 
        
        return false;      
    }

    @Override
    /** Is cursor at the end of the text? */
    public boolean isAtEnd() {
        //"isAtEnd" is command
        if(right.empty()) // if right is empty
            return true;
        
        return false;
    }

    @Override
    /** Insert c into the string at the cursor. */
    public void insertChar(char c) {
        //"insertChar" is command followed by a prompt to enter the character
        left.push(c); // add a char to end of left
    }

    @Override
    /** Move cursor left 1 character.  If we're already at the
    * start of the string, do nothing. */
    public void moveLeft() {
        //"moveLeft" is command
        if(!left.empty()) // if left is full
            right.add(0, left.pop()); // add the left popped element to right
        
        
    }

    @Override
    /** Move cursor right 1 character.  If we're already at the
    * end of the string, do nothing. */
    public void moveRight() {
        //"moveRight" is command
        if(!right.empty()){ // if right is full
            left.push(right.elementAt(0)); // take right element and put on left
            right.remove(0); // remove first right element
        }
    }

    @Override
    /** Delete character before the cursor.  If there is none, do nothing. */
    public void backspace() {
        //"backspace" is command
        if(!left.empty()){ // if left full
            left.remove(left.size()-1); // remove last element of left
        }
    }

    @Override
    /** Delete character after the cursor.  If there is none, do nothing. */
    public void delete() {
        //"delete" is command
        if(!right.empty()){ // if right full
            right.remove(0); // remove first element to right
        }
    }

    @Override
    /** Move cursor to start of the text. */
    public void moveToStart() {
        //"moveToStart" is command
        if(!left.empty() && right.empty()){ // to type on the left
            for(Character c: left){ // add char to right
                right.push(c);
            }
            left.removeAllElements();
        }
        if(!left.empty() && !right.empty()){ // In the middle of the text
            for(Character c: right){ // add chars to left
                left.push(c);
            }
            
            right.removeAllElements(); // clear right
            
            for(Character c: left){ // add chars to right
                right.push(c);
            }
            
            left.removeAllElements(); // clear left
        }
    }

    @Override
    /** Move cursor to end of the text. */
    public void moveToEnd() {
        //"moveToEnd" is command
        if(left.empty() && !right.empty()){ // to type on the left
            for(Character c: right){
                left.push(c);
            }
            right.removeAllElements(); // clear right
        }
        if(!left.empty() && !right.empty()){ // In the middle of the text
            for(Character c: right){
                left.push(c);
            }
            
            right.removeAllElements(); // clear right
            
        }
    }

    @Override
    /** Convert to string.  The cursor position is ignored.
    * @see toStringCursor */
    public String toString(){
        String s = "";
        if (!left.empty()) { // if left is full
            for(Character leftC: left){
                s += leftC;
            }
        }
        
        if (!right.empty()){ // if right is full
            for(Character rightC: right){
                s += rightC;
            }
        }
        
        return s;
    }
    
    @Override
    /** Like toString, but the special character | is included
    * to mark the cursor position.
    */
    public String toStringCursor() {
        String s = "[";
        
        if (!left.empty() && right.empty()) { //if left is full and right empty
            for(Character leftC: left){
                s += leftC;
            }
            s += "] | [ ]";
        }
        
        else if (!left.empty() && !right.empty()){ //left full and right full
            
            for(Character leftC: left){
                s += leftC;
            }
             
            s += "] | [ ";
                
            for(Character rightC: right){
                s += rightC;
            }
            
            s += " ]";
        }
        
        else if (left.empty() && !right.empty()){ // left empty and right full
            s += " ] | [";
            
            for(Character rightC: right){
                s += rightC;
            }
            s += " ]";
        }
        
        return s; // return the string
    }

    @Override
    /** Search forward for the next occurrence of c that starts at the
    * cursor or later.  If found, leave the cursor immediately after
    * that occurrence and return true.  Else, leave the cursor at the
    * end of the text and return false. */
    public boolean search(char c) {
        if (right.empty()){ // if no letters to right show false
            return false;
        }
        else {
            int indexFromTop = right.search(c);
            System.out.println(" finding: " + c + "index from top: " 
             + indexFromTop);
            //if not found
            if (indexFromTop < 0){
                moveToEnd();
                return false;
            }
            else { // if found
                for(int i = 1; i < right.size() - indexFromTop; i++){
                    moveRight();
                }
                return true;
            }
        }
    }

    @Override
    /** Method that reads in the string that was retrieved from the top of 
    * the Queue and executes the appropriate command. It also calls a method 
    * to print out the command just executed and the resulting stacks */
    public void processCommand(String s) {
        if (s.contains("isAtStart")){ // tells if at start of word
            System.out.println("\nIs at Start: " + isAtStart());
        }
        else if (s.contains("isAtEnd")){ // tells if at end of word
            System.out.println("\nIs at End: " + isAtEnd());
        }
        else if (s.contains("insertChar") || s.contains("ic")){
            if (s.contains("insertChar")) // insert a character
                insertChar(s.charAt(11));
            else
                insertChar(s.charAt(3));
        }
        else if (s.contains("moveLeft") || s.contains("ml")){
            moveLeft(); // move the cursor to left
        }
        else if (s.contains("moveRight") || s.contains("mr")){
            moveRight(); //move the cursor to right
        }
        else if (s.contains("backspace")){ // delete a char to the left
            backspace();
        }
        else if (s.contains("delete")){ // delete a char to the right
            delete();
        }
        else if (s.contains("moveToStart")){ // move cursor to start
            moveToStart();
        }
        else if (s.contains("moveToEnd")){ // move cursor to end
            moveToEnd();
        }
        else if (s.contains("toString")){ // show just the string
            System.out.println(toString());
        }
        else if (s.contains("toStringCursor")){ // show string with cursor
            System.out.println(toStringCursor());
        }
        else if (s.contains("search")){ // show the results of search do search
            System.out.println("Search found: " + search(s.charAt(7)));
        }
        else if (s.contains("menu")){ // print the menu
            System.out.println("\nMenu Options:");
            System.out.println("'insertChar' or 'ic' \t insert a character");
            System.out.println("'isAtStart' \t\t shows if cursor is at start");
            System.out.println("'isAtEnd' \t\t shows if cursor is at the end");
            System.out.println("'moveLeft' or 'ml' \t moves the cursor left");
            System.out.println("'moveRight' or 'mr' \t moves the cursor right");
            System.out.println("'backspace' \t\t deletes character to the "
             + "left");
            System.out.println("'delete' \t\t deletes character to the right");
            System.out.println("'moveToStart' \t\t moves cursor to start");
            System.out.println("'moveToEnd' \t\t moves cursor to end");
            System.out.println("'toString' \t\t shows the current text");
            System.out.println("'search' \t\t finds the char typed and moves"
             + "the cursor, otherwise moves to end");
            System.out.println("'toStringCursor' \t shows text with cursor"
             + " position\n");
            System.out.println("'quit' or 'q' \t\t ends the program\n");
            
        }
        else if (s.contains("quit") || s.contains("q") ){ //quit if entered
            System.exit(0);
        }
        else {
            System.out.println("\nInvalid command. Try Again\n");
        }
        if(!s.contains("menu")) //print the command if not the menu
            printtest(s);
    }

    @Override
    /* Method to print out a command and the results */
    public void printtest(String s) {
        System.out.println("Print Test Command: " + s + " -> " + toStringCursor() );
    }
    
}
