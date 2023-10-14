import java.util.Objects;

public class Multiplication extends Operation {

    public Multiplication(String x, String y) {
        super(x, y);
    }
    public Multiplication(){}

    @Override
    public LinkedList doOperation(LinkedList listX, LinkedList listY) {
        LinkedList resultList = new LinkedList();

        //if either of lists are zero just return zero
        if (Objects.equals(listX.toString(), "0") || Objects.equals(listY.toString(), "0")) {
            resultList.insertNode(0);
            return resultList;
        }

        int zeroCounter = 0; //tracker for how many zeros to insert to list

        //iterate through listY using a node
        LinkedList.Node tempY = listY.getHead();
        while (tempY != null) {
            LinkedList current = new LinkedList(); //store result of current multiplication in a new list
            LinkedList.Node tempX = listX.getHead();
            int carry = 0;

            //iterate through listX using a node
            while (tempX != null) {
                int result = (tempY.getValue() * tempX.getValue()) + carry; //store result plus carry
                carry = result / 10;
                current.insertTail(result % 10); //insert ones digit
                tempX = tempX.getNext();
            }

            //if there is carry then insert
            if (carry > 0) {
                current.insertTail(carry);
            }

            //add zeros to list based on tracker
            for (int i = 0; i < zeroCounter; i++) {
                current.insertNode(0);
            }

            //add current list to result list
            if (resultList.getHead() == null) {
                resultList = current;
                if(tempY.getNext() == null){
                    resultList.reverse();
                }
            } else {
                if(zeroCounter > 1){
                    resultList.reverse();
                }
                Addition add = new Addition();
                resultList = add.doOperation(resultList, current);
            }

            tempY = tempY.getNext(); //move listY to the next node
            zeroCounter++;
        }
        return resultList;
    }
}