package ru.Rahmetzyanov.tm;

import java.sql.SQLOutput;
import java.util.*;

public class Listener implements Const {
    private Storage storage;

    private Scanner scanner;

    private Map<String, String> commands;

    public Listener() {
        this.storage = new Storage();
        this.scanner = new Scanner(System.in);
        this.commands = new LinkedHashMap<>();
// CRUD операции для каждой таски/проджекта
        //Create
        //Show/show all
        //Update
        //Delete
        //
        commands.put(HELP, "выводит список всех команд");
        commands.put(EXIT, "выйти из программы");

        commands.put(CREATE_PROJECT, "создаёт проект");
        commands.put(DELETE_PROJECT, "удаляет проект");
        commands.put(SHOW_ALL_PROJECTS, "показывает все проекты");
        commands.put(SHOW_PROJECT, "показывает выбранный проект");
        commands.put(CHANGE_PROJECT, "изменяет выбранный проект");
        commands.put(ADD_TASK_TO_PROJECT, "добавляет задачу в проект");
        commands.put(SHOW_PROJECT_TASKS, "показывает задачи в проекте");

        commands.put(DELETE_TASK, "удаляет задачу");
        commands.put(SHOW_ALL_TASKS, "показывает все задачи");
        commands.put(SHOW_TASK, "показывает выбранную задачу");
        commands.put(CHANGE_TASK, "изменяет выбранную задачу");
    }
//    private Object findProj(Storage storage){
//        Optional<Project> findedProj = storage.projList.stream().filter(x -> x.getName().equals(storage)).findFirst();
//        return findedProj;
//    }

