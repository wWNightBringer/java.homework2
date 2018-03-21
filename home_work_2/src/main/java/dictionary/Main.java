package dictionary;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static DictionaryReader readFile;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String line;
        readFile = new DictionaryReader();
        while (true) {
            System.out.println("Enter word for translate");
            line = scanner.nextLine();
            readFile.show(line);
            if ("exit".equalsIgnoreCase(line))
                break;
        }

    }
}
