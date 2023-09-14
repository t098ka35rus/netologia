package com.netologia.funcProgPractice;

import java.util.function.*;

public class Calculator {
    static Supplier<Calculator> instance = Calculator::new;
    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
   // BinaryOperator<Integer> devide = (x, y) -> x / y;// лечим деление на ноль, переписываем devide
    BinaryOperator<Integer> devide = (x, y) -> {
        if (y == 0){
            System.out.println("деление на ноль");
            return 0;}
        int res = x/y;
        return res;
    };//
    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;
    Predicate<Integer> isPositive = x -> x > 0;
    Consumer<Integer> println = System.out::println;
}
