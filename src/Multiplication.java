public class Multiplication extends Operation{

    public Multiplication(String x, String y){
        super(x,y);
    }

    @Override
    public LinkedList doOperation(LinkedList listX, LinkedList listY) {
        LinkedList resultList = new LinkedList();
        int zeroCounter = 0;
        LinkedList temp;

        while(listY.getHead() != null){
            temp = listX;
            LinkedList current = new LinkedList();

            while(temp.getHead() != null){
                int result = listX.getHead().getValue() * temp.getHead().getValue();
                if(result <= 9){
                    current.insertNode(result);
                }
                else{
                    current.insertNode(result % 10);
                    if (temp.getHead().getNext() == null){
                        current.insertNode(result / 10);
                    }
                    else{
                        temp.getHead().getNext().carry(result / 10);
                    }
                }
                temp.removeHead();
            }

            for(int i = 0; i < zeroCounter; i++){
                current.insertNode(0);
            }

            if(resultList.getHead() == null){
                resultList = current;
            }
            else {
                Addition add = new Addition();
                resultList = add.doOperation(resultList,current);
            }
            zeroCounter++;
            listY.removeHead();
        }
        return resultList;
    }


}
