package com.interactingwithapi.task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class InternetDataWriter {

    public static void writePostsToFile(List<Comment> comments, int idPost, int idUser) {
        String fileName = "user-" + idUser + "-post-" + idPost + "-comments.json";

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        Type type = new TypeToken<List<Comment>>(){}.getType();
        String json = gson.toJson(comments, type);

        try(FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
