package co.edu.poli.ces3.demo.servlets;


import co.edu.poli.ces3.demo.database.dao.Tasks;
import co.edu.poli.ces3.demo.database.repositories.ProjectsRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "projectsServlet", value = "/api/projects")
public class ProjectsServlet extends MyServlet {

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
        ProjectsRepository repo = new ProjectsRepository();
        try {



                out.print(gson.toJson(repo.get()));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        out.flush();
    }

}
