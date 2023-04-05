package com.interactingwithapi.task2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsonPlaceholderApi {
    private String baseUrl;

    public JsonPlaceholderApi(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public List<Post> getPosts(int idUser) {
        String url = baseUrl + "/users/" + idUser + "/posts";
        String jsonPosts = "";

        try {
            jsonPosts = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .get()
                    .text();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Type type = new TypeToken<List<Post>>(){}.getType();
        Gson gson = new Gson();

        return gson.fromJson(jsonPosts, type);
    }

    public int findPostWithMaxId(List<Post> posts) {
        int maxId = posts.get(0).getIdPost();
        for (int i = 0; i < posts.size() - 1; i++) {
            if (maxId < posts.get(i + 1).getIdPost()) {
                maxId = posts.get(i + 1).getIdPost();
            }
        }

        return maxId;
    }

    public List<Comment> getAllComments(int postId) {
        String url = baseUrl + "/posts/" + postId + "/comments";

        String jsonComments = "";

        try {
            jsonComments = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .get()
                    .text();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Type type = new TypeToken<List<Comment>>(){}.getType();
        Gson gson = new Gson();

        return gson.fromJson(jsonComments, type);
    }

    public void printAllComments(List<Comment> comments) {
        for (Comment comment : comments) {
            System.out.println(comment);
            System.out.println();
        }
    }
}