    public void commandListener() {
        boolean running = true;
        while (running) {
            System.out.println("Введите команду:");
            String command = scanner.nextLine();
            switch (command) {
                case (HELP):
                    commands.forEach((key, value) -> System.out.println(key + " - " + value));
                    break;
                case (CREATE_PROJECT):
                    System.out.println("Введите название проекта для создания:");
                    String projName = scanner.nextLine();
                    for (Project project : storage.projList) {
                        if (project.getName().equals(projName)) {
                            System.out.println("Проект с таким названием уже существует");
                            break;
                        }
                    }
                    System.out.println("Введите описание проекта для создания:");
                    String projDescription = scanner.nextLine();
                    int projID = 0;
                    Project proj = new Project(projID, projName, projDescription, new Date(), new Date());
                    storage.projList.add(proj);
                    projID++;
                    break;
                case (SHOW_PROJECT):
                    System.out.println("Введите название проекта, который хотите посмотреть:");
                    projName = scanner.nextLine();
                    Optional<Project> findedProj = storage.projList.stream().filter(x -> x.getName().equals(projName)).findFirst();
                    if (findedProj.isEmpty()) {
                        System.out.println("Проекта с таким названием не существует");
                        break;
                    } else {
                        System.out.println("Проект: " + findedProj.get().getName() + " Описание: " + findedProj.get().getDescription());
                    }
                    break;
                case (SHOW_ALL_PROJECTS):
                    int i = 1;
                    for (Project item : storage.projList) {
                        System.out.println(i + ". " + item.getName() + " Описание: " + item.getDescription());
                        i++;
                    }
                    break;
                case (CHANGE_PROJECT):
                    System.out.println("Введите название проекта, который хотите изменить:");
                    projName = scanner.nextLine();
                    System.out.println("Введите новое название проекта:");
                    String newProjName = scanner.nextLine();
                    Optional<Project> newFindedProj = storage.projList.stream().filter(x -> x.getName().equals(projName)).findFirst();
                    if (newFindedProj.isEmpty()) {
                        System.out.println("Проекта с таким названием не существует");
                        break;
                    } else {
                        newFindedProj.get().setName(newProjName);
                        System.out.println("Название проекта изменено с " + projName + " на " + newProjName);
                    }
                    break;
                case (DELETE_PROJECT):
                    System.out.println("Введите название проекта для удаления:");
                    projName = scanner.nextLine();
                    Optional<Project> deletedProj = storage.projList.stream().filter(x -> x.getName().equals(projName)).findFirst();
                    if (deletedProj.isEmpty()) {
                        System.out.println("Проекта с таким названием не существует");
                        break;
                    } else {
                        storage.projList.remove(deletedProj.get());
                        System.out.println("Проект под названием " + projName + " был удалён");
                    }
                    break;
                case (ADD_TASK_TO_PROJECT):
                    System.out.println("Введите название проекта:");
                    projName = scanner.nextLine();
                    String finalProjName = projName;
                    Optional<Project> optionalProject = storage.getProjList().stream()
                            .filter(x -> x.getName().equals(finalProjName))
                            .findFirst();
                    if (optionalProject.isEmpty()) {
                        System.out.println("Проекта с таким названием не существует");
                        break;
                    }
                    Project findedProject = optionalProject.get();
                    System.out.println("Введите название задачи:");
                    String itemName = scanner.nextLine();
                    System.out.println("Введите описание задачи:");
                    String itemDescription = scanner.nextLine();
                    int taskID = 0;
                    Task task = new Task(taskID, itemName, itemDescription, new Date(), new Date(), findedProject.getID());
                    taskID++;
                    findedProject.getProjTasks().add(task);
                    System.out.println("Задача " + itemName + " добавлена в проект " + findedProject.getName());
                    break;
                case (SHOW_PROJECT_TASKS):
                    System.out.println("Введите название проекта:");
                    String prjctName = scanner.nextLine();
                    Optional<Project> shownPoject = storage.getProjList().stream()
                            .filter(x -> x.getName().equals(prjctName))
                            .findFirst();
                    if (shownPoject.isEmpty()) {
                        System.out.println("Проекта с таким названием не существует");
                        break;
                    }
                    int j = 1;
                    for (Task item : shownPoject.get().projTasks) {
                        System.out.println(j + ". " + item.getName() + " Описание: " + item.getDescription());
                        j++;
                    }
                    break;
                case (DELETE_TASK):
                    System.out.println("Введите название задачи для удаления:");
                    itemName = scanner.nextLine();
                    for (Project project : storage.projList) {
                        for (Task task1 : project.projTasks) {
                            if (task1.getName().equals(itemName)) {
                                project.projTasks.remove(task1);
                                break;
                            }
                        }
                    }
                    System.out.println("Задачи с таким названием не существует");
                    break;
                case (SHOW_ALL_TASKS):
                    for (Project project : storage.projList) {
                        System.out.println("Проект " + project.getName() + " Задачи:");
                        for (Task task1 : project.projTasks) {
                            if (project.projTasks.isEmpty()){
                                System.out.println("Нет задач");
                            }else {
                                System.out.println(task1.getName() + " Описание: " + task1.getDescription());
                            }
                        }
                    }
                    break;
                case (SHOW_TASK):
                    System.out.println("Введите название задачи:");
                    itemName = scanner.nextLine();
                    for (Project project : storage.projList) {
                        for (Task task1 : project.projTasks) {
                            if (task1.getName().equals(itemName)) {
                                System.out.println("Проект: "+ project.getName()+ " Задача: " + task1.getName() + " Описание: " + task1.getDescription());
                                break;
                            }
                        }
                    }
                    System.out.println("Задачи с таким названием не существует");
                    break;
                case (CHANGE_TASK):
                    System.out.println("Введите название задачи для изменения:");
                    itemName = scanner.nextLine();
                    System.out.println("Введите новое название задачи:");
                    String newItemName = scanner.nextLine();
                    for (Project project : storage.projList) {
                        for (Task task1 : project.projTasks) {
                            if (task1.getName().equals(itemName)) {
                                task1.setName(newItemName);
                                break;
                            }
                        }
                    }
                    System.out.println("Задачи с таким названием не существует");
                    break;
                    /**
                     нужен хелп с CHANGE_TASK
                     в конце цикла выводит сообщение
                    */
                case (EXIT):
                    running = false;
                    break;
            }
        }
    }
}
