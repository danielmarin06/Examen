package co.edu.poli.ces3.demo.database.dao;

import java.util.Date;

public class Tasks {

    private int id_task;
    private String title;
    private String description;
    private String status;
    private int id_project;
    private Date createdAt;
    private Date updatedAt;

    public Tasks(int id_task, String title, String description, String status, int id_project, Date createdAt, Date updatedAt) {
        this.id_task = id_task;
        this.title = title;
        this.description = description;
        this.status = status;
        this.id_project = id_project;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Tasks(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public int getId_project() {
        return id_task;
    }

    public void setId_project(int id_task) {
        this.id_task = id_task;
    }

    public String getProject_name() {
        return title;
    }

    public void setProject_name(String title) {
        this.title = title;
    }

    public String getManager() {
        return description;
    }

    public void setManager(String description) {
        this.description = description;
    }

    public String getDetails() {
        return description;
    }

    public void setDetails(String details) {
        this.description = description;
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
