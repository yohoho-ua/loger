package dao;

import domain.Catalog;

import java.sql.SQLException;


public interface CatalogDao {
     void create(Catalog catalog);

     Catalog getCatalogByUuid(String catalogUuid) throws SQLException;

     void update(Catalog catalog);

     void delete(String catalogUuid);

}
