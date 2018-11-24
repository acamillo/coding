package com.coding.hackerrank;

import java.math.BigDecimal;

public class ExtraLongFactorials {
    void extraLongFactorials(int n) {

        BigDecimal fact = new BigDecimal(n);

        while (n > 1) {
            fact = fact.multiply(new BigDecimal(n - 1));
            n--;
        }

        System.out.println(fact);
    }
}
