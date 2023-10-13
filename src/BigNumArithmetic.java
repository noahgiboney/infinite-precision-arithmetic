import javax.swing.*;
//UML CODE = 1012
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

        Addition add = new Addition();

        LinkedList x = new LinkedList();
        x.insertNode(6);
        x.insertNode(2);

        LinkedList y = new LinkedList();
        y.insertNode(2);
        y.insertNode(4);
        y.insertNode(8);
        y.insertNode(0);

        System.out.println(add.doOperation(x,y).toString());
    }


}

