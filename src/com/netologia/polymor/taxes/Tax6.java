package com.netologia.polymor.taxes;

public class Tax6 extends TaxSystem {
    @Override
    public int calcTaxFor(int debit, int credit) {
        super.calcTaxFor(debit, credit);
        double tax = 0.06 * debit;
        return (int) tax;
    }
}
