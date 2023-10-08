public class Multiplication extends Operation{

    public Multiplication(String x, String y){
        super(x,y);
    }

    @Override
    public LinkedList doOperation(LinkedList listX, LinkedList listY) {
        int result = listX.getHead().getValue() * listY.getHead().getValue();
        return null;
    }


}
