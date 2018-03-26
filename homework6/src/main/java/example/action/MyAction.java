package example.action;

import com.fasterxml.jackson.databind.ObjectMapper;
import example.Person;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyAction {
    ObjectMapper objectMapper = new ObjectMapper();
    private ResultSet set;
    private List<Person> list;
    private TableCreation tableCreation;
    private InsertDatabase insertDatabase;
    private SelectDatabase selectDatabase;
    private UpdateDatabase updateDatabase;
    private DeleteData deleteData;
    private int id;
    private String name;
    private String address;
    private int phone;

    public void choose(Connection connection) throws SQLException, IOException {
        list = new ArrayList<Person>();
        Scanner scanner = new Scanner(System.in);
        tableCreation = new TableCreation();
        tableCreation.actionActivityDatabase(connection);
        while (true) {
            System.out.println("Choose insert or select data or update data or delete: ");
            String enter = scanner.nextLine().toLowerCase();
            if (!enter.equalsIgnoreCase("exit")) {
                switch (enter) {
                    case "insert":
                        System.out.println("Enter id, name, address, phone: ");
                        id = Integer.parseInt(scanner.next().toLowerCase());
                        name = scanner.next().toLowerCase();
                        address = scanner.next().toLowerCase();
                        phone = Integer.parseInt(scanner.next().toLowerCase());
                        insertDatabase = new InsertDatabase(id, name, address, phone);
                        insertDatabase.actionActivityDatabase(connection);
                        break;
                    case "select":
                        selectDatabase = new SelectDatabase();
                        selectDatabase.actionActivityDatabase(connection);
                        break;
                    case "update":
                        updateDatabase = new UpdateDatabase();
                        updateDatabase.actionActivityDatabase(connection);
                        break;
                    case "delete":
                        deleteData = new DeleteData();
                        deleteData.actionActivityDatabase(connection);
                        break;
                    default:
                        break;


                }
            } else
                break;
            System.out.println("If you need escape enter exit ");
        }
    }
}
