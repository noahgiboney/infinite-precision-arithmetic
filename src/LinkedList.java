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

    public LinkedList insert(LinkedList list, int value){
        Node newNode = new Node(value);  //new node to insert

        //first check is linked-list is empty, if so then make the head of list the node just created
        if(list.head == null){
            list.head = newNode;
            return list;
        }
        else {
            Node temp = list.head;
            while(temp.next != null){ //iterate through the list until next points to null
                temp = temp.next;  //temp to the next location in the list
            }
            temp.next = newNode;  //at the end of the list insert our node
        }
        return list;
    }

    public LinkedList remove(LinkedList list, int value){

        //find previous node of the node to be deleted
        //change the next of the previous node
        //free memory
        Node temp = list.head;
        Node previous = null;

        if(temp != null && temp.value == value){ //if head ahs the value to delete assign next node as the head
            list.head = temp.next;
            return list;
        }

        while(temp != null && temp.value != value){
            previous = temp;
            temp = temp.next;
        }
        if(temp == null){
            return list;
        }

        previous.next = temp.next;
        return list;
    }

    public String toString(){

        return null;
    }
}
