import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessor {

    private int num1;
    private int num2;
    private String operator;

    /**
     * Processes arithmetic expressions line-by-line in the given file.
     *
     * @param filePath Path to a file containing arithmetic expressions.
     */
    public static void processFile(String filePath) {
        File infile = new File(filePath);
        try (Scanner scan = new Scanner(infile)) {
            while(scan.hasNext()){
                while (scan.hasNextInt()) {
                    // TODO: Process each line of the input file here.
                    int num1 = scan.nextInt();
                    System.out.print(num1);

                }
                while (scan.hasNext()){
                    String op = scan.next();
                    System.out.print(op);
                }
                while (scan.hasNextInt()) {
                    int num2 = scan.nextInt();
                    System.out.print(num2);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }
    }


}
