import javax.xml.transform.Result;

public class Exponential extends Operation{
    public Exponential(String x, String y){
        super(x,y);
    }
    public Exponential(){}

    @Override
    public LinkedList doOperation(LinkedList listX, LinkedList listY){
        LinkedList resultList = new LinkedList();
        int power = Integer.parseInt(listY.toString());

        if (power == 0){
            resultList.insertNode(1);
            return  resultList;
        }
        return resultList;
    }
}
