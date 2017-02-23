package com.example.quyetchu.trainninggithub.entity;

/**
 * Created by QuyetChu on 2/22/17.
 */
public class User {
    private String name;
    private String job;
    private int idAvatar;

    public User(String name, String job, int idAvatar){
        this.name = name;
        this.job = job;
        this.idAvatar = idAvatar;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public int getIdAvatar() {
        return idAvatar;
    }

    public void setName(String name) {
        this.name = name;
    }
}
