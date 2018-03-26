package example.action;

import example.iinterface.DatabaseAction;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteData implements DatabaseAction {
    private ResultSet set;
    private boolean flag = true;
    private String data;

    @Override
    public void actionActivityDatabase(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            Scanner in = new Scanner(System.in);
            System.out.println("Delete data from database ");
            while (flag) {
                set = null;
                data = null;
                System.out.println("Choose name or address or phone: ");
                String emp = in.next().toLowerCase();
                switch (emp) {
                    case "name":
                        System.out.println("Enter name what you need delete: ");
                        data = in.next().toLowerCase();
                        set = statement.executeQuery("DELETE FROM person WHERE NAME='" + data + "'");
                        break;
                    case "address":
                        System.out.println("Enter address what you need delete: ");
                        data = in.next().toLowerCase();
                        set = statement.executeQuery("DELETE FROM person WHERE Address='" + data + "'");
                        break;
                    case "phone":
                        System.out.println("Enter inn what you need delete: ");
                        data = in.next().toLowerCase();
                        set = statement.executeQuery("DELETE FROM person WHERE INN='" + data + "'");
                        break;
                    case "exit":
                        flag = false;
                        break;
                    default:
                        break;
                }
                if (flag) {
                    while (set.next()) {
                        System.out.println(set.getInt(1) + " " + set.getString("name") + " " + set.getString("Address") + " " +
                                set.getString("INN"));
                    }
                } else
                    break;


            }
        }
    }
}
