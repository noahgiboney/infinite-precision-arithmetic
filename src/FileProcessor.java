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
                        Addition add = new Addition(operator, x, y);
                        add.doAddition(add.fillList(add.getX()), add.fillList(add.getY()));

                        System.out.println(add.getX() + " " + add.getOperator() + " " + add.getY() + " = ");
                    }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }
    }


}
