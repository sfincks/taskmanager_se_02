package ru.Rahmetzyanov.tm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Listener {

    Scanner scanner = new Scanner(System.in);

    Project project = new Project();
    Task task = new Task();

    Map<String, String> commands = new HashMap<>();

    public void commandListener(String command) {


        commands.put("help", "выводит список всех команд");

        commands.put("createTask", "создаёт задачу");
        commands.put("deleteTask", "удаляет задачу");
        commands.put("showTasks", "показывает все задачи");
        commands.put("showOneTask", "показывает выбранную задачу");
        commands.put("changeTask", "изменяет выбранную задачу");

        commands.put("createProject", "создаёт проект");
        commands.put("deleteProject", "удаляет проект");
        commands.put("showProjects", "показывает все проекты");
        commands.put("showOneProject", "показывает выбранный проект");
        commands.put("changeProject", "изменяет выбранный проект");

        switch (command) {
            case ("help"):
                commands.forEach((key, value) -> System.out.println(key + " - " + value));
            case ("createTask"):
                String itemName = scanner.next();
                task.create(itemName);
                break;
            case ("deleteTask"):
                itemName = scanner.next();
                task.delete(itemName);
                break;
            case ("showTasks"):
                itemName = scanner.next();
                task.showList(itemName);
                break;
            case ("showOneTask"):
                itemName = scanner.next();
                task.showOneElement(itemName);
                break;
            case ("changeTask"):
                itemName = scanner.next();
                String newItemName = scanner.next();
                project.change(itemName, newItemName);
                break;
            case ("createProject"):
                itemName = scanner.next();
                project.create(itemName);
                break;
            case ("deleteProject"):
                itemName = scanner.next();
                project.delete(itemName);
                break;
            case ("showProjects"):
                itemName = scanner.next();
                project.showList(itemName);
                break;
            case ("showOneProject"):
                itemName = scanner.next();
                project.showOneElement(itemName);
                break;
            case ("changeProject"):
                itemName = scanner.next();
                newItemName = scanner.next();
                project.change(itemName, newItemName);
                break;


        }
    }

}
