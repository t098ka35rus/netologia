package com.netologia.recursion;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        compare(1);
        compare(2);
        compare(3);
        compare(4);
        compare(5);
        compare(15);

    }

    public static void compare(int day) {
        System.out.println("=== Day " + day + " ===");
        int[] startNumbers = {21, 1, 20, 23};
        int iterative = chooseHobbyIterative(startNumbers, day);
        int recursive = chooseHobbyRecursive(startNumbers, day, new int[day]);
        System.out.println("Iterative = " + iterative + " | Recursive = " + recursive);
        System.out.println();
    }

    public static int chooseHobbyRecursive(int[] startNumbers, int day, int[] memory) {
        int prev;
        int prePrePrev;
        if (day <= startNumbers.length - 3) {// day = 1
            prev = startNumbers[startNumbers.length - 1];
            prePrePrev = startNumbers[startNumbers.length - 3];
            if (memory[day - 1] != 0) {
                System.out.println(">>> " + day);
                return memory[day - 1];
            }
            memory[day - 1] = (prev * prePrePrev) % 10 + 1;
            return memory[day - 1];
        }

        if (day > startNumbers.length - 3 && day <= startNumbers.length - 1) { // day = [2;3]
            if (memory[day - 1] != 0) {
                System.out.println(">>> " + day);
                return memory[day - 1];
            }
            prev = chooseHobbyRecursive(startNumbers, day - 1, memory);
            prePrePrev = startNumbers[startNumbers.length - (startNumbers.length - day)];
            memory[day - 1] = (prev * prePrePrev) % 10 + 1;
            return memory[day - 1];
        }

        if (day > 3) {
            if (memory[day - 1] != 0) {
                System.out.println(">>> " + day);
                return memory[day - 1];
            }
            prev = chooseHobbyRecursive(startNumbers, day - 1, memory);
            prePrePrev = chooseHobbyRecursive(startNumbers, day - 3, memory);
            memory[day - 1] = (prev * prePrePrev) % 10 + 1;
            return memory[day - 1];
        }
        return 777;
    }

    public static int chooseHobbyIterative(int[] startNumbers, int day) {
        List<Integer> numbers = new ArrayList<>();

        numbers.add(startNumbers[0]);
        numbers.add(startNumbers[1]);
        numbers.add(startNumbers[2]);
        numbers.add(startNumbers[3]);

        for (int d = 0; d < day; d++) {
            int index = d + 4; // индексы дней в массиве сдвинуты на 4
            int prev = numbers.get(index - 1); // предыдущее значение
            int prePrePrev = numbers.get(index - 3); // пре-пре-предыдущее значение
            numbers.add((prev * prePrePrev) % 10 + 1);
        }

        return numbers.get(numbers.size() - 1);
    }
}
