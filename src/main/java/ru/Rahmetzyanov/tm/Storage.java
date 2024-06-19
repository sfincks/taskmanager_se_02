package ru.Rahmetzyanov.tm;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    List<Project> projList;

    public Storage() {
        this.projList = new ArrayList<>();
    }

    public List<Project> getProjList() {
        return projList;
    }

    public void setProjList(List<Project> projList) {
        this.projList = projList;
    }
}
