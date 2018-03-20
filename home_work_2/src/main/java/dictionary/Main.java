package dictionary;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static ReadFile readFile;

    /**
    Программа должна быть User-Frendly
    А тут получается мне нужно для каждого слова ее запускать 
    Пользователи такой пользоваться не будут :)
    Где цикл, с вопросом что перевести или выйти из программы?
    **/
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        String line;
        System.out.println("Enter word for translate");
        line=scanner.nextLine();
        readFile=new ReadFile();
        readFile.show(line);
    }
}
