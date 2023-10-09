public class Multiplication extends Operation{

    public Multiplication(String x, String y){
        super(x,y);
    }

    @Override
    public LinkedList doOperation(LinkedList listX, LinkedList listY) {
        LinkedList resultList = new LinkedList();
        int zeroCounter = 0;

        while(listY.getHead() != null){
            LinkedList.Node temp = listX.getHead();
            while(temp != null){
                int result = listY.getHead().getValue() * temp.getValue();
                if(result <= 9){
                    resultList.insertNode(result);
                }
                temp = temp.getNext();
            }
            listY.removeHead();
        }
        return resultList;
    }


}
