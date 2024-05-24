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


        commands.put("help", "выводит список всех команд");
        commands.put("exit", "выйти из программы");

        commands.put("createT", "создаёт задачу");
        commands.put("delT", "удаляет задачу");
        commands.put("showT", "показывает все задачи");
        commands.put("showOT", "показывает выбранную задачу");
        commands.put("changeT", "изменяет выбранную задачу");

        commands.put("createP", "создаёт проект");
        commands.put("delP", "удаляет проект");
        commands.put("showP", "показывает все проекты");
        commands.put("showOP", "показывает выбранный проект");
        commands.put("changeP", "изменяет выбранный проект");

        while (running) {
            System.out.println("Введите команду:");
            command = scanner.nextLine();
            switch (command) {
                case ("help"):
                    commands.forEach((key, value) -> System.out.println(key + " - " + value));
                    break;
                case ("createT"):
                    System.out.println("Введите название задачи для создания:");
                    String itemName = scanner.nextLine();
                    task.create(itemName);
                    break;
                case ("delT"):
                    System.out.println("Введите название задачи для удаления:");
                    itemName = scanner.nextLine();
                    task.delete(itemName);
                    break;
                case ("showT"):
                    task.showList();
                    break;
                case ("showOT"):
                    System.out.println("Введите название задачи, которую хотите посмотреть:");
                    itemName = scanner.nextLine();
                    task.showOneElement(itemName);
                    break;
                case ("changeT"):
                    System.out.println("Введите название задачи, котоорую хотите изменить:");
                    itemName = scanner.nextLine();
                    String newItemName = scanner.nextLine();
                    project.change(itemName, newItemName);
                    break;
                case ("createP"):
                    System.out.println("Введите название проекта для создания:");
                    itemName = scanner.nextLine();
                    project.create(itemName);
                    break;
                case ("delP"):
                    System.out.println("Введите название проекта для удаления:");
                    itemName = scanner.nextLine();
                    project.delete(itemName);
                    break;
                case ("showP"):
                    project.showList();
                    break;
                case ("showOP"):
                    System.out.println("Введите название проекта, который хотите посмотреть:");
                    itemName = scanner.nextLine();
                    project.showOneElement(itemName);
                    break;
                case ("changeP"):
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
