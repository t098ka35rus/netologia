package com.netologia.polymor;

import com.netologia.polymor.taxes.TaxSystem;

public class Company {
    protected String title;
    protected int debit;
    protected int credit;
    protected TaxSystem taxSystem;

    public Company(String title, TaxSystem taxSystem) {
        this.title = title;
        this.taxSystem = taxSystem;
    }

    public void setTaxSystem(TaxSystem taxSystem) {
        this.taxSystem = taxSystem;
    }

    public void shiftMoney(int amount) {
        if (amount > 0) {
            debit = debit + amount;
        } else if (amount < 0) {
            credit = credit + Math.abs(amount);
        }
    }

    public void payTaxes() {
        taxSystem.calcTaxFor(debit, credit);
        System.out.println("Компания  " + title + " уплатила налог в размере: " + taxSystem.calcTaxFor(debit, credit) + " руб.");
    }

    //Компания <название> уплатила налог в размере: <сумма> руб.

}
