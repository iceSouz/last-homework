package com.interactingwithapi.task3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String basePath = "https://jsonplaceholder.typicode.com";

        TaskManager taskManager = new TaskManager(2, basePath);
        List<Task> allTasks = taskManager.getAllTasks();
        List<Task> openTasks = taskManager.openTasks(allTasks);
        taskManager.printOpenTasks(openTasks);
    }
}
