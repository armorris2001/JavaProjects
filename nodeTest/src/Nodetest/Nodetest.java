public class Nodetest {

    private class node{


    }
    public static void main(String[] args) {
        // TODO code application logic here
    }

}
/*
 // Implement a linked list of integers.
public class IntLinkedList {
private class Node {
private int mData;
private Node mNext;
public Node(int data, Node next) {
mData = data;
mNext = next;
}
}
private Node mHead;
public IntLinkedList() {
}
public void add(int itemToAdd) {
// Create a new Node to store the item.
Node newNode = new Node(itemToAdd, null);
// If this is the first item to be added, mHead will be null. Set the
// new node as our head.
if (mHead == null) {
mHead = newNode;
}
else {
// Otherwise, put the new Node at the end of the list and link it in.
Node lastNode = getLastNode();
lastNode.mNext = newNode;
}
}
// Find the last Node in the list by following "mNext" links until finding
// a null link, signifying the end.
private Node getLastNode() {
Node n = mHead;
while (n.mNext != null) {
n = n.mNext;
}
return n;
}
 */