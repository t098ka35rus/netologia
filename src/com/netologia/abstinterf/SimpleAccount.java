package com.netologia.abstinterf;

public class SimpleAccount extends Account {
    private long balance;

    public SimpleAccount(long balance) {
        super(balance);
        this.balance = balance;

    }

    @Override
    public long getBalance() {
        return balance;
    }

    @Override
    public boolean add(long amount) {
        System.out.println("Добавляем " + amount + " на дебетовый счет.");

        if (balance < 0) {
            System.out.println("Баланс отрицательный, операция не выполнена.");
            return false;
        }
        if (amount < 0) {
            System.out.println("Сумма пополнения отрицательная, операция не выполнена.");
            System.out.println("Остаток на счете = " + balance);
            return false;
        }
        long balance1 = balance;
        balance = balance + amount;

        if (Math.abs(balance - balance1 ) == amount) {
            System.out.println("Счет пополнен успешно " + "balance = " + balance);
            return true;
        }
        return false;
    }

    @Override
    public boolean pay(long amount) {
        System.out.println("Снимаем " + amount + " с дебетового счета");
        if (balance < 0) {
            System.out.println("Баланс отрицательный, операция не выполнена.");
            return false;
        }
        if (amount < 0) {
            System.out.println("Сумма снятия отрицательная, операция не выполнена.");
            System.out.println("Остаток на счете = " + balance);
            return false;
        }

        if (amount > balance) {
            System.out.println("Сумма снятия больше чем остаток на счете, операция не выполнена.");
            System.out.println("Остаток на счете = " + balance);
            return false;
        }


        long balance1 = balance;
        balance = balance - amount;
        if (balance - balance1 == amount) {
            System.out.println("Сумма снята со счета успешно " + "balance = " + balance);
            return true;
        }
        return false;
    }


    @Override
    public boolean transfer(Account account, long amount) {
        boolean pay;
        boolean add;
        System.out.println("Начинаем трансфер с дебетового счета");
        pay = this.pay(amount);
        if (pay) {
            System.out.println(amount + " успешно списаны");
            System.out.println("зачисляем на счет корреспондент");
            add = account.add(amount);
            System.out.println("поступили на счет корреспондент");
        } else {
            System.out.println(amount + " не списаны, баланс не поменялся");
            return false;
        }
        if (!add) {
            this.add(amount);
            System.out.println(amount + "выполнена операция возврата");
            return false;
        } else {
            return true;
        }
    }


}
