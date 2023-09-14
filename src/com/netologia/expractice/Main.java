package com.netologia.expractice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PasswordChecker checker = new PasswordChecker();
        Scanner scanner = new Scanner(System.in);
        String password;
        System.out.print("Введите мин. длину пароля: ");
        try {
            checker.setMinlength(Integer.parseInt(scanner.nextLine()));
            System.out.println();
            System.out.print("Введите макс. допустимое количество повторений символа подряд: ");

            checker.setMaxrepeats(Integer.parseInt(scanner.nextLine()));
        } catch (NumberFormatException e) {
            throw new IllegalStateException("Введи число!");
        }


        while (true) {
            System.out.print("Введите пароль или end: ");
            try {
                password = scanner.nextLine();
            } catch (RuntimeException e) {
                throw new IllegalStateException("Пароль не корректный");
            }
            if (!password.equals("end")) {
                if (checker.verify(password)) {
                    System.out.println("Подходит!");
                } else {
                    System.out.println("Не подходит!");
                }
            } else {
                System.out.println("Программа завершена");
                break;
            }


        }

    }
}
