import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestCases {
    @Test
    public void testLinkedList() {
        LinkedList list = new LinkedList();
        list.insertNode(1);
        list.insertNode(2);
        list.insertNode(3);
        list.insertNode(4);
        list.insertNode(4);
        list.insertNode(7);

        assertEquals("744321", list.toString());
    }
}

