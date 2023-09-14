package com.netologia.abstinterf;

public class CreditAccount extends Account {
    private final long credit;
    private long balance;

    public CreditAccount(long balance, long credit) {
        super(balance);
        this.balance = balance;
        this.credit = credit;
        if (credit - balance < 0.0000000001) {
            this.balance = credit;
        }

    }

    @Override
    public long getBalance() {
        return balance;
    }

    @Override
    public boolean add(long amount) {
        System.out.println("Добавляем " + amount + " на кредитный счет.");
        if (balance < 0) {
            System.out.println("Баланс отрицательный, операция не выполнена.");
            return false;
        }
        if (balance > credit) {
            System.out.println("Баланс больше чем кредитный лимит, операция не выполнена.");
            return false;
        }

        if (credit < balance + amount) {
            System.out.println("Остаток на счете превысит кредитный лимит, операция не выполнена");
            return false;
        }
        long balance1 = balance;
        balance = balance + amount;
        if (balance - balance1 == amount) {
            System.out.println("Счет пополнен успешно " + "balance = " + balance);
            return true;
        }
        return false;
    }

    @Override
    public boolean pay(long amount) {
        System.out.println("Снимаем " + amount + " с кредитного счета");
        if (balance < 0) {
            System.out.println("Баланс отрицательный, операция не выполнена.");
            return false;
        }
        if (balance > credit) {
            System.out.println("Баланс больше чем кредитный лимит, операция не выполнена.");
            return false;
        }
        if (balance - amount < 0) {
            System.out.println("Остаток на счете станет отрицательным, операция не выполнена");
            return false;

        }

        long balance1 = balance;
        balance = balance - amount;
        if (balance1 - balance == amount) {
            System.out.println("Списание со счета выполнено успешно " + "balance = " + balance);
            return true;
        }
        return false;
    }

    @Override
    public boolean transfer(Account account, long amount) {
        boolean pay;
        boolean add;
        System.out.println("Начинаем трансфер с кредитного счета");
        pay = this.pay(amount);
        if (pay) {
            System.out.println(amount + "успешно списаны");
            System.out.println("зачисляем на счет корреспондент");
            add = account.add(amount);

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
