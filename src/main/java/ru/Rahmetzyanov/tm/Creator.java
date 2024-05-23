package ru.Rahmetzyanov.tm;

import java.util.ArrayList;
import java.util.List;

abstract public class Creator {

    List<String> myList = new ArrayList<String>();

    public void create(String name) {
        myList.add(name);
    }

    public void delete(String name) {
        myList.remove(name);
    }

    public void showList(String name) {
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(i + ". " + myList.get(i));
        }
    }

    public void showOneElement(String name) {
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).equals(name))
                System.out.println(i + 1 + ". " + myList.get(i));
        }
    }

    public void change(String name, String changeTo) {
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).equals(name)) {
                myList.set(i, changeTo);
            }
        }
    }

}
