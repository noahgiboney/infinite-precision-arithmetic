public class LinkedList {
    static class Node{
        public int value;
        public Node next;
        public Node(int value){
            this.value = value;
            this.next = null;
        }
    }
    public Node head;

    public void insert(int value){
        Node newNode = new Node(value);  //new node to insert

        //first check is linked-list is empty, if so then make the head of list the node just created
        if(this.head == null){
            this.head = newNode;
        }
        else {
            Node temp = this.head;
            while(temp.next != null){ //iterate through the list until next points to null
                temp = temp.next;  //temp to the next location in the list
            }
            temp.next = newNode;  //at the end of the list insert our node
        }
    }

    public void remove( int key){

        //find previous node of the node to be deleted
        //change the next of the previous node
        //free memory
        Node temp = this.head;
        Node previous = null;

        if(temp != null && temp.value == key){ //if head has the key to delete assign next node as the head
            this.head = temp.next;
        }
        while(temp != null && temp.value != key){
            previous = temp;
            temp = temp.next;
        }
        if(temp == null){
        }
        previous.next = temp.next;
    }

    public int length(LinkedList list){
        Node temp = list.head;
        int counter = 0;

        while (temp != null){
            temp = temp.next;
            counter++;
        }
        return counter;
    }

    public void printList(LinkedList list) {
        Node temp = list.head;
        while (temp != null) {
            System.out.print(temp.value);
            temp = temp.next;
        }
    }

    public void reverseList(){
        Node previous = null;
        Node temp = this.head;

        while(temp != null){
            Node next = temp.next;
            temp.next = previous;
            previous = temp;
            temp = next;
        }
        this.head = previous;
    }
}
