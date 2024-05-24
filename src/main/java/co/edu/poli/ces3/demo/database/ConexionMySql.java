package co.edu.poli.ces3.demo.database;

import java.sql.*;

public class ConexionMySql {

    private int port;
    private String host;
    private String user;
    private String password;
    private String dataBaseName;
    public static final long SERIAL = 1L;

    private Connection cnn;
    public ConexionMySql(String host){
        user = "root";
        password = "";
        this.port = 3306;
        this.host= host != null ? host : "127.0.0.1";
        this.dataBaseName = "examen";
    }


    public void disconect() throws SQLException {
        if(cnn != null)
            cnn.close();
    }
    public Connection conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnn = DriverManager.getConnection( "jdbc:mysql://" +host+":"+port+"/"+ dataBaseName, user, password);
            return cnn;
        }catch (ClassNotFoundException | SQLException exception){
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        return null;
    }
}
