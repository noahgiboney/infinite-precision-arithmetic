public class Addition extends Operation{

    public Addition( String x, String y ){
        super(x,y);
    }

    public Addition(){}

    @Override
    public LinkedList doOperation(LinkedList listX, LinkedList listY){
        LinkedList resultList = new LinkedList(); //list to store result
        LinkedList copyX = listX;
        LinkedList copyY = listY;

        while(copyX.getHead() != null && copyY.getHead() != null){
            int result = copyX.getHead().getValue() + copyY.getHead().getValue(); //calculate sum of head of x and y
            if(result <= 9){
                resultList.insertNode(result); //insert the result to the list if its single digit
            }
            else{
                resultList.insertNode(result % 10); //insert ones place value to result list if result is double digit
                if(copyX.getHead().getNext() == null){
                    copyX.insertTail(result / 10); //if the head of list x does not point to anything, then we can insert tens value to the tail of the list
                }
                else{
                    copyX.getHead().getNext().carry(result / 10  ); //if there is another node after the head we have to carry the tens place value to the next node
                }
            }

            if (!(copyX.getHead().getNext() == null) && copyY.getHead().getNext() == null) {
                copyY.insertTail(0); //add a node with value zero to do addition
            }
            if (copyX.getHead().getNext() == null && !(copyY.getHead().getNext() == null)) {
                copyX.insertTail(0); //add a node with value zero to do addition
            }
            copyX.removeHead(); //remove the head of x and y after addition was carried out
            copyY.removeHead();
        }
        return resultList;
    }
}