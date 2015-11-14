package dao.impl;

import dao.ConnectionProvider;
import dao.UserDao;
import domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static dao.impl.GenericDaoMethods.genericDelete;


public class UserDaoImpl implements UserDao {
    private Connection connection;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;

    public UserDaoImpl() throws SQLException {
            connection = ConnectionProvider.getConnection();
    }

    public void create(User user) throws SQLException {
        try {
            preparedStatement = connection
                    .prepareStatement("INSERT INTO ACCOUNTS(UUID, email, password) values (?, ?, ?)");
            preparedStatement.setString(1, user.getUuid());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
            connection.close();
        }
    }

    public User getUserByUuid(String userUuid) throws SQLException {
        User user = new User();
        try {
            preparedStatement = connection.
                    prepareStatement("SELECT * FROM ACCOUNTS WHERE UUID=?");
            preparedStatement.setString(1, userUuid);
            rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUuid(rs.getString("UUID"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
            rs.close();
            connection.close();
        }

        return user;
    }

    public void update(User user) throws SQLException {
        try {
            preparedStatement = connection
                    .prepareStatement("UPDATE ACCOUNTS SET email=?, password=?" +
                            "where UUID=?");

            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getUuid());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
            connection.close();
        }
    }

    public void delete(String userUuid) {
        genericDelete(userUuid, "ACCOUNTS");
    }

    public ArrayList getUserList() throws SQLException {
        ArrayList<User> userList = new ArrayList<User>();

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM ACCOUNTS");
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User tempUser = new User();
                tempUser.setId(rs.getInt("id"));
                tempUser.setUuid(rs.getString("UUID"));
                tempUser.setEmail(rs.getString("email"));
                tempUser.setPassword(rs.getString("password"));
                userList.add(tempUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
        }
        return userList;
    }
}

