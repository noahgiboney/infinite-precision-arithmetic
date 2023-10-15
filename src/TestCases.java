import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TestCases {

    @Test
    public void testIsValidOperand() {
        assertFalse(FileProcessor.isValidOperand("00003333hhh-"));
        assertTrue(FileProcessor.isValidOperand("500000"));
        assertTrue(FileProcessor.isValidOperand("0000000"));
    }

    @Test
    public void testIsValidOperator() {
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
    public void testDoAddition1() {
        Addition add = new Addition("51", "00000000077123");
        String result = "77174";
        LinkedList test = add.doOperation(add.fillList(add.getX()), add.fillList(add.getY()));
        assertEquals(result, test.toString());
    }

    @Test
    public void testDoAddition2() {
        Addition add = new Addition("0", "00000000077123");
        String result = "77123";
        LinkedList test = add.doOperation(add.fillList(add.getX()), add.fillList(add.getY()));
        assertEquals(result, test.toString());
    }

    @Test
    public void testDoAddition3() {
        Addition add = new Addition("0", "0");
        String result = "0";
        LinkedList test = add.doOperation(add.fillList(add.getX()), add.fillList(add.getY()));
        assertEquals(result, test.toString());
    }

    @Test
    public void testDoAddition4() {
        Addition add = new Addition("505543243252345342534252345342532453425", "0578439025784392075893420758920347589023748593");
        String result = "578439531327635328238763293172692931556202018";
        LinkedList test = add.doOperation(add.fillList(add.getX()), add.fillList(add.getY()));
        assertEquals(result, test.toString());
    }

    @Test
    public void testMultiplication1() {
        Multiplication mul = new Multiplication("00067561", "0000041235235");
        String result = "2785893711835";
        LinkedList test = mul.doOperation(mul.fillList(mul.getX()), mul.fillList(mul.getY()));
        assertEquals(result, test.toString());
    }


    @Test
    public void testMultiplication2() {
        Multiplication mul = new Multiplication("0", "50");
        String result = "0";
        LinkedList test = mul.doOperation(mul.fillList(mul.getX()), mul.fillList(mul.getY()));
        assertEquals(result, test.toString());
    }

    @Test
    public void testMultiplication3() {
        Multiplication mul = new Multiplication("0", "0");
        String result = "0";
        LinkedList test = mul.doOperation(mul.fillList(mul.getX()), mul.fillList(mul.getY()));
        assertEquals(result, test.toString());
    }

    @Test
    public void testExponential1(){
        Exponential exp = new Exponential("64", "0");
        String result = "1";
        LinkedList test = exp.doOperation(exp.fillList(exp.getX()), exp.fillList(exp.getY()));
        assertEquals(result, test.toString());
    }

    @Test
    public void testExponential2(){
        Exponential exp = new Exponential("644", "30");
        String result = "1847464154765782832947034301721585703011476221186478059011220461413625389277329227776";
        LinkedList test = exp.doOperation(exp.fillList(exp.getX()), exp.fillList(exp.getY()));
        assertEquals(result, test.toString());
    }

    @Test
    public void testExponential3(){
        Exponential exp = new Exponential("600", "50");
        String result = "8082812774647640606431396004565362933760000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        LinkedList test = exp.doOperation(exp.fillList(exp.getX()), exp.fillList(exp.getY()));
        assertEquals(result, test.toString());
    }
}



