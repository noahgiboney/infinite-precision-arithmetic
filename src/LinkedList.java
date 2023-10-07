public class LinkedList {
    static class Node{
        private int value;
        private Node next;
        public Node(int value){
            this.value = value;
            this.next = null;
        }
    }
    private Node head;

    public void insertNode(int value){
        Node newNode = new Node(value); // node to insert

        newNode.next = head; //link new node to the current head

        this.head = newNode; //make the new node the head of list
    }

    public String toString() {
        StringBuilder list = new StringBuilder();
        Node temp = this.head;
        while (temp != null) {
            list.append(temp.value);
            temp = temp.next;
        }
        return list.toString();
    }

    public Node getHead() {
        return head;
    }

    //    public void reverseList(){
//        Node previous = null;
//        Node temp = this.head;
//
//        while(temp != null){
//            Node next = temp.next;
//            temp.next = previous;
//            previous = temp;
//            temp = next;
//        }
//        this.head = previous;
//    }

//    public int length(LinkedList list){
//        Node temp = list.head;
//        int counter = 0;
//
//        while (temp != null){
//            temp = temp.next;
//            counter++;
//        }
//        return counter;
//    }
}
