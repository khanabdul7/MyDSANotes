package DataStructures.LinkedList.SinglyLinkedList.Problems;

import DataStructures.LinkedList.SinglyLinkedList.LinkedList;
import DataStructures.LinkedList.SinglyLinkedList.Node;

public class ShiftingNodes {

/** PSEUDO CODE
 * Just Deleting and adding elements n no of times.
 * */
    public static void shiftListLeft(LinkedList ll, int n){
        if(ll == null)
            System.out.println("Given list is empty");
        else{
            for(int i=0; i<n; i++){
                Node temp = ll.getHead();
                ll.delete(ll.getHead().getData()); // Deleting head
                ll.addAtEnd(temp.getData()); // Adding head as tail
            }
            // Calling display method
            ll.display(ll);
        }
    }

    /** PSEUDO CODE
     * Just Deleting and adding elements n no of times.
     * */
    public static void shiftListRight(LinkedList ll, int n){
        if(ll == null)
            System.out.println("Given list is empty");
        else{
            for(int i=0; i<n; i++){
                Node temp = ll.getTail();
                ll.delete(ll.getTail().getData()); // Deleting tail
                ll.addAtBeginning(temp.getData()); // Adding tail as head
            }
            // Calling display method
            ll.display(ll);
        }
    }

    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        linkedList.addAtEnd("ABC");
        linkedList.addAtEnd("DFG");
        linkedList.addAtEnd("XYZ");
        linkedList.addAtEnd("EFG");
        //linkedList.display(linkedList);
        shiftListLeft(linkedList,2);
       // shiftListRight(linkedList,3);
    }
}
