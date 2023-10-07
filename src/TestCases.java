import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestCases {
    @Test
    public void testLinkedList() {
        LinkedList testList = new LinkedList();
        testList.insertNode(1);
        testList.insertNode(2);
        testList.insertNode(3);
        testList.insertNode(4);
        testList.insertNode(4);
        testList.insertNode(7);

        assertEquals("744321", testList.toString());
    }
}

