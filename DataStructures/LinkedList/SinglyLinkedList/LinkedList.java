package DataStructures.LinkedList.SinglyLinkedList;

/**
 * THIS CLASS CONTAIN MY OWN IMPLEMENTATION OF LINKED LIST.
 * */
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

    /**
     * DISPLAY BY ACCEPTING A LL
     * */
    public void display(LinkedList ll){
        Node temp = ll.getHead();
        int count = 0;
        while(temp != null){
            count++;
            System.out.println("Node "+count+" : "+temp.getData());
            temp = temp.getNext();
        }
    }

    /** PSEUDO CODE FOR SEARCHING IN LL.
     * Take a TEMP reference & assign it with head node.
     * WHILE (TEMP != null)
     *  a -> IF data at TEMP is equal to searched data then return temp.
     *  b -> ELSE make the next node as temp.
     * IF data not found return null.
     **/
    public Node find(String data){
        Node temp = this.getHead();
        int count = 0;
        while(temp != null){
            count++;
            if(temp.getData().equals(data))
                return temp; // return node if value matches.
            System.out.println("Node "+count+" : "+temp.getData());
            temp = temp.getNext();
        }
        return null; // return null if data not found.
    }

    /*** PSEUDO CODE FOR INSERTION AFTER SPECIFIC NODE.
     * 1. Create a new node with given data.
     * 2. IF ll is empty, then make that new node the head and the tail node.
     * 3. ELSE Find the node with dataBefore. if found then,
     *      a -> call this as the nodeBefore.
     *      b -> make the link of the new node refer to the link of nodeBefore.
     *      c -> make the link of nodeBefore refer to the new node.
     *      d -> If link of the new node is null, make it as the tail node.
     * 4. If node with dataBefore is not found, display appropriate err message.
     */
    public void insertAfterSpecificData(String data, String dataBefore){
        Node node = new Node(data); // Creating new node from data.
        if(this.head == null)  // 2
            this.head=this.tail=node;
        else{
            Node nodeBefore = find(dataBefore); // 3 a
            if(nodeBefore != null){
                node.setNext(nodeBefore.getNext()); // b
                nodeBefore.setNext(node); // c
                if(nodeBefore == this.tail) // If current tail is nodeBefore, then update it as below.
                    this.tail = node;
            }
            else
                System.out.println("nodeBefore not found!");  // d
        }
    }
    /*** PSEUDO CODE FOR DELETING NODE.
     * 1. FIND the node to be deleted. if found
     *   a -> IF node to be deleted is head, make the next node as head.
     *     aa -> if it is also the tail node, make the tail node as null.
     * 2. ELSE traverse till the node before the node to be deleted, call it nodeBefore
     *      a -> make the link of the nodeBefore refer to the link of node to be deleted.
     *      b -> if the node to be deleted is the tail node, call the nodeBefore as tail node.
     *      c -> make the link of the node to be deleted as null.
     * 3. If node to be deleted is not found, display appropriate err message.
     */
    public void delete(String data) {
        if (this.head == null) // Checking if list is empty.
            System.out.println("List is empty");
        else {
            Node result = find(data);
            if (result == null)
                System.out.println("Node to be deleted is not found!");
            else if (result == this.head) { // a
                this.head = result.getNext();
                result.setNext(null);
                if (result == this.tail)  // aa
                    this.tail = null;
            } else {
                // 2
                Node nodeBefore = null;
                Node temp = this.head;
                while (temp != null) {
                    if (temp.getNext() == result) { // if the next node of temp is the one that we want to delete the make the temp as nodeBefore.
                        nodeBefore = temp;
                        break;
                    }
                    temp = temp.getNext();
                }
                nodeBefore.setNext(result.getNext()); // Setting the deleted node's next reference to the nodeBefore.
                if (result == this.tail) // b
                    this.tail = nodeBefore;
                result.setNext(null);
            }
        }
    }

    /** Exercise : To find element with position. */
    public int findPosition(String data){
        if(this.head == null)
            System.out.println("List is empty");
        else{
            Node temp = this.head;
            int pos = 1;
            while(temp != null) {
                if (temp.getData() == data)
                    return pos;
                pos++;
                temp = temp.getNext();
            }
        }
        return 0; // If element not found
    }

    // Testing above implementation.
    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        linkedList.addAtEnd("Germany");
        linkedList.addAtEnd("Australia");
        linkedList.addAtEnd("UK");
        System.out.println("Adding elements to linkedList");
        linkedList.addAtBeginning("India");
        // Calling display
        linkedList.display();
        // Calling Find
        if(linkedList.find("Australia") != null)
            System.out.println("Node Found");

        else
            System.out.println("Node not Found!");
        // Calling insertAfterSpecificNode
        linkedList.insertAfterSpecificData("Indonesia","India");
        // Calling delete
        linkedList.display();
        linkedList.delete("UK");
        linkedList.display();
        // Calling findPosition
//        int pos = linkedList.findPosition("India");
//        if(pos == 0)
//            System.out.println("Element not found!");
//        else
//            System.out.println("Element found at position: "+pos);
    }
}
