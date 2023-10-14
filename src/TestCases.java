import org.junit.jupiter.api.Test;

import java.util.List;

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
    public void testDoAddition1(){
        Addition add = new Addition("51","00000000077123");
        String result = "77174";
        LinkedList test = add.doOperation(add.fillList(add.getX()), add.fillList(add.getY()));
        assertEquals(result,test.toString());
    }

    @Test
    public void testMultiplciation(){
        Multiplication mul = new Multiplication("00067561","0000041235235");
            String result = "2785893711835";
            LinkedList test = mul.doOperation(mul.fillList(mul.getX()),mul.fillList(mul.getY()));
            assertEquals(result, test.toString());
        }
    }


