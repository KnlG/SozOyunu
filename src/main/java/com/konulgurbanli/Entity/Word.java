package com.konulgurbanli.Entity;

/**
 * Created by Konul Gurbanli on 5/31/2017.
 */
public class Word {
    private int id;
    private String content;
    private int length;

    public Word(int id, String content, int length) {
        this.id = id;
        this.content = content;
        this.length = length;
    }

    public Word() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
