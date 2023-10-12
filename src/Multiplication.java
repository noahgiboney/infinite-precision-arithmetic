public class Multiplication extends Operation{

    public Multiplication(String x, String y){
        super(x,y);
    }

    @Override
    public LinkedList doOperation(LinkedList listX, LinkedList listY) {
        LinkedList resultList = new LinkedList();
        resultList.insertNode(0);
        int zeroCounter = 0;

        while(listY.getHead() != null){
            LinkedList.Node temp = listX.getHead();
            LinkedList current = new LinkedList();

            while(temp != null){
                int result = listY.getHead().getValue() * temp.getValue();
                if(result <= 9){
                    current.insertNode(result);
                }
                else{
                    current.insertNode(result % 10);
                    if (temp.getNext() == null){
                        current.insertNode(result / 10);
                    }
                    else{
                        temp.getNext().carry(result / 10);
                    }
                }
                temp = temp.getNext();
            }
            for(int i = 0; i < zeroCounter; i++){
                current.insertNode(0);
            }


            Addition add = new Addition();
            resultList = add.doOperation(resultList,current);

            zeroCounter++;
            listY.removeHead();
        }
        return resultList;
    }


}
