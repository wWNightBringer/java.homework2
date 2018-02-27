package dictionary;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static ReadFile readFile;

    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        String line;
        System.out.println("Enter word for translate");
        line=scanner.nextLine();
        readFile=new ReadFile();
        readFile.show(line);
    }
}
