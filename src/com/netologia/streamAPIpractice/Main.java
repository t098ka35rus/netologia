package com.netologia.streamAPIpractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> plusList = getPlusList(intList);
        List<Integer> honestList = getHonestList(plusList);
        List<Integer> sortlist = getsortList(honestList);
        for (Integer i : sortlist) {
            System.out.println(i);
        }
        System.out.println("www");
    }


    public static List<Integer> getPlusList(List<Integer> list) {
        List<Integer> plusList = new ArrayList<>();
        for (Integer i : list) {
            if (i > 0) {
                plusList.add(i);
            }
        }
        return plusList;
    }

    public static List<Integer> getHonestList(List<Integer> list) {
        List<Integer> honestList = new ArrayList<>();
        for (int i : list) {
            if (i % 2 == 0) {
                honestList.add(i);
            }
        }
        return honestList;
    }

    public static List<Integer> getsortList(List<Integer> list) {
        int min = 0;
        int count = 0;
        for (int i = 0; i < list.size() - count; i++) {

            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    min = list.get(j + 1);
                    list.set(j + 1, list.get(j));
                    list.set(j, min);
                }
            }
            count++;
        }
        return list;
    }


}
