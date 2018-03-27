package example.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import example.Person;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Serialization {
    private List<Person> list;
    private Path path;
    private ObjectMapper mapper = new ObjectMapper();

    public Serialization(List<Person> list) throws IOException {
        this.list = list;
        path = Paths.get("C:\\Users\\Nightbringer\\IdeaProjects\\HomeWork2\\homework6\\src\\main\\resources\\example\\action\\dataFromDatabase");
        mapper.writeValue(path.toFile(), list);
    }
}
