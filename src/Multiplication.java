public class Multiplication extends Operation{

    public Multiplication(String x, String y){
        super(x,y);
    }

    @Override
    public LinkedList doOperation(LinkedList listX, LinkedList listY) {
        LinkedList resultList = new LinkedList();
        LinkedList current = new LinkedList();
        int zeroCounter = 0;

        while(listY.getHead() != null){
            LinkedList temp = listX; //result temp list

            while(temp.getHead() != null){
                int result = temp.getHead().getValue() * listY.getHead().getValue();
                if(result <= 9){
                    current.insertNode(result);
                }
                else{
                    current.insertNode(result % 10);
                    if(temp.getHead().getNext() == null){
                        current.insertNode(result / 10);
                    }
                    else{
                        current.getHead().getNext().carry(result /10);
                    }
                }
                temp.removeHead();
            }

            zeroCounter++;
            listY.removeHead();
        }
        
        for(int i = 1; i < zeroCounter; i++){
            current.insertNode(0);
        }

        if(resultList.getHead() == null){
            resultList = current;
        }
        else{
            Addition add = new Addition();
            resultList = add.doOperation(resultList, current);
        }
        
        return resultList;
    }


}