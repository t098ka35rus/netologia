package com.netologia.abstinterf;

public abstract class Account {
    private final long balance;


    public Account(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public abstract boolean add(long amount);

    public abstract boolean pay(long amount);

    public abstract boolean transfer(Account account, long amount);


}


