public class Addition {
    private String operator;
    private int x;
    private int y;
    private LinkedList listX;
    private LinkedList listY;

    public Addition(String operator, int x, int y ){
        this.operator = operator;
        this.x = Integer.parseInt(Integer.toString(x,10));
        this.y = Integer.parseInt(Integer.toString(y,10));
    }

    public String getOperator() {
        return operator;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
