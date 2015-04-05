/* Adam Morris
     November 18, 2014
     Purpose: This class creates an instance of wordProcessor, uses both a
               commmand queue and direct user input to control the functions of 
               the word processor.
     Inputs: inputs strings from the user as instructions for word processor
     Output: only a prompt to enter a command, the rest is handled by the word
              processor object
*/
package cecs277.stack.word.processor;

/**
 *
 * @author Adam
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CECS277StackWordProcessor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Scanner for user input
        Scanner in = new Scanner(System.in);
        
        // Create an instance of WordProcessor
        WordProcessor wp = new WordProcessor("insertChar z");
        
        // Create a command queue for handling instuctions
        Queue<String> cmdq= new LinkedList<>();
        cmdq.add("menu");
        cmdq.add("insertChar a");
        cmdq.add("insertChar b");
        cmdq.add("insertChar c");
        cmdq.add("insertChar d");
        cmdq.add("insertChar e");
        cmdq.add("insertChar f");
        cmdq.add("isAtStart");
        cmdq.add("isAtEnd");
        cmdq.add("moveLeft");
        cmdq.add("moveLeft");
        cmdq.add("moveLeft");
        cmdq.add("moveRight");
        cmdq.add("insertChar g");
        cmdq.add("moveToStart");
        cmdq.add("insertChar h");
        cmdq.add("moveToEnd");
        cmdq.add("insertChar i");
        cmdq.add("toString");
        cmdq.add("moveToStart");
        cmdq.add("isAtStart");
        cmdq.add("search c");
        
        
        // Process the queue for on screen
        while(!cmdq.isEmpty()){
            wp.processCommand(cmdq.poll());
        }
        
        // Take in user input to modify WordProcessor data
        while(true){
            System.out.print("Enter a command: ");
            wp.processCommand(in.nextLine());
        }
    }
}

/* Output
run:
WordProcessor Object Created
Print Test Command: insertChar z -> [z] | [ ]

Menu Options:
'insertChar' or 'ic' 	 insert a character
'isAtStart' 		 shows if cursor is at start
'isAtEnd' 		 shows if cursor is at the end
'moveLeft' or 'ml' 	 moves the cursor left
'moveRight' or 'mr' 	 moves the cursor right
'backspace' 		 deletes character to the left
'delete' 		 deletes character to the right
'moveToStart' 		 moves cursor to start
'moveToEnd' 		 moves cursor to end
'toString' 		 shows the current text
'search' 		 finds the char typed and movesthe cursor, otherwise moves to end
'toStringCursor' 	 shows text with cursor position

'quit' or 'q' 		 ends the program

Print Test Command: insertChar a -> [za] | [ ]
Print Test Command: insertChar b -> [zab] | [ ]
Print Test Command: insertChar c -> [zabc] | [ ]
Print Test Command: insertChar d -> [zabcd] | [ ]
Print Test Command: insertChar e -> [zabcde] | [ ]
Print Test Command: insertChar f -> [zabcdef] | [ ]

Is at Start: false
Print Test Command: isAtStart -> [zabcdef] | [ ]

Is at End: true
Print Test Command: isAtEnd -> [zabcdef] | [ ]
Print Test Command: moveLeft -> [zabcde] | [ f ]
Print Test Command: moveLeft -> [zabcd] | [ ef ]
Print Test Command: moveLeft -> [zabc] | [ def ]
Print Test Command: moveRight -> [zabcd] | [ ef ]
Print Test Command: insertChar g -> [zabcdg] | [ ef ]
Print Test Command: moveToStart -> [ ] | [zabcdgef ]
Print Test Command: insertChar h -> [h] | [ zabcdgef ]
Print Test Command: moveToEnd -> [hzabcdgef] | [ ]
Print Test Command: insertChar i -> [hzabcdgefi] | [ ]
hzabcdgefi
Print Test Command: toString -> [hzabcdgefi] | [ ]
Print Test Command: moveToStart -> [ ] | [hzabcdgefi ]

Is at Start: true
Print Test Command: isAtStart -> [ ] | [hzabcdgefi ]
 finding: cindex from top: 6
Search found: true
Print Test Command: search c -> [hz] | [ abcdgefi ]
Enter a command: moveLeft
Print Test Command: moveLeft -> [h] | [ zabcdgefi ]
Enter a command: moveToStart
Print Test Command: moveToStart -> [ ] | [hzabcdgefi ]
Enter a command: moveToEnd
Print Test Command: moveToEnd -> [hzabcdgefi] | [ ]
Enter a command: INVALID COMMAND

Invalid command. Try Again

Print Test Command: INVALID COMMAND -> [hzabcdgefi] | [ ]
Enter a command: quit
BUILD SUCCESSFUL (total time: 1 minute 7 seconds)
*/