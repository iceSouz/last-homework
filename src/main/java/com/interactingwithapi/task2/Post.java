package com.interactingwithapi.task2;

import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("id")
    private int idPost;

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    @Override
    public String toString() {
        return "id_post = " + idPost;
    }
}
