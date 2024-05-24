package ru.Rahmetzyanov.tm;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Project project = new Project();
        Task task = new Task();
        Listener listener = new Listener();


        listener.commandListener
                ();

    }


}