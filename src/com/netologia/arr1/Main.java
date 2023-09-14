package com.netologia.arr1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] products = {"Хлеб", "Яблоки", "Молоко"};
        int[] prices = {100, 200, 300};
        int[] quantity = {0, 0, 0};
        int productNumber = 0;
        int productCount = 0;
        int totalPrice = 0;

        System.out.println("Список возможных товаров для покупки");
        for (int i = 0; i < products.length; i++) {
            System.out.println(i + 1 + "." + " " + products[i] + " " + prices[i] + " руб/шт");
        }
        while (true) {
            System.out.println("Выберите товар и количество или введите `end`");
            String inputString = scanner.nextLine();
            if (!inputString.equals("end")) {
                String[] parts = inputString.split(" ");
                productNumber = Integer.parseInt(parts[0]);
                productCount = Integer.parseInt(parts[1]);
                quantity[productNumber - 1] = quantity[productNumber - 1] + productCount;
                totalPrice = totalPrice + productCount * prices[productNumber - 1];

            } else {
                break;
            }
        }
        System.out.println("Ваша корзина:");
        for (int q = 0; q < quantity.length; q++) {
            if (quantity[q] > 0) {
                System.out.println(products[q] + " " + quantity[q] + " шт " + prices[q] + " руб/шт " + prices[q] * quantity[q] + " руб в сумме");
            }

        }
        System.out.println("Итого " + totalPrice + " руб");
    }
}
/*
Список возможных товаров для покупки
1. Молоко 50 руб/шт
2. Хлеб 14 руб/шт
3. Гречневая крупа 80 руб/шт
Выберите товар и количество или введите `end`

Ваша корзина:
Молоко 10 шт 50 руб/шт 500 руб в сумме
Гречневая крупа 1 шт 80 руб/шт 80 руб в сумме
Итого 580 руб

 */