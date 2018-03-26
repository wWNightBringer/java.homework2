package example.action;

import example.iinterface.DatabaseAction;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectDatabase implements DatabaseAction {
    private ResultSet set;
    private boolean flag = true;
    private String row;

    @Override
    public void actionActivityDatabase(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            while (flag) {
                set = null;
                row = null;
                Scanner in = new Scanner(System.in);

                System.out.println("Choose name or address or phone or all, exit: ");
                String emp = in.next().toLowerCase();
                switch (emp) {
                    case "all":
                        System.out.println("-----------------------");
                        set = statement.executeQuery("SELECT * FROM person");
                        setSet(set);
                        break;
                    case "name":
                        System.out.println("Enter name what you want: ");
                        row = in.next().toLowerCase();
                        set = statement.executeQuery("SELECT * FROM person WHERE NAME='" + row + "'");
                        break;
                    case "address":
                        System.out.println("Enter address what you want: ");
                        row = in.next().toLowerCase();
                        set = statement.executeQuery("SELECT * FROM person WHERE Address='" + row + "'");
                        break;
                    case "phone":
                        System.out.println("Enter phone what you want: ");
                        row = in.next().toLowerCase();
                        set = statement.executeQuery("SELECT * FROM person WHERE phone='" + row + "'");
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

    public ResultSet getSet() {
        return set;
    }

    public void setSet(ResultSet set) {
        this.set = set;
    }
}
