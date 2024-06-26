package co.edu.poli.ces3.demo.database.dao;

import java.util.Date;

public class Projects {

    private int id_project;
    private String project_name;
    private String manager;
    private String details;
    private Date createdAt;
    private Date updatedAt;

    public Projects(int id_project, String project_name, String manager, String details, Date createdAt, Date updatedAt) {
        this.id_project = id_project;
        this.project_name = project_name;
        this.manager = manager;
        this.details = details;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Projects(String name, String lastname) {
        this.project_name = name;
        this.manager = lastname;
    }

    public int getId_project() {
        return id_project;
    }

    public void setId_project(int id_project) {
        this.id_project = id_project;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
