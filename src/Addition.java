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
        LinkedList result = new LinkedList();


        return result;
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
