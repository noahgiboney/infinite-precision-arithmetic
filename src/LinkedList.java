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
}
