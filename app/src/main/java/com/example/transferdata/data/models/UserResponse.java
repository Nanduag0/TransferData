package com.example.transferdata.data.models;

import android.content.Intent;

import com.google.gson.annotations.SerializedName;

public class UserResponse
{
    @SerializedName("userId")
    Integer uid;

    @SerializedName("id")
    Integer id;

    @SerializedName("title")
     String title ;

    @SerializedName("body")
    String body;


    public UserResponse(Integer uid, Integer id, String title, String body) {
        this.id = id;
        this.uid = uid;
        this.title = title;
        this.body = body;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
