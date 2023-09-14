package com.netologia.polymor;

import com.netologia.polymor.taxes.Tax15;
import com.netologia.polymor.taxes.Tax6;
import com.netologia.polymor.taxes.TaxSystem;

public class Main {
    public static void main(String[] args) {
        TaxSystem taxSystem = new Tax6();
        TaxSystem taxSystem1 = new Tax15();

        Company company = new Company("abb", taxSystem);
        Company company1 = new Company("sony", taxSystem1);
        company.shiftMoney(2000);
        company.shiftMoney(-500);
        company.payTaxes();

        company1.shiftMoney(2000);
        company1.shiftMoney(-500);
        company1.payTaxes();


    }

}
