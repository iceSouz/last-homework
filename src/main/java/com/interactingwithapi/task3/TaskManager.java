package com.interactingwithapi.task3;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private int userId;
    private String basePath;

    public TaskManager(int userId, String basePath) {
        this.userId = userId;
        this.basePath = basePath;
    }

    public List<Task> getAllTasks() {
        String url = basePath + "/users/" + userId + "/todos";
        String jsonTasks = "";

        try {
            jsonTasks = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .get()
                    .text();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<List<Task>>(){}.getType();

        return gson.fromJson(jsonTasks, type);
    }

    public List<Task> openTasks(List<Task> tasks) {
        List<Task> openTasks = new ArrayList<>();

        for (Task task : tasks) {
            if (!task.getCompleted()) {
                openTasks.add(task);
            }
        }

        return openTasks;
    }

    public void printOpenTasks(List<Task> openTasks) {
        for (Task openTask : openTasks) {
            System.out.println(openTask);
            System.out.println();
        }
    }
}
