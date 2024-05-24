package co.edu.poli.ces3.demo.database;

import co.edu.poli.ces3.demo.database.dao.Projects;
import com.google.gson.JsonObject;

import java.sql.SQLException;
import java.util.List;

public interface CRUD {

    public List<Projects> get() throws SQLException;

    public Projects getOne(int id) throws SQLException;

    public Projects insert();

    public Projects update(JsonObject userUpdate, int id) throws SQLException;
}
