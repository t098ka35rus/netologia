package com.netologia.polymor.taxes;

public class Tax15 extends TaxSystem {
    @Override
    public int calcTaxFor(int debit, int credit) {
        super.calcTaxFor(debit, credit);
        double tax = 0.15 * (debit - credit);
        if ((int) tax < 0) {
            return 0;
        }
        return (int) tax;
    }
}
