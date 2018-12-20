package control;

import org.json.JSONException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public interface IControler {
    void create();
    void read();
    void update();
    void delete();
    void search();
    void imp() throws IOException, SQLException, JSONException;
    void exp() throws IOException, JSONException;
}