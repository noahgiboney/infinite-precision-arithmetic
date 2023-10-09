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
        try (Scanner scan = new Scanner(infile)) {
            while(scan.hasNext()){

                    String x = scan.next();
                    String operator = scan.next();
                    String y = scan.next();

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


}
