package example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    @JsonProperty("Id")
    private int id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Address")
    private String address;
    @JsonProperty("Phone")
    private int phone;
    @JsonProperty("Nick")
    private String nick;

    @JsonCreator
    public Person(
            @JsonProperty("Id") int id,
            @JsonProperty("Name") String name,
            @JsonProperty("Address") String address,
            @JsonProperty("Phone") int phone,
            @JsonProperty("Nick") String nick) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.nick = nick;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getPhone() {
        return phone;
    }

    public String getNick() {
        return nick;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", nick='" + nick + '\'' +
                '}';
    }
}
