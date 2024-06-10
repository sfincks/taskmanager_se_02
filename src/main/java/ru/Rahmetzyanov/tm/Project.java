package ru.Rahmetzyanov.tm;

import java.util.Date;

public class Project extends Creator{

    private int ID;
    public int getID() {
        return ID;
    }
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;


    @Override
    public void create(String name) {
        super.create(name);
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
