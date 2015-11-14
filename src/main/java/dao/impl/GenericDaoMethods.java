package dao.impl;

import dao.ConnectionProvider;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class GenericDaoMethods {
    public static void genericDelete(String noteUuid, String tableName) {
        try (Connection connection = ConnectionProvider.getConnection();
             Statement statement = connection.createStatement()
        ) {
            statement.execute("DELETE FROM " + tableName + " WHERE UUID=" + noteUuid);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
