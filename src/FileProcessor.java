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

                    int x = scan.nextInt();
                    String operator = scan.next();
                    int y = scan.nextInt();

                    if(Objects.equals(operator, "+")){
                        Addition add = new Addition(operator, x, y);


                        System.out.println(add.getX() + " " + add.getOperator() + " " + add.getY() + " = ");
                    }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }
    }


}
