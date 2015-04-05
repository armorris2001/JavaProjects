/*
Name: Adam Morris
Course: CECS 328
Class Name: HashTable
Purpose: Contains the methods and private classes for implementing a Hash Table.
 */ 
package cecs328_lab3_hashtable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adam
 */
public class HashTable {

    // Private node class for storing the key and value of the Hash Table
    private class Node {

        Node next;
        Object key;
        Object value;

        // Constructor
        private Node(Object key, Object value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        // Key accessor
        private Object getKey() {
            return this.key;
        }
        
        @Override
        public String toString(){
            if (next != null){
                return "Key: " + key + " Value: " + value + ";; " 
                 + next.toString();
            }
            return "Key: " + key + " Value: " + value;
        }
    }

    // Array for holding the singly linked list of nodes.
    // It contains the head of each table list. Each head will 
    // be the getHash hashCode location
    private Node mTable[]; 
    
    // Placeholder to keep track of the elements
    private int mCount = 0;
    
    // Constructor for the Hash Table
    public HashTable(int size) {
        mTable = new Node[size];
    }

    private int getHash(Object key) {
        // Return the Hash Code.
        return Math.abs(key.hashCode()) % mTable.length; 
    }

    public void insert(Object key, Object value) {
        // Create a new node for holding the insertable data
        Node newNode = new Node(key, value, null);
        
        // Get the hash code to know where to place the node in the Array
        int hashCode = getHash(newNode.key);
        
        // IF there is no element at this index position, insert one.
        if (mTable[hashCode] == null) {
            mTable[hashCode] = newNode;
            mCount++;
        } else {
            // Otherwise, put the new node at the end of the list and link it.
            
            // Take the first element at the hash code and  copy to n.
            Node n = mTable[hashCode];
            
            // Walk through the singly linked list until the end.
            while (n != null) {
                // If the key is found, replace the value with the new value.
                if (n.key.equals(key)) {
                    n.value = value;
                    break;
                } else {
                    // Else update the node to the next node to walk the list.
                    n = n.next; 
                }
            }
            if( n == null){
                // Swap in the new node for the first element in the list with 
                // the same hash code
                newNode.next = mTable[hashCode]; 
                mTable[hashCode] = newNode;
                mCount++;
            }
        }
        // This is a check for debugging that prints out the elemnts.
        // System.out.println(Arrays.toString(mTable));
    }

    public void remove(Object keyToRemove) {
        
        // Get the hashcode value for array position to walk through.
        int hashCode = getHash(keyToRemove);
        
        // if the index of the array is empty, then do nothing.
        if (mTable[hashCode] == null) {
            //System.out.println("DEBUG Nothing there");
        } else {
            // Otherwise, create two new nodes to walk through the linked list.
            Node n = mTable[hashCode];
            Node n2 = n;
            
            // Keep checking all elements of the linked list until the end.
            while (n != null) {
                // If the key is found, then link around the removed node.
                if (n.key.equals(keyToRemove)) {
                    if(n == n2){
                        mTable[hashCode] = n.next; // removes the head.
                    }
                    else{
                        // Wraps the node around the removed node.
                        n2.next = n.next; 
                        mCount--;
                    }
                    break;
                } else {
                    // Iterates through the list.
                    n2 = n;
                    n = n.next; 
                }
                
            }
   
        }
    }

    public Object find(Object keyToFind) throws HashTableNotFoundException {
        int hashCode = getHash(keyToFind);
        
        if (mTable[hashCode] == null) {
            throw new HashTableNotFoundException();
        } else {
            Node n = mTable[hashCode];
            while (n != null) {
                if (n.key.equals(keyToFind)) {
                    
                        return n.value;
                    
                } else {
                    // updates the node.
                    n = n.next; 
                }
                
            }
            
        }
        throw new HashTableNotFoundException();
    }

    public boolean containsKey(Object keyToFind) {
        // Get the size of the array of nodes
        int i = mTable.length-1;
        
        while ( i != 0){
            if (mTable[i] != null) {
                // Goes through the first index of the table and then walks it.
                Node n = mTable[i];
                while (n != null) {
                    if(n.key.equals(keyToFind))
                        return true;
                    // If not found, then update node.
                    n = n.next;
                }
            }
            i--;
        }
        // If the node is not found return false.
        return false;
    }

    public int count() {
        return mCount;
    }

    public List keySet() { 
        //These keys will come in backwards, but there's no order in Hash Table.
        // Use an ArrayList to show all the keys.
        ArrayList<Object> aList = new ArrayList<Object>();
        
        int i = mTable.length-1;
        
        while ( i != 0){
            if (mTable[i] != null) {
                
                // Start at the beginning of index and walk the nodes.
                Node n = mTable[i];
                while (n != null) {
                    // Add the nodes to the list.
                    aList.add(n.key);  
                    n = n.next; // Updates the node position.
                }
            }
            i--;
        }
        return aList;
    }

    @Override
    public String toString() {
        String temp = null;
        for (Object o : mTable) {
            temp += "\n" + o; 
        }

        return temp;
    }
}
