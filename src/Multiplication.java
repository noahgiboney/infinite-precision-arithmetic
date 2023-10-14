import java.util.Objects;

public class Multiplication extends Operation {

    public Multiplication(String x, String y) {
        super(x, y);
    }

    @Override
    public LinkedList doOperation(LinkedList listX, LinkedList listY) {
        LinkedList resultList = new LinkedList();

        if (Objects.equals(listX.toString(), "0") || Objects.equals(listY.toString(), "0")) {
            resultList.insertNode(0);
            return resultList;
        }

        int zeroCounter = 0;

        LinkedList.Node iterY = listY.getHead();
        while (iterY != null) {
            LinkedList temp = new LinkedList();
            LinkedList.Node iterX = listX.getHead();
            int carry = 0;

            while (iterX != null) {
                int result = (iterY.getValue() * iterX.getValue()) + carry;
                carry = result / 10;
                temp.insertTail(result % 10);
                iterX = iterX.getNext();
            }

            if (carry > 0) {
                temp.insertTail(carry);
            }

            for (int i = 0; i < zeroCounter; i++) {
                temp.insertNode(0);
            }

            if (resultList.getHead() == null) {
                resultList = temp;
                if(iterY.getNext() == null){
                    resultList.reverseList();
                }
            } else {
                if(zeroCounter > 1){
                    resultList.reverseList();
                }
                Addition add = new Addition();
                resultList = add.doOperation(resultList, temp);
            }

            iterY = iterY.getNext();
            zeroCounter++;
        }
        return resultList;
    }
}