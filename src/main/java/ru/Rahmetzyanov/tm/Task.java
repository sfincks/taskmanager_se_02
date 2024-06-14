package ru.Rahmetzyanov.tm;

import java.util.Date;

public class Task extends Creator {

    Project proj = new Project();

    private int ID;

    private String name;

    private String description;
    private Date startDate;
    private Date endDate;
    private int projectID;

    public String getName() {
        return name;
    }

    @Override
    public void create(String name) {
        int ID = this.ID;

        super.create(name);
        String description = this.description;
        Date startDate = this.startDate;
        Date endDate = this.endDate;
        int projectID = this.projectID;
    }

    @Override
    public void delete(String name) {
        super.delete(name);
    }

    @Override
    public void showList() {
        super.showList();
    }

    @Override
    public void showOneElement(String name) {
        super.showOneElement(name);
    }

    @Override
    public void change(String name, String changeTo) {
        super.change(name, changeTo);
    }
}
