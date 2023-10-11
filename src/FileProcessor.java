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
                String currentLine = scan.nextLine();

                String[] items = currentLine.split("\\s+"); //split items with space

                if (items.length != 3) {
                    continue;
                }

                String x = items[0];
                String operator = items[1];
                String y = items[2];

                if (!(isValidOperand(x)) || !(isValidOperator(operator)) || !(isValidOperand(y))) {
                    continue;
                }

                if(Objects.equals(operator, "+")){
                    Addition add = new Addition(x,y);
                    LinkedList result = add.doOperation(add.fillList(add.getX()), add.fillList(add.getY()));
                    System.out.println(add.getX() + " + " + add.getY() + " = " + result.toString());
                }
                if(Objects.equals(operator, "*")){
                    Multiplication multiply = new Multiplication(x,y);
                    LinkedList result = multiply.doOperation(multiply.fillList(multiply.getX()), multiply.fillList(multiply.getY()));
                    System.out.println(multiply.getX() + " * " + multiply.getY() + " = " + result.toString());
                }
                if(Objects.equals(operator, "^")){
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }
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
