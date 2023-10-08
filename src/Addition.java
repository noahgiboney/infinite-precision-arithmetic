public class Addition {
    private String operator;
    private String x;
    private String y;
    private LinkedList list;
    private LinkedList listY;

    public Addition(String operator, String x, String y ){
        this.operator = operator;

        StringBuilder bufferX = new StringBuilder(x);
        StringBuilder bufferY = new StringBuilder(y);

        int indexX = 0;
        while(bufferX.charAt(indexX) == '0'){
            bufferX.deleteCharAt(indexX);
        }
        int indexY = 0;
        while(bufferY.charAt(indexY) == '0'){
            bufferY.deleteCharAt(indexY);
        }
        this.x = bufferX.toString();
        this.y = bufferY.toString();
    }

    public LinkedList fillList(String value){
        list = new LinkedList();

        for(int i = 0; i < value.length(); i++){
            list.insertNode(value.charAt(i) - '0');
        }
        return list;
    }

    public LinkedList doAddition(LinkedList listX, LinkedList listY){
        LinkedList resultList = new LinkedList(); //list to store result

        while(listX.getHead() != null && listY.getHead() != null){
            int result = listX.getHead().getValue() + listY.getHead().getValue(); //calculate sum of head of x and y
            if(result <= 9){
                resultList.insertNode(result); //insert the result to the list if its single digit
            }
            else{
                resultList.insertNode(result - 10); //insert ones place value to result list if result is double digit
                if(listX.getHead().getNext() == null){
                    listX.insertTail(result / 10); //if the head of list x does not point to anything, then we can insert tens value to the tail of the list
                }
                else{
                    listX.getHead().getNext().carry(result / 10  ); //if there is another node after the head we have to carry the tens place value to the next node
                }
            }

            if (!(listX.getHead().getNext() == null) && listY.getHead().getNext() == null) {
                listY.insertTail(0); //add a node with value zero to do addition
            }
            if (listX.getHead().getNext() == null && !(listY.getHead().getNext() == null)) {
                listX.insertTail(0); //add a node with value zero to do addition
            }
            listX.removeHead(); //remove the head of x and y after addition was carried out
            listY.removeHead();
        }
        return resultList;
    }

    public String getOperator() {
        return operator;
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }
}
