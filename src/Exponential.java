public class Exponential extends Operation {
    public Exponential(String x, String y) {
        super(x, y);
    }

    @Override
    public LinkedList doOperation(LinkedList listX, LinkedList listY) {
        int power = Integer.parseInt(listY.toString());
        return expBySquaring(listX, power);
    }

    public LinkedList expBySquaring(LinkedList listX, int power) {
        Multiplication mult = new Multiplication();

        if (power == 0) {
            LinkedList one = new LinkedList();
            one.insertNode(1);
            return one;
        }
        else if (power % 2 == 0) {
            LinkedList squared = mult.doOperation(listX, listX);
            squared.reverse(); // To keep it in LSD
            return expBySquaring(squared, power / 2);
        }
        else {
            LinkedList squaredX = mult.doOperation(listX, listX);
            squaredX.reverse();
            LinkedList result = expBySquaring(squaredX, (power - 1) / 2);
            result.reverse();
            return mult.doOperation(listX, result);
        }
    }
}
