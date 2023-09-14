package com.netologia.stuctofclass;

public class Book {
    String title;
    int releaseYear;
    String author;
    int pages;

    public Book(String title, int releaseYear, String author, int pages) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.author = author;
        this.pages = pages;
    }

    public boolean isBig() {
        boolean match;
        if (pages > 500) {
            match = true;
        } else {
            match = false;
        }
        return match;
    }

    public boolean matches(String word) {
        boolean match;
        if (title.contains(word) || author.contains(word)) {
            match = true;
        } else {
            match = false;
        }
        return match;
    }

    public int estimatePrice() {
        int price = pages * 3;
        if (price <= 250) {
            return 250;
        } else {
            return price;
        }

    }
}
