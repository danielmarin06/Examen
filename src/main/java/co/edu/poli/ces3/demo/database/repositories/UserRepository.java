package co.edu.poli.ces3.demo.database.repositories;

import co.edu.poli.ces3.demo.database.CRUD;
import co.edu.poli.ces3.demo.database.ConexionMySql;
import co.edu.poli.ces3.demo.database.dao.Projects;
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
    public List<Projects> get() throws SQLException {
        Connection con = cnnMysql.conexion();
        Statement sts = con.createStatement();
        ResultSet rs = sts.executeQuery("SELECT * FROM projects");
        List<Projects> list = new ArrayList<>();

        while (rs.next()){
            list.add(new Projects(
                    rs.getInt("id_project"),
                    rs.getString("project_name"),
                    rs.getString("manager"),
                    rs.getString("details"),
                    rs.getDate("createdAt"),
                    rs.getDate("updatedAt")
            ));
        }

        rs.close();
        sts.close();
        con.close();

        return list;
    }

    @Override
    public Projects getOne(int id_project) throws SQLException {
        Connection con = cnnMysql.conexion();
        PreparedStatement sts = con.prepareStatement("SELECT * FROM projects WHERE id_project = ?");
        sts.setInt(1,id_project);
        ResultSet rs = sts.executeQuery();
        if(rs.next())
            return new Projects(
                    rs.getInt("id_project"),
                    rs.getString("project_name"),
                    rs.getString("manager"),
                    rs.getString("details"),
                    rs.getDate("createdAt"),
                    rs.getDate("updatedAt")
            );
        return null;
    }

    @Override
    public Projects insert() {
        return null;
    }

    @Override
    public Projects update(JsonObject userUpdate, int id) throws SQLException {
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
