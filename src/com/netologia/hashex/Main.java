package com.netologia.hashex;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<Address, Integer> costPerAddress = new HashMap<>();
        List<String> countryList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Address address = new Address("Россия", "Москва");
        Address address1 = new Address("Россия", "Спб");
        Address address2 = new Address("США", "Питсбург");
        Address address3 = new Address("Китай", "Пекин");

        costPerAddress.put(address, 10);
        costPerAddress.put(address1, 12);
        costPerAddress.put(address2, 25);
        costPerAddress.put(address3, 45);

        String coutry;
        String city;
        String input;
        int weight;
        int sum = 0;

        while (true) {
            System.out.println();
            System.out.println("Заполнение нового заказа.");
            System.out.print("Введите страну: ");
            input = scanner.nextLine();
            if ((input.equals("end"))) {
                break;
            } else {
                coutry = input;
                System.out.print("Введите город: ");
                input = scanner.nextLine();
                if ((input.equals("end"))) {
                    break;
                } else {
                    city = input;
                    System.out.print("Введите вес (кг):");
                    input = scanner.nextLine();
                    if ((input.equals("end"))) {
                        break;
                    }
                    weight = Integer.parseInt(input);
                }
            }
            Address address4 = new Address(coutry, city);
            if (costPerAddress.containsKey(address4)) {
                if (!countryList.contains(coutry)) {
                    countryList.add(coutry);
                }
                int cost = costPerAddress.get(address4) * weight;
                sum = sum + cost;
                System.out.println("Стоимость доставки составит: " + cost + " руб.");
                System.out.println("Общая стоимость всех доставок: " + sum + " руб.");
                System.out.println("Количество стран доставки: " + countryList.size());

            } else {
                System.out.println("Доставки по этому адресу нет");
            }

        }
    }
}
