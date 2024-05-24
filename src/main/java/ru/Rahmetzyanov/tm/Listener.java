package ru.Rahmetzyanov.tm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Listener {

    Scanner scanner = new Scanner(System.in);

    Project project = new Project();
    Task task = new Task();

    Map<String, String> commands = new HashMap<>();

    public void commandListener() {

        String command = "";
        System.out.println(commands);
        boolean running = true;


        commands.put("helpMe", "выводит список всех команд");
        commands.put("exit", "выйти из программы");

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
        while (running) {
            System.out.println("Введите команду:");
            command = scanner.nextLine();
            switch (command) {
                case ("helpMe"):
                    commands.forEach((key, value) -> System.out.println(key + " - " + value));
                    break;
                case ("createTask"):
                    System.out.println("Введите название задачи для создания:");
                    String itemName = scanner.nextLine();
                    task.create(itemName);
                    break;
                case ("deleteTask"):
                    System.out.println("Введите название задачи для удаления:");
                    itemName = scanner.nextLine();
                    task.delete(itemName);
                    break;
                case ("showTasks"):
                    itemName = scanner.nextLine();
                    task.showList(itemName);
                    break;
                case ("showOneTask"):
                    System.out.println("Введите название задачи, которую хотите посмотреть:");
                    itemName = scanner.nextLine();
                    task.showOneElement(itemName);
                    break;
                case ("changeTask"):
                    System.out.println("Введите название задачи, котоорую хотите изменить:");
                    itemName = scanner.nextLine();
                    String newItemName = scanner.nextLine();
                    project.change(itemName, newItemName);
                    break;
                case ("createProject"):
                    System.out.println("Введите название проекта для создания:");
                    itemName = scanner.nextLine();
                    project.create(itemName);
                    break;
                case ("deleteProject"):
                    System.out.println("Введите название проекта для удаления:");
                    itemName = scanner.nextLine();
                    project.delete(itemName);
                    break;
                case ("showProjects"):
                    itemName = scanner.nextLine();
                    project.showList(itemName);
                    break;
                case ("showOneProject"):
                    System.out.println("Введите название проекта, который хотите посмотреть:");
                    itemName = scanner.nextLine();
                    project.showOneElement(itemName);
                    break;
                case ("changeProject"):
                    System.out.println("Введите название проекта, который хотите изменить:");
                    itemName = scanner.nextLine();
                    newItemName = scanner.nextLine();
                    project.change(itemName, newItemName);
                    break;
                case ("exit"):
                    running = false;
                    break;
            }
        }
    }

}
