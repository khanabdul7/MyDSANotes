package DataStructures.LinkedList.SinglyLinkedList;

public class LinkedList {
    private Node head;
    private Node tail;

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    /** PSEUDO CODE FOR ADDING A NEW NODE AT END OF LL.
     * Create new node with given data.
     * IF ll is empty, then make that new node the head and the tail node.
     * ELSE, a -> make the link of the tail node refer to new node.
     *       b -> make the tail refer to new node.
     **/
    public void addAtEnd(String data){
        Node node = new Node(data);
        // Checking if ll is empty, if yes make head and tail to new node.
        if(this.head == null)
            this.head=this.tail=node;
        // else add element at end and make new node as tail.
        else {
            this.tail.setNext(node);
            this.tail=node;
        }
        // System.out.println("Head: "+this.getHead().getData());
        // System.out.println("Tail: "+this.getTail().getData());
    }

    /** PSEUDO CODE FOR ADDING A NEW NODE AT BEGINNING OF LL.
     * Create new node with given data.
     * IF ll is empty, then make that new node the head and the tail node.
     * ELSE, a -> make new node's link to current head of ll.
     *       b -> make new node as head of ll.
     **/
    public void addAtBeginning(String data){
        Node node = new Node(data);
        // Checking if ll is empty, if yes make head and tail to new node.
        if(this.head == null)
            this.head=this.tail=node;
            // else add element at beginning, by making new node's link to head then make new node as head.
        else {
            node.setNext(this.getHead());
            this.head=node;
        }
//         System.out.println("After adding node at beginning: ");
//         System.out.println("Head: "+this.getHead().getData());
//         System.out.println("Tail: "+this.getTail().getData());
    }

    /** PSEUDO CODE FOR DISPLAY CONTENTS OF LL
     * Take a TEMP reference & assign it with head node.
     * WHILE (TEMP != null)
     *  a -> Display data of temp node.
     *  b -> make the next node as temp.
     **/
    public void display(){
        Node temp = this.getHead();
        int count = 0;
        while(temp != null){
            count++;
            System.out.println("Node "+count+" : "+temp.getData());
            temp = temp.getNext();
        }
    }

    // Testing above implementation.
    public static void main(String[] args){
        LinkedList linkedList =new LinkedList();
        linkedList.addAtEnd("Germany");
        linkedList.addAtEnd("Australia");
        linkedList.addAtEnd("UK");
        System.out.println("Adding elements to linkedList");
        linkedList.addAtBeginning("India");
        // Calling display
        linkedList.display();
    }
}
