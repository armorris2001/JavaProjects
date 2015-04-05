/*
Name: Adam Morris
Course: CECS 328
Class Name: HashTableNotFoundException
Purpose: This exception throws a message when an element is now found in a 
         hash table.
 */ 

package cecs328_lab3_hashtable;

/**
 *
 * @author Adam
 */
public class HashTableNotFoundException extends Exception {

    public HashTableNotFoundException(){
    }
    
    @Override
    public String toString(){
        return "Key Not Found in Hash Table.";
    }
}

