package example.action;

import example.Person;
import example.json.Serialization;
import example.iinterface.DatabaseAction;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelectDatabase implements DatabaseAction {
    private ResultSet set;
    private boolean flag = true;
    private String row;
    private List<Person> list;
    private static Serialization serialization;
    private int x;

    public SelectDatabase() {
        list = new ArrayList<>();
    }

    @Override
    public void actionActivityDatabase(Connection connection) throws SQLException, IOException {
        try (Statement statement = connection.createStatement()) {
            while (flag) {
                x = 0;
                set = null;
                row = null;
                Scanner in = new Scanner(System.in);
                System.out.println("Choose all or name or address or phone, exit: ");
                String emp = in.next().toLowerCase();
                switch (emp) {
                    case "all":
                        x = 1;
                        System.out.println("ID\tName\t\tAddress\t\tPhone\t\tNick");
                        set = statement.executeQuery("SELECT * FROM person,phone WHERE person.ID=phone.PersonID ORDER BY person.ID");
                        break;
                    case "name":
                        System.out.println("Enter name what you want: ");
                        row = in.next().toLowerCase();
                        set = statement.executeQuery("SELECT * FROM person,phone WHERE person.ID=phone.PersonID,NAME='" + row + "'");
                        break;
                    case "address":
                        System.out.println("Enter address what you want: ");
                        row = in.next().toLowerCase();
                        set = statement.executeQuery("SELECT * FROM person,phone WHERE person.ID=phone.PersonID,Address='" + row + "'");
                        break;
                    case "phone":
                        System.out.println("Enter phone what you want: ");
                        row = in.next().toLowerCase();
                        set = statement.executeQuery("SELECT * FROM person WHERE person.ID=phone.PersonID,phone='" + row + "'");
                        break;
                    case "exit":
                        flag = false;
                        break;
                    default:
                        break;
                }
                if (flag) {
                    while (set.next()) {
                        System.out.println(set.getInt(1) + "\t" + set.getString("name") + "\t\t" +
                                set.getString("Address") + "\t\t" +
                                set.getString("phone") + "\t\t" + set.getString("Nick"));
                        if (x == 1) {
                            list.add(new Person(set.getInt(1), set.getString("name"),
                                    set.getString("Address"), set.getInt(4), set.getString("Nick")));
                        }

                    }
                } else
                    break;


            }


        }
        serialization = new Serialization(getList());
    }

    public List<Person> getList() {
        return list;
    }

}
