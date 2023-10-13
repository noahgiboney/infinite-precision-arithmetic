import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestCases {

    @Test
    public void testIsValidLine1(){
        assertFalse(FileProcessor.isValidLine("5 + 5 + 5 + 5 dsa+ 5fdsa"));
        assertTrue(FileProcessor.isValidLine("5 + 3"));
        assertTrue(FileProcessor.isValidLine("500 ^ 003"));
        assertTrue(FileProcessor.isValidLine("112500 * 300"));
    }

    @Test
    public void testIsValidOperand(){
        assertFalse(FileProcessor.isValidOperand("00003333hhh-"));
        assertTrue(FileProcessor.isValidOperand("500000"));
        assertTrue(FileProcessor.isValidOperand("00000001"));
    }

    @Test
    public void testIsValidOperator(){
        assertFalse(FileProcessor.isValidOperator("%"));
        assertTrue(FileProcessor.isValidOperator("^"));
        assertTrue(FileProcessor.isValidOperator("+"));
        assertTrue(FileProcessor.isValidOperator("*"));
    }

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

    @Test
    public void testDoAddition(){
        Addition add = new Addition("00009999993","00000000077123");
        String result = "10077116";
        LinkedList test = add.doOperation(add.fillList(add.getX()), add.fillList(add.getY()));

        assertEquals(result,test.toString());
    }
}

