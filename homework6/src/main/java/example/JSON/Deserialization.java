package example.JSON;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import example.Person;
import sun.security.krb5.internal.crypto.Des;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class Deserialization {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        List<Person> list=objectMapper.readValue(Deserialization.class.getResourceAsStream("dataFromDatabase.json"),
                new TypeReference<List<Person>>(){});
        System.out.println(list);
    }
}
