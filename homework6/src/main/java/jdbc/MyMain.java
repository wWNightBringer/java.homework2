package jdbc;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyMain {
    private static ResultSetAllClient client;

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        client = new ResultSetAllClient();
        client.showAllClient();
      /*  try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root")) {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM CLIENTS");

            while (set.next()) {
                System.out.println(set.getInt(1)+" "+set.getString("name"));
            }


        }*/
    }

}
