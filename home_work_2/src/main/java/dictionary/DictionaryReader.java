package dictionary;


import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Stream;

public class DictionaryReader {
    private File file;

    public Map<String, String> readFromFile() throws IOException {
        file = new File("C:\\Users\\Nightbringer\\IdeaProjects\\HomeWork2\\home_work_2\\src\\main\\java\\dictionary\\File\\Language.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String string;
        Map<String, String> map = new HashMap<>();
        while ((string = bufferedReader.readLine()) != null) {
            String[] a = string.split("=");
            map.put(a[0], a[1]);
        }
        return map;
    }

    public void show(String words) throws IOException {
        for (Object s : readFromFile().keySet()) {
            if (s.hashCode() == words.hashCode()) {
                System.out.println("Translate for word '" + words + "':" + "\n" + readFromFile().get(s));
            }

        }
    }


}
