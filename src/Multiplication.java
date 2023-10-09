public class Multiplication extends Operation{

    public Multiplication(String x, String y){
        super(x,y);
    }

    @Override
    public LinkedList doOperation(LinkedList listX, LinkedList listY) {

        LinkedList resultList = new LinkedList(); // list to store running total of adding multiplication result
        int zeroCounter = 0;

        while(listY.getHead() != null){
            LinkedList temp = new LinkedList();
            LinkedList copy = listX;

            while(copy.getHead() != null){

                int result = listY.getHead().getValue() * listX.getHead().getValue();
                if(result <= 9){
                    temp.insertNode(result);
                }
                else{
                    temp.insertNode(result % 10);
                    if(listX.getHead().getNext() == null){
                        temp.insertNode(result / 10); //if the head of list x does not point to anything, then we can insert into the temp list
                    }
                    else{
                        listX.getHead().getNext().carry(result / 10  ); //if there is another node after the head we have to carry the tens place value to the next node
                    }
                }
                copy.removeHead();
            }
            for(int i = 0; i < zeroCounter; i++){
                temp.insertNode(0);
            }

            if(resultList.getHead() == null){
                resultList = temp;
            }
            else {
                Addition add = new Addition();
                resultList = add.doOperation(resultList, temp);
            }
            zeroCounter++;
            listY.removeHead();
        }
        return resultList;
    }


}
