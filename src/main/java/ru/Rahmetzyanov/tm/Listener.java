package ru.Rahmetzyanov.tm;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Listener implements Const {

    private Scanner scanner = new Scanner(System.in);

    private Project projectContainer = new Project();
    private Task taskContainer = new Task();

    private Map<String, String> commands = new LinkedHashMap<>();

    public void commandListener() {

        commands.put(HELP, "выводит список всех команд");
        commands.put(EXIT, "выйти из программы");

        commands.put(CREATE_TASK, "создаёт задачу");
        commands.put(DELETE_TASK, "удаляет задачу");
        commands.put(SHOW_ALL_TASKS, "показывает все задачи");
        commands.put(SHOW_TASK, "показывает выбранную задачу");
        commands.put(CHANGE_TASK, "изменяет выбранную задачу");

        commands.put(CREATE_PROJECT, "создаёт проект");
        commands.put(DELETE_PROJECT, "удаляет проект");
        commands.put(SHOW_ALL_PROJECTS, "показывает все проекты");
        commands.put(SHOW_PROJECT, "показывает выбранный проект");
        commands.put(CHANGE_PROJECT, "изменяет выбранный проект");

        boolean running = true;
        while (running) {
            System.out.println("Введите команду:");
            String command = scanner.nextLine();
            switch (command) {
                case (HELP):
                    commands.forEach((key, value) -> System.out.println(key + " - " + value));
                    break;
                case (CREATE_TASK):
                    System.out.println("Введите название задачи для создания:");
                    String itemName = scanner.nextLine();
                    taskContainer.create(itemName);
                    break;
                case (DELETE_TASK):
                    System.out.println("Введите название задачи для удаления:");
                    itemName = scanner.nextLine();
                    taskContainer.delete(itemName);
                    break;
                case (SHOW_ALL_TASKS):
                    taskContainer.showList();
                    break;
                case (SHOW_TASK):
                    System.out.println("Введите название задачи, которую хотите посмотреть:");
                    itemName = scanner.nextLine();
                    taskContainer.showOneElement(itemName);
                    break;
                case (CHANGE_TASK):
                    System.out.println("Введите название задачи, котоорую хотите изменить:");
                    itemName = scanner.nextLine();
                    String newItemName = scanner.nextLine();
                    projectContainer.change(itemName, newItemName);
                    break;
                case (CREATE_PROJECT):
                    System.out.println("Введите название проекта для создания:");
                    itemName = scanner.nextLine();
                    projectContainer.create(itemName);
                    break;
                case (DELETE_PROJECT):
                    System.out.println("Введите название проекта для удаления:");
                    itemName = scanner.nextLine();
                    projectContainer.delete(itemName);
                    break;
                case (SHOW_ALL_PROJECTS):
                    projectContainer.showList();
                    break;
                case (SHOW_PROJECT):
                    System.out.println("Введите название проекта, который хотите посмотреть:");
                    itemName = scanner.nextLine();
                    projectContainer.showOneElement(itemName);
                    break;
                case (CHANGE_PROJECT):
                    System.out.println("Введите название проекта, который хотите изменить:");
                    itemName = scanner.nextLine();
                    newItemName = scanner.nextLine();
                    projectContainer.change(itemName, newItemName);
                    break;
                case (EXIT):
                    running = false;
                    break;
            }
        }
    }
}
