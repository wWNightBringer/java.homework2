package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import validator.annotation.Form;

public class ClientsRecord {
    @Form(
            value = "[0-9]{1,6}$",
            message = "Incorrect value id"
    )
    private Integer id;
    @Form(
            value = "[a-zA-Z]{1,10}$",
            message = "Incorrect value name"
    )
    private String name;
    @Form(
            value = "[a-zA-Z0-9]{1,10}$",
            message = "Incorrect value address"
    )
    private String address;
    @Form(
            value = "+[0-9]{1,12}$",
            message = "Incorrect value phone"
    )
    private Integer phone;
    @Form(
            value = "[a-zA-Z0-9]{1,10}$",
            message = "Incorrect value nick"
    )
    private String nick;

    public ClientsRecord(Integer id, String name, String address, Integer phone, String nick) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.nick = nick;
    }

    public ClientsRecord() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
