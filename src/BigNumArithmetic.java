import javax.swing.*;

public class BigNumArithmetic {

    /**
     * The entry point of the program.
     * @param args Command line arguments. Should have exactly one argument: a file name.
     */
    public static void main(String[] args) {
//        if (args.length != 1) {
//            throw new IllegalArgumentException(
//                    "Expected exactly 1 argument: a file name.");
//        }
//        String filePath = args[0];
//        FileProcessor.processFile(filePath);

        //use this logic
        int x = 112359;
        System.out.println(x % 10);
        System.out.println(x % 100 / 10);
        System.out.println(x % 1000 / 100);
        System.out.println(x % 10000 / 1000);
    }
}

