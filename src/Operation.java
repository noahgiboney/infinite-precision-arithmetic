public abstract class Operation {
    private String x;
    private String y;

    public Operation(String x, String y){
        StringBuilder bufferX = new StringBuilder(x);
        StringBuilder bufferY = new StringBuilder(y);

        while(bufferX.length() > 0 && bufferX.charAt(0) == '0'){
            bufferX.deleteCharAt(0);
        }

        while(bufferY.length() > 0 && bufferY.charAt(0) == '0'){
            bufferY.deleteCharAt(0);
        }

        if(bufferX.length() == 0){
            bufferX.append('0');
        }

        if(bufferY.length() == 0){
            bufferY.append('0');
        }

        this.x = bufferX.toString();
        this.y = bufferY.toString();
    }

    public Operation(){}

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
