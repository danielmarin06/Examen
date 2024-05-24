package co.edu.poli.ces3.demo.servlets;


import co.edu.poli.ces3.demo.database.dao.Tasks;
import co.edu.poli.ces3.demo.database.repositories.UserRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "userServlet", value = "/api/tasks")
public class UserServlet extends MyServlet {

    private GsonBuilder gsonBuilder;
    private Gson gson;

    public void init(){
        gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        UserRepository repo = new UserRepository();
        try {

            String parametro = req.getParameter("id_task");

            if(parametro != null){
                int id_task = Integer.parseInt(parametro);
                Tasks task = repo.getOne(id_task);

                if(task != null){
                    out.print(gson.toJson(task));
                }
            }else{
                out.print(gson.toJson(repo.get()));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        out.flush();
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        int id = Integer.parseInt(req.getParameter("id"));
        JsonObject userUpdate = this.getParamsFromPost(req);
        UserRepository repo = new UserRepository();
        try {
            Tasks user = repo.update(userUpdate, id);
            out.println(gson.toJson(user));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        out.flush();
    }
}
