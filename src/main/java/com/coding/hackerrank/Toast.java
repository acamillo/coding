package com.coding.hackerrank;

import java.util.List;

/**
 * Toast interview with Aidan Duggan. @email: aduggan@toasttab.com
 */
public class Toast {
    //3 2 3 4 40 5 7
    // 3 2 3 1 4 40 5 7
    public static long maxProfit(List<Long> prices) {
        long currMin = Integer.MAX_VALUE;
        long profit = 0;
 /*
        for(Long price: prices) {
            currMin = Math.min(currMin, price);
            profit = Math.max(profit, price - currMin);
        }
  */
        for(int i=5; i < prices.size(); i++) {
            long price = prices.get(i);

            if (currMin > prices.get(i - 5) ) {
                currMin = prices.get(i - 5) ;
                // minIndex = i-5;
            }

            profit = Math.max(profit, price - currMin);
        }

        return profit;
    }
}
