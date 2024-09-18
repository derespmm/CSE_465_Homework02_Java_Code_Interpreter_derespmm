import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class Zpm {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Usage: java Zpm <filename>");
            return;
        }

        List<String> tokens = new LinkedList<>();
        String fileToString = "";

        try {
            Scanner scanner = new Scanner(new File(args[0]));
            while (scanner.hasNextLine()) {
                fileToString += scanner.nextLine() + " ";
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        Lexer lexer = new Lexer();
        tokens = lexer.tokenize(fileToString);
        Parser parser = new Parser();
        parser.parse(tokens);

    }
}
