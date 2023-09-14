package com.netologia.stuctofclass;

public class Main {

    public static void main(String[] args) {
        Book book = new Book("Бег", 1927, "Булгаков", 500);
        System.out.println(book.isBig());
        System.out.println(book.matches("Булг"));
        System.out.println(book.estimatePrice());
    }

}