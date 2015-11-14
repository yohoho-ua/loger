package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestDataSource {
    private Connection connection;
    public void check() {
        try {
            connection = ConnectionProvider.getConnection();
            if (connection == null) {
                System.out.println("NULL");
                System.exit(1);
            }
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM accounts");
            while (rs.next()) {
                System.out.println(rs.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
