public class LinkedList {
    static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        public void carry(int value){
            this.value += value;
        }

        public Node getNext() {
            return next;
        }

        public int getValue() {
            return value;
        }
    }
    private Node head;

    public void insertNode(int value) {
        Node newNode = new Node(value); // node to insert

        newNode.next = head; //link new node to the current head

        this.head = newNode; //make the new node the head of list
    }

    public void insertTail(int value) {
        Node newNode = new Node(value);

        if (this.head == null) {
            this.head = newNode;
        } else {
            Node temp = this.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void removeHead() {
        if (head != null) {
            this.head = head.next;
        }
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
}



