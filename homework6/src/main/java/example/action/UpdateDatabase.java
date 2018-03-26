package example.action;

import example.iinterface.DatabaseAction;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDatabase implements DatabaseAction {
    private ResultSet set;
    private boolean flag = true;
    private String oldData;
    private String newData;

    @Override
    public void actionActivityDatabase(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            System.out.println("Update data in database");
            while (flag) {
                set = null;
                oldData = null;
                newData = null;
                Scanner in = new Scanner(System.in);
                System.out.println("Choose name or address or phone: ");
                String emp = in.next().toLowerCase();
                switch (emp) {
                    case "name":
                        System.out.println("Enter old name: ");
                        oldData = in.next().toLowerCase();
                        System.out.println("Enter new name: ");
                        newData = in.next().toLowerCase();
                        set = statement.executeQuery("UPDATE person SET Name='" + newData + "'" + "WHERE Name='" + oldData + "'");
                        break;
                    case "address":
                        System.out.println("Enter old address: ");
                        oldData = in.next().toLowerCase();
                        System.out.println("Enter new address: ");
                        newData = in.next().toLowerCase();
                        set = statement.executeQuery("UPDATE person SET Address='" + newData + "'" + "WHERE Address='" + oldData + "'");
                        break;
                    case "phone":
                        System.out.println("Enter old name: ");
                        oldData = in.next().toLowerCase();
                        System.out.println("Enter new name: ");
                        newData = in.next().toLowerCase();
                        set = statement.executeQuery("UPDATE person SET phone='" + newData + "'" + "WHERE phone='" + oldData + "'");
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
                                set.getString("phone"));
                    }
                } else
                    break;


            }
        }
    }
}
