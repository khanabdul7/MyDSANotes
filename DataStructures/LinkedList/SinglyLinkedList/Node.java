package DataStructures.LinkedList.SinglyLinkedList;

//Node class, having data as String.
public class Node {
    String data;
    Node next;

    //Constructor, next will implicitly initialize to null.
    Node (String data){
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
