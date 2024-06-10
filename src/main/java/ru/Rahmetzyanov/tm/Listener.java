package ru.Rahmetzyanov.tm;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Listener {

    private Scanner scanner = new Scanner(System.in);

    private Project projectContainer = new Project();
    private Task taskContainer = new Task();

    private Map<String, String> commands = new LinkedHashMap<>();

    public void commandListener() {

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

        boolean running = true;
        while (running) {
            System.out.println("Введите команду:");
            String command = scanner.nextLine();
            switch (command) {
                case ("help"):
                    commands.forEach((key, value) -> System.out.println(key + " - " + value));
                    break;
                case ("createT"):
                    System.out.println("Введите название задачи для создания:");
                    String itemName = scanner.nextLine();
                    taskContainer.create(itemName);
                    break;
                case ("delT"):
                    System.out.println("Введите название задачи для удаления:");
                    itemName = scanner.nextLine();
                    taskContainer.delete(itemName);
                    break;
                case ("showT"):
                    taskContainer.showList();
                    break;
                case ("showOT"):
                    System.out.println("Введите название задачи, которую хотите посмотреть:");
                    itemName = scanner.nextLine();
                    taskContainer.showOneElement(itemName);
                    break;
                case ("changeT"):
                    System.out.println("Введите название задачи, котоорую хотите изменить:");
                    itemName = scanner.nextLine();
                    String newItemName = scanner.nextLine();
                    projectContainer.change(itemName, newItemName);
                    break;
                case ("createP"):
                    System.out.println("Введите название проекта для создания:");
                    itemName = scanner.nextLine();
                    projectContainer.create(itemName);
                    break;
                case ("delP"):
                    System.out.println("Введите название проекта для удаления:");
                    itemName = scanner.nextLine();
                    projectContainer.delete(itemName);
                    break;
                case ("showP"):
                    projectContainer.showList();
                    break;
                case ("showOP"):
                    System.out.println("Введите название проекта, который хотите посмотреть:");
                    itemName = scanner.nextLine();
                    projectContainer.showOneElement(itemName);
                    break;
                case ("changeP"):
                    System.out.println("Введите название проекта, который хотите изменить:");
                    itemName = scanner.nextLine();
                    newItemName = scanner.nextLine();
                    projectContainer.change(itemName, newItemName);
                    break;
                case ("exit"):
                    running = false;
                    break;
            }
        }
    }
}
