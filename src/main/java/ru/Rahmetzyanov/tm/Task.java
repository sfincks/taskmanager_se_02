package ru.Rahmetzyanov.tm;

import java.util.Date;

public class Task {

    private int ID;

    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private int projectID;

    public Task(int ID, String name, String description, Date startDate, Date endDate, int projectID) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectID = projectID;
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

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    //    public void create(String name, Project project) {
//        int ID = this.ID;
//        String description = this.description;
//        Date startDate = this.startDate;
//        Date endDate = this.endDate;
//        int projectID = this.projectID;
//    }
//
//
//    public void delete(String name) {
//        //удалять задачу нужно из проекта
//        projList.remove(name);
//    }
//
//
//    public void showList() {
//        // лист для тасков не создаётся
//        super.showList();
//    }
//
//
//    public void showOneElement(String name) {
//        super.showOneElement(name);
//    }
//
//    @Override
//    public void change(String name, String changeTo) {
//        super.change(name, changeTo);
//    }
}
