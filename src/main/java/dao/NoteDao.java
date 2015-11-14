package dao;

import domain.Note;

import java.sql.SQLException;
import java.util.ArrayList;


public interface NoteDao {

     void create(Note note) throws SQLException;

     Note getNoteByUuid(String noteUuid) throws SQLException;

     void update(Note note) throws SQLException;

     void delete(String noteUuid);

     ArrayList<Note> getNoteList() throws SQLException;

}
