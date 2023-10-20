import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class FileProcessor {

    /**
     * Processes arithmetic expressions line-by-line in the given file.
     *
     * @param filePath Path to a file containing arithmetic expressions.
     */
    public static void processFile(String filePath) {
        File infile = new File(filePath);
        int counter = 0;
        try (Scanner scan = new Scanner(infile)) {
            while(scan.hasNext()){
                String line = scan.nextLine().trim(); //grab the whole line and trim white space

                String[] divide = line.split("\\s+"); //split up string into the three components and remove white space

                if(!(isValidLine(divide))) { //skip if it not valid
                    continue;
                }
                if(counter >= 1) { //if we are not on the first line of input, we can move down to the next line
                    System.out.println();
                }

                //get the operators and operands
                String x = divide[0];
                String operator = divide[1];
                String y = divide[2];

                if(!(isValidOperand(x)) || !(isValidOperator(operator)) || !(isValidOperand(y))){ //make sure x, y, and operators are valid, skip if not
                    continue;
                }

                //carry out operation and output depending on operator
                if(Objects.equals(operator, "+")){
                    Addition add = new Addition(x,y);
                    LinkedList result = add.doOperation(add.fillList(add.getX()), add.fillList(add.getY()));
                    System.out.print(add.getX() + " + " + add.getY() + " = " + result.toString());
                }
                if(Objects.equals(operator, "*")){
                    Multiplication mult = new Multiplication(x,y);
                    LinkedList result = mult.doOperation(mult.fillList(mult.getX()), mult.fillList(mult.getY()));
                    System.out.print(mult.getX() + " * " + mult.getY() + " = " + result.toString());
                }
                if(Objects.equals(operator, "^")){
                    Exponential exp = new Exponential(x,y);
                    LinkedList result = exp.doOperation(exp.fillList(exp.getX()), exp.fillList(exp.getY()));
                    System.out.print(exp.getX() + " ^ " + exp.getY() + " = " + result.toString());
                }
                counter++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }
    }

    public static boolean isValidLine(String[] line){
        return line.length == 3; //line is valid if its length is three
    }

    public static boolean isValidOperand(String operand){
        for(int i = 0; i < operand.length(); i++){
            if(!(Character.isDigit(operand.charAt(i)))){
                return false;
            }
        }
        return true; //operand is valid if all chars at i are digits
    }

    public static boolean isValidOperator(String operator){
        return Objects.equals(operator, "+") || Objects.equals(operator, "*") || Objects.equals(operator, "^"); //operator is valid is its * ^ +
    }
}