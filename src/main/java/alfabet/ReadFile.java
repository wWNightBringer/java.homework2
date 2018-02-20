package alfabet;


import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class ReadFile {
    private Properties properties;
    public Map readFromFile() throws IOException {
        properties=new Properties();
        File file=new File("C:\\Users\\Nightbringer\\IdeaProjects\\HomeWork2\\src\\main\\java\\alfabet\\File\\Language.txt");
     BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
     String string;
     Map<String,String > map=new HashMap<>();
       while((string=bufferedReader.readLine())!=null){
           String[] a=string.split("=");
           map.put(a[0],a[1]);
       }
       return map;
    }

    public void show(String words) throws IOException {
        for(Object s:readFromFile().keySet()){
            if(s.hashCode()==words.hashCode()){
                System.out.println("Translate for word '"+words+"':"+"\n"+readFromFile().get(s));
            }

        }
    }


}
