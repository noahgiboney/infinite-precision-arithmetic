public abstract class Operation {
    private String x;
    private String y;

    public Operation(String x, String y){
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
        LinkedList list = new LinkedList();

        for(int i = 0; i < value.length(); i++){
            list.insertNode(value.charAt(i) - '0');
        }
        return list;
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }

    public abstract LinkedList doOperation(LinkedList listX, LinkedList listY);
}
