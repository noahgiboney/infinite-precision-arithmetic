public class Multiplication extends Operation{

    public Multiplication(String x, String y){
        super(x,y);
    }

    @Override
    public LinkedList doOperation(LinkedList listX, LinkedList listY) {
        LinkedList resultList = new LinkedList();
        int zeroCounter = 0;

        while(listY.getHead() != null) {
            LinkedList temp = listX;
            LinkedList current = new LinkedList();
            int carry = 0;

            while(temp.getHead() != null){
                int result = (listY.getHead().getValue() * temp.getHead().getValue()) + carry;
                carry = result / 10;
                current.insertNode(result % 10);

                temp.removeHead();
            }

            if(carry > 0){
                current.insertNode(0);
            }

            for(int i = 1; i < zeroCounter; i++){
                current.insertNode(0);
            }

            listY.removeHead();
            zeroCounter++;

            if (resultList.getHead() == null) {
                resultList = current;
            } else {
                Addition add = new Addition();
                resultList = add.doOperation(resultList, current);
            }
        }
        return resultList;
    }
}