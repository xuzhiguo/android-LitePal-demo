package com.example.xuzg.litepaltest;

import org.litepal.crud.DataSupport;

public class Book extends DataSupport {
    private int id;
    private String name;
    private String author;
    private int pages;
    private float price;
    private String press;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getPress() {
        return press;
    }
}
