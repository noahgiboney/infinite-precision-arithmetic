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