package com.example.vohiep.onlineproductsapp.model;

import android.media.Image;

import java.util.List;

public class informationevaluate
{
    public String iduser;
    public String username;
    public List<Integer> images;
    public String comment;
    public int numberstar;
    public int like;

    public informationevaluate(String iduser, String username, List<Integer> images, String comment, int numberstar, int like) {
        this.iduser = iduser;
        this.username = username;
        this.images = images;
        this.comment = comment;
        this.numberstar = numberstar;
        this.like = like;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Integer> getImages() {
        return images;
    }

    public void setImages(List<Integer> images) {
        this.images = images;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getNumberstar() {
        return numberstar;
    }

    public void setNumberstar(int numberstar) {
        this.numberstar = numberstar;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
