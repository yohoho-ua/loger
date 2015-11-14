package dao.impl;

import dao.ConnectionProvider;
import dao.NoteDao;
import domain.Note;

import java.sql.*;
import java.util.ArrayList;

import static dao.impl.GenericDaoMethods.genericDelete;


public class NoteDaoImpl implements NoteDao {

    public NoteDaoImpl() throws SQLException {
    }

    public void create(Note note) throws SQLException {

        try (
                Connection connection = ConnectionProvider.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement
                        ("INSERT INTO NOTES (UUID, title, create_time, update_time, owner, catalog_UUID, content_UUID) " +
                                "VALUES (?, ?, ?, ?, ?, ?, ?)")) {

            preparedStatement.setString(1, note.getUuid());
            preparedStatement.setString(2, note.getTitle());
            preparedStatement.setDate(3, new Date(note.getDate_created().getTime()));
            preparedStatement.setDate(4, new Date(note.getDate_updated().getTime()));
            preparedStatement.setString(5, note.getOwner());
            preparedStatement.setString(6, note.getCatalog());
            preparedStatement.setString(7, note.getContent());
            preparedStatement.executeUpdate();
        }

    }

    public Note getNoteByUuid(String noteUuid) throws SQLException {
        Note note = new Note();
        try (
                Connection connection = ConnectionProvider.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM NOTES WHERE UUID=?")
        ) {
            preparedStatement.setString(1, noteUuid);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    note.setUuid(rs.getString("UUID"));
                    note.setTitle(rs.getString("title"));
                    note.setDate_created(rs.getDate("create_time"));
                    note.setDate_updated(rs.getDate("update_time"));
                    note.setOwner(rs.getString("owner"));
                    note.setCatalog(rs.getString("catalog_UUID"));
                    note.setContent(rs.getString("content_UUID"));
                }
            }
        }
        return note;
    }

    public void update(Note note) throws SQLException {
        try (Connection connection = ConnectionProvider.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("UPDATE NOTES SET " +
                             "title=?, create_time=?, update_time=?, owner=?, catalog_UUID=?, content_UUID=?" +
                             "WHERE UUID=?")
        ) {
            preparedStatement.setString(1, note.getTitle());
            preparedStatement.setDate(2, new Date(note.getDate_created().getTime()));
            preparedStatement.setDate(3, new Date(note.getDate_updated().getTime()));
            preparedStatement.setString(4, note.getOwner());
            preparedStatement.setString(5, note.getCatalog());
            preparedStatement.setString(6, note.getContent());
            preparedStatement.setString(7, note.getUuid());
            preparedStatement.executeUpdate();
        }

    }

    public void delete(String noteUuid) {
        genericDelete(noteUuid, "NOTES");
        genericDelete(noteUuid, "CONTENT");

    }

    public ArrayList<Note> getNoteList() throws SQLException {
        ArrayList<Note> noteList = new ArrayList<Note>();
        try (Connection connection = ConnectionProvider.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM NOTES")
        ) {
            while (rs.next()) {
                Note tempNote = new Note();
                tempNote.setId(rs.getInt("id"));
                tempNote.setUuid(rs.getString("UUID"));
                tempNote.setTitle(rs.getString("title"));
                tempNote.setDate_created(rs.getDate("create_time"));
                tempNote.setDate_updated(rs.getDate("update_time"));
                tempNote.setOwner(rs.getString("owner"));
                tempNote.setCatalog(rs.getString("catalog_UUID"));
                tempNote.setContent(rs.getString("content_UUID"));
                noteList.add(tempNote);
            }
        }
        return noteList;
    }
}
