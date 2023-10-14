import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
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

        try (Scanner scan = new Scanner(infile)) {
            while(scan.hasNext()){
                String line = scan.nextLine(); //grab the whole line

                if(!(isValidLine(line))){ //skip if it not valid
                    continue;
                }

                String[] divide = line.split("\\s+"); //split up string into the three components and remove white space
                String x = divide[0].trim();
                String operator = divide[1].trim();
                String y = divide[2].trim();

                if(!(isValidOperand(x)) || !(isValidOperator(operator)) || !(isValidOperand(y))){ //make sure x, y, and operators are valid, skip if not
                    continue;
                }

                //carry out operation and output depending on operator
                if(Objects.equals(operator, "+")){
                    Addition add = new Addition(x,y);
                    LinkedList result = add.doOperation(add.fillList(add.getX()), add.fillList(add.getY()));
                    System.out.println(add.getX() + " + " + add.getY() + " = " + result.toString());
                }
                if(Objects.equals(operator, "*")){
                    Multiplication mult = new Multiplication(x,y);
                    LinkedList result = mult.doOperation(mult.fillList(mult.getX()), mult.fillList(mult.getY()));
                    System.out.println(mult.getX() + " * " + mult.getY() + " = " + result.toString());
                }
                if(Objects.equals(operator, "^")){
                    Exponential exp = new Exponential(x,y);
                    LinkedList result = exp.doOperation(exp.fillList(exp.getX()), exp.fillList(exp.getY()));
                    System.out.println(exp.getX() + " ^ " + exp.getY() + " = " + result.toString());
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }
    }

    public static boolean isValidLine(String line){
        int counter = 0;
        for(int i = 0; i < line.length(); i++){
            if (Character.isWhitespace(line.charAt(i))){
                counter++;
            }
        }
        return counter == 2;
    }

    public static boolean isValidOperand(String operand){
        for(int i = 0; i < operand.length(); i++){
            if(!(Character.isDigit(operand.charAt(i)))){
                return false;
            }
        }
        return true;
    }

    public static boolean isValidOperator(String operator){
        return Objects.equals(operator, "+") || Objects.equals(operator, "*") || Objects.equals(operator, "^");
    }
}