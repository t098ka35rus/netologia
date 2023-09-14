package com.netologia.abstinterf;

public class Main {

    public static void main(String[] args) {
        Account account = new SimpleAccount((long) 1000);
        Account account1 = new CreditAccount(700, 2000);
        account.transfer(account1, 200);
        account1.transfer(account,300);
        System.out.println("Остаток на дебетовом счете  = " + account.getBalance());
        System.out.println("Остаток на кредитном счете = " + account1.getBalance());


    }

}
