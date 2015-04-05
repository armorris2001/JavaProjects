/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cecs274_lab_queues;


import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Adam
 */
public class CECS274_lab_Queues {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //create a queue of a linked list
        Queue<String> iPhoneBuyers = new LinkedList<String>();
        
        //fill the queue
        for(int i = 1; i <= 100; i++){
            iPhoneBuyers.add("name #" + i);
        }
        
        //get the queue size
        System.out.println("que size: " + iPhoneBuyers.size());
        
        //see who is in front
        System.out.println("First person: " + iPhoneBuyers.peek() + "\n\n");
        
        //sell a phone
        for(int i = 1; i <= 100; i++){
            if(iPhoneBuyers.peek() != null)
                System.out.println("Phone sold to: " + iPhoneBuyers.remove());
        }
        
    }
    
}
