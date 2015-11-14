package dao;

import domain.Content;

import java.sql.SQLException;


public interface ContentDao {
     void create(Content content);

     Content getContentByUuid(String contentUuid) throws SQLException;

     void update(Content content);

     void delete(String contentUuid);

}
