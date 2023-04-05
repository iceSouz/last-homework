package com.interactingwithapi.task2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        JsonPlaceholderApi api = new JsonPlaceholderApi("https://jsonplaceholder.typicode.com");

        List<Post> posts = api.getPosts(1);
        int maxPostId = api.findPostWithMaxId(posts);
        List<Comment> comments = api.getAllComments(maxPostId);
        api.printAllComments(comments);
        InternetDataWriter.writePostsToFile(comments, maxPostId, 1);
    }
}
