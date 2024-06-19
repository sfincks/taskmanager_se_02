package ru.Rahmetzyanov.tm;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Project {

    private int ID;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;

    List<Task> projTasks;

    public Project(int ID, String name, String description, Date startDate, Date endDate) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projTasks = new ArrayList<>();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Task> getProjTasks() {
        return projTasks;
    }

    public void setProjTasks(List<Task> projTasks) {
        this.projTasks = projTasks;
    }
}
