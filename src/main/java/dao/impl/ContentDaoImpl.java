package dao.impl;

import dao.ConnectionProvider;
import dao.ContentDao;
import domain.Content;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static dao.impl.GenericDaoMethods.genericDelete;


public class ContentDaoImpl implements ContentDao {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public ContentDaoImpl() throws SQLException {
            connection = ConnectionProvider.getConnection();
    }

    public void create(Content content) {
        try {
            preparedStatement = connection.prepareStatement
                    ("INSERT INTO CONTENT (UUID, content) values (?, ?)");
            preparedStatement.setString(1, content.getUuid());
            preparedStatement.setString(2, content.getText());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Content getContentByUuid(String contentUuid) throws SQLException {
        Content content = new Content();
        preparedStatement = connection.prepareStatement("SELECT * FROM CONTENT WHERE UUID=?");
        preparedStatement.setString(1, contentUuid);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            content.setUuid(rs.getString("UUID"));
            content.setText(rs.getString("content"));
        }

        return content;
    }

    public void update(Content content) {
        try {
            preparedStatement = connection.prepareStatement
                    ("UPDATE CONTENT SET content=? WHERE UUID =?");
            preparedStatement.setString(1, content.getText());
            preparedStatement.setString(2, content.getUuid());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String contentUuid) {
        genericDelete(contentUuid, "CONTENT");
    }


}
