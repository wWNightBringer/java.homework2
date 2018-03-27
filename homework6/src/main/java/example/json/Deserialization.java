package example.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import example.Person;

import java.io.IOException;
import java.util.List;

public class Deserialization {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Person> list = objectMapper.readValue(Deserialization.class.getResourceAsStream("dataFromDatabase.json"),
                new TypeReference<List<Person>>() {
                });
        System.out.println(list);
    }
}
