package co.edu.poli.ces3.demo.database;

import co.edu.poli.ces3.demo.database.dao.Projects;
import com.google.gson.JsonObject;

import java.sql.SQLException;
import java.util.List;

public interface CRUD2 {

    public List<Projects> get() throws SQLException;

    public Projects getOne(int id_project) throws SQLException;

    public Projects insert();

}
