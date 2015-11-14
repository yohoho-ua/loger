package dao.impl;

import dao.CatalogDao;
import dao.ConnectionProvider;
import domain.Catalog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static dao.impl.GenericDaoMethods.genericDelete;


public class CatalogDaoImpl implements CatalogDao {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public CatalogDaoImpl() throws SQLException {
            connection = ConnectionProvider.getConnection();
    }


    public void create(Catalog catalog) {
        try {
            preparedStatement = connection.prepareStatement
                    ("INSERT INTO CATALOGS (UUID, name, parent_UUID) VALUES (?, ?, ?)");
            preparedStatement.setString(1, catalog.getUuid());
            preparedStatement.setString(2, catalog.getName());
            preparedStatement.setString(3, catalog.getParentUuid());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Catalog getCatalogByUuid(String catalogUuid) throws SQLException {
        Catalog catalog = new Catalog();
        preparedStatement= connection.prepareStatement("SELECT * FROM CATALOGS WHERE UUID=?");
        preparedStatement.setString(1, catalogUuid);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            catalog.setUuid(rs.getString("UUID"));
            catalog.setName(rs.getString("name"));
            catalog.setUuid(rs.getString("parent_UUID"));
        }
        return catalog;
    }

    public void update(Catalog catalog) {
        try {
            preparedStatement = connection.prepareStatement
                    ("UPDATE CATALOGS SET name=?, parent_UUID=? WHERE UUID=?");
            preparedStatement.setString(1, catalog.getName());
            preparedStatement.setString(2, catalog.getParentUuid());
            preparedStatement.setString(3, catalog.getUuid());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(String catalogUuid) {
        genericDelete(catalogUuid, "CATALOGS");
    }
}
