package com.interactingwithapi.task1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class UsersApi {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";
    private Gson gson;

    public UsersApi() {
        gson = new Gson();
    }

    public List<User> getUsers() {
        String textUsers = "";
        try {
            textUsers = Jsoup.connect(BASE_URL)
                    .ignoreContentType(true)
                    .get()
                    .text();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Type type = new TypeToken<List<User>>(){}.getType();

        return gson.fromJson(textUsers, type);
    }

    public User getUserById(int id) {
        String textUser = "";
        try {
            textUser = Jsoup.connect(BASE_URL + "/" + id)
                    .ignoreContentType(true)
                    .get()
                    .text();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return gson.fromJson(textUser, User.class);
    }

    public User getUserByUsername(String username) {
        String textUser = "";
        try {
            textUser = Jsoup.connect(BASE_URL + "?username=" + username)
                    .ignoreContentType(true)
                    .get()
                    .text();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return gson.fromJson(textUser, User[].class)[0];
    }

    public int getMaxUserId() {
        List<User> users = getUsers();
        int maxId = users.stream()
                .mapToInt(User::getId)
                .max()
                .orElseThrow(() -> new RuntimeException("Ошибка при получении максимального значения id"));

        return maxId;
    }

    public User createUser(User user) throws IOException {
        Gson gson = new Gson();
        String jsonUser = gson.toJson(user);

        Connection.Response response = Jsoup.connect(BASE_URL)
                .ignoreContentType(true)
                .header("Content-Type", "application/json; charset=UTF-8")
                .requestBody(jsonUser)
                .method(Connection.Method.POST)
                .execute();

        if (response.statusCode() == 201) {
            String jsonResponse = response.body();
            return gson.fromJson(jsonResponse, User.class);
        } else {
            throw new IOException("Ошибка при создании пользователя: статус " + response.statusCode());
        }
    }

    public User updateUser(int id, User user) throws IOException {
        Gson gson = new Gson();
        String jsonUser = gson.toJson(user);

        Connection.Response response = Jsoup.connect(BASE_URL + "/" + id)
                .ignoreContentType(true)
                .header("Content-Type", "application/json; charset=UTF-8")
                .requestBody(jsonUser)
                .method(Connection.Method.PUT)
                .execute();

        if (response.statusCode() == 200) {
            String jsonResponse = response.body();
            return gson.fromJson(jsonResponse, User.class);
        } else {
            throw new IOException("Ошибка при обновлении пользователя: статус " + response.statusCode());
        }
    }

    public boolean deleteUser(int id) throws IOException {
        Connection.Response response = Jsoup.connect(BASE_URL + "/" + id)
                .ignoreContentType(true)
                .method(Connection.Method.DELETE)
                .execute();

        if (response.statusCode() >= 200 && response.statusCode() < 300) {
            return true;
        } else {
            throw new IOException("Ошибка при удалении пользователя: статус " + response.statusCode());
        }
    }
}
