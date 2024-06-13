package ru.Rahmetzyanov.tm;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Project extends Creator {

    private int ID;

    private String name;

    private String description;
    private Date startDate;
    private Date endDate;
    private List<String> projTasks = new LinkedList<String>();
    @Override
    public void create(String name) {
        this.name = name;
        int ID = this.ID;
        String description = this.description;
        Date startDate = this.startDate;
        Date endDate = this.endDate;
        List<String> projTasks = this.projTasks;
    }

    public String getName() {
        return name;
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

    public int getID() {
        return ID;
    }

    public void addTaskToProj(String task) {
        projTasks.add(task);
    }

    public void showProjTasks () {
        int i = 1;
        for (String item : projTasks) {
            System.out.println(i + ". " + item);
            i++;
        }
    }

    public void deletingProjTasks (Project project){
        projTasks.removeAll(projTasks);
    }
}
