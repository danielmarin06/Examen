package co.edu.poli.ces3.demo.database.repositories;

import co.edu.poli.ces3.demo.database.CRUD;
import co.edu.poli.ces3.demo.database.ConexionMySql;
import co.edu.poli.ces3.demo.database.dao.Tasks;
import com.google.gson.JsonObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements CRUD {

    private ConexionMySql cnnMysql;

    public UserRepository(){
        cnnMysql = new ConexionMySql("localhost");
    }



    @Override
    public List<Tasks> get() throws SQLException {
        Connection con = cnnMysql.conexion();
        Statement sts = con.createStatement();
        ResultSet rs = sts.executeQuery("SELECT * FROM tasks");
        List<Tasks> list = new ArrayList<>();

        while (rs.next()){
            list.add(new Tasks(
                    rs.getInt("id_task"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("status"),
                    rs.getInt("id_project"),
                    rs.getDate("created_at"),
                    rs.getDate("updated_at")
            ));
        }

        rs.close();
        sts.close();
        con.close();

        return list;
    }

    @Override
    public Tasks getOne(int id_project) throws SQLException {
        Connection con = cnnMysql.conexion();
        PreparedStatement sts = con.prepareStatement("SELECT * FROM tasks WHERE id_project = ?");
        sts.setInt(1,id_project);
        ResultSet rs = sts.executeQuery();
        if(rs.next())
            return new Tasks(
                    rs.getInt("id_task"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("status"),
                    rs.getInt("id_project"),
                    rs.getDate("created_at"),
                    rs.getDate("updated_at")
            );
        return null;

    }

    @Override
    public Tasks insert() {
        return null;
    }

    @Override
    public Tasks update(JsonObject userUpdate, int id) throws SQLException {
        String sql = "UPDATE users SET name = ?, lastName = ?, mail = ?, password = ?, updatedAt = now() WHERE id = ?";
        Connection cnn = this.cnnMysql.conexion();
        PreparedStatement sts = cnn.prepareStatement(sql);
        sts.setString(1, userUpdate.get("name").getAsString());
        sts.setString(2, userUpdate.get("lastName").getAsString());
        sts.setString(3, userUpdate.get("mail").getAsString());
        sts.setString(4, userUpdate.get("password").getAsString());
        sts.setInt(5, id);
        sts.execute();
        return this.getOne(id);
    }

    public void disconect() throws SQLException {
        cnnMysql.disconect();
    }
}
