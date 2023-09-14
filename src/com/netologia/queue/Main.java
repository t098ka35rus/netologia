package com.netologia.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static List<String> firstClients = List.of("Anya", "Sveta", "Olya", "Alexandra", "Ruslana", "Olesya", "Vika");
    static Queue<String> queue = new LinkedList<>();
     static String manicurist;
    public static void main(String[] args) {
        queueAdd();
        doManicure();
    }

    private static void doManicure() {
        while (!queue.isEmpty()) {
            manicurist = queue.poll();
            System.out.println(manicurist + " сделала новый маникюр");
            if (Math.random() < 0.5) { // проверка условия, которое срабатывает с 50% вероятностью
                // друг записался
                queue.offer(" a friend of " + manicurist);
            }
        }
    }

    private static void queueAdd() {
        for (String firstClient : firstClients) {
            queue.offer(firstClient);
        }
    }
}
