public class Multiplication extends Operation {

    public Multiplication(String x, String y) {
        super(x, y);
    }

    @Override
    public LinkedList doOperation(LinkedList listX, LinkedList listY) {
        LinkedList resultList = new LinkedList();
        int zeroCounter = 0;

        LinkedList.Node iterY = listY.getHead();
        while (iterY != null) {
            LinkedList temp = new LinkedList();
            LinkedList.Node iterX = listX.getHead();
            int carry = 0;

            // Multiply and add each digit
            while (iterX != null) {
                int result = (iterY.getValue() * iterX.getValue()) + carry;
                carry = result / 10;
                temp.insertTail(result % 10);
                iterX = iterX.getNext();
            }

            // Add remaining carry
            if (carry > 0) {
                temp.insertTail(carry);
            }

            // Add zeros for each position after the first
            for (int i = 0; i < zeroCounter; i++) {
                temp.insertNode(0);
            }

            // Add the calculated line to the total result
            if (resultList.getHead() == null) {
                resultList = temp;
                if(iterY.getNext() == null){
                    resultList.reverseList();
                }
            } else {
                Addition add = new Addition();
                resultList = add.doOperation(resultList, temp);
            }

            // Move to next digit in Y
            iterY = iterY.getNext();
            zeroCounter++;
        }
        return resultList;
    }
}