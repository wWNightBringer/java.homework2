package example.action;

import example.iinterface.DatabaseAction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDatabase implements DatabaseAction {
    private int id;
    private String name;
    private String address;
    private int phone;

    public InsertDatabase(int id, String name, String address, int phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public void actionActivityDatabase(Connection connection) throws SQLException {
        try(Statement statement=connection.createStatement()) {
            Scanner in=new Scanner(System.in);
            statement.execute("INSERT INTO person (ID,NAME,ADDRESS,phone) VALUES (" + id + ",'" + name + "','" + address + "','" +
                    phone + "')");
        }

    }
}
