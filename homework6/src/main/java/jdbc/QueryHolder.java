package jdbc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import java.util.stream.Collectors;

public class QueryHolder {
    private static final QueryHolder HOLDER;

    static {
        HOLDER = new QueryHolder();
        try {
            HOLDER.init();
        } catch (IOException ex) {
            System.err.println("Database isn`t connected");
        }
    }

    private final Map<String, String> map = new HashMap<>();

    public static QueryHolder getHOLDER() {
        return HOLDER;
    }

    private void init() throws IOException {
        map.putAll(loadProperties("query.xml"));
        map.putAll(loadProperties("tables.xml"));
    }

    private Map<? extends String, ? extends String> loadProperties(String res) throws IOException {
        Properties properties = new Properties();
        properties.loadFromXML(QueryHolder.class.getResourceAsStream(res));
        return properties.entrySet()
                .stream()
                .collect(Collectors.toMap(e -> e.getKey().toString(), e -> e.getValue().toString()));


    }

    public String getQuery(String name) {
        if (!map.containsKey(name)) {
            throw new IllegalArgumentException("");
        }
        return map.get(name);
    }
}
