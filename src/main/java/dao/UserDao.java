package dao;

import domain.User;

import java.sql.SQLException;
import java.util.ArrayList;


public interface UserDao {
     void create(User user) throws SQLException;

     User getUserByUuid(String userUuid) throws SQLException;

     void update(User user) throws SQLException;

     void delete(String userUuid);

     ArrayList getUserList() throws SQLException;

}

