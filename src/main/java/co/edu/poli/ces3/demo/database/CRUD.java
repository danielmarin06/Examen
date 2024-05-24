package co.edu.poli.ces3.demo.database;

import co.edu.poli.ces3.demo.database.dao.Tasks;
import com.google.gson.JsonObject;

import java.sql.SQLException;
import java.util.List;

public interface CRUD {

    public List<Tasks> get() throws SQLException;

    public Tasks getOne(int id) throws SQLException;

    public Tasks insert();

    public Tasks update(JsonObject userUpdate, int id) throws SQLException;
}
