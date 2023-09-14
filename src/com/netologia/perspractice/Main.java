package com.netologia.perspractice;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;


public class Main {

    public static void main(String[] args) {
        TreeSet<Person> candidates = new TreeSet<>(new SpacePersonComparator());
        candidates.add(new Person("Sonya Popova", 35, 15));
        candidates.add(new Person("Dazdraperma Sponzhova", 33, 15));
        candidates.add(new Person("Salavat Netologshvili", 23, 13));
        candidates.add(new Person("Sasha Sun", 31, 15));
        candidates.add(new Person("Svetlana Morkov", 38, 15));
        candidates.add(new Person("Sasha Sosnova", 38, 11));

        Iterator<Person> it = candidates.iterator();
        for (int i = 0; i < candidates.size(); i++) {
            System.out.println(it.next());
        }

       // System.out.println(it.next());

        System.out.println(Integer.compare(2,3));
        System.out.println(Integer.compare(3,2));
        System.out.println(Integer.compare(3,3));

    }
}


class Person {
    private String name;
    private int age;
    private int experience;

    public Person(String name, int age, int experience) {
        this.name = name;
        this.age = age;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return name;
    }
}


class SpacePersonComparator implements Comparator<Person> {


    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getExperience() != o2.getExperience()) {
           if (o1.getExperience() > o2.getExperience()){
               return -1;
           } else if (o1.getExperience() < o2.getExperience()) {
               return 1;
           }
        }
        int cnt1 = getSumS(o1.getName());
        int cnt2 = getSumS(o2.getName());
        if (cnt1 != cnt2) {
            return -Integer.compare(cnt1, cnt2);
        }
        return Integer.compare(o1.getName().length(), o2.getName().length());
    }

    private int countSpaceLetters(String name) {
        int count = 0;
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == 's' || name.charAt(i) == 'S') {
                count++;
            }
        }
        return count;
    }

    
    public int getSumS (String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 's' || s.charAt(i) == 'S') {
                sum++;
            }
        }
        return sum;
    }
}
