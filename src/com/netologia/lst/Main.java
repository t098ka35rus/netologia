package com.netologia.lst;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("0. Выход из программы");
        System.out.println("1. Добавить дело");
        System.out.println("2. Показать дела");
        System.out.println("3. Удалить дело по номеру");
        System.out.println("4. Удалить дело по названию");
        System.out.println();

        while (true) {

            System.out.print("Ваш выбор: ");
            String choice = scanner.nextLine();
            System.out.println();
            if (choice.equals("0")) {
                break;
            }
            if (choice.equals("1")) {
                System.out.print("Введите название задачи: ");
                list.add(scanner.nextLine());
                System.out.println("Добавлено!");
                print(list);

            }
            if (choice.equals("2")) {
                print(list);
            }

            if (choice.equals("3")) {
                System.out.print("Введите номер для удаления: ");
                int index = Integer.parseInt(scanner.nextLine());
                if (index > list.size()){
                    System.out.println("Нет дела с таким номером");
                    System.out.println();
                } else {
                    list.remove(index);
                    System.out.println("Удалено!");
                    print(list);
                }
            }

            if (choice.equals("4")) {
                System.out.print("Введите задачу для удаления: ");
                int count = 0;
                String st = scanner.nextLine();
                for (int i = 0; i < list.size(); i++) {
                    if (st.equals(list.get(i))) {
                        list.remove(i);
                        count++;
                    }
                }
                if (count == 0) {
                    System.out.println("Нет такого дела");
                    System.out.println();
                } else {
                    System.out.println("Удалено!");
                    print(list);
                }
            }
        }
    }

    public static void print(List<String> list) {
        System.out.println("Ваш список дел:");
        for (int l = 0; l < list.size(); l++) {
            System.out.println(l + 1 + ". " + list.get(l));
        }
        System.out.println();
    }
}

