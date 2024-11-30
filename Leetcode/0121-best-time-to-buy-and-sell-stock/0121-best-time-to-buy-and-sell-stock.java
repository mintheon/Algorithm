class Solution {
    public int maxProfit(int[] prices) {
        int[] profit = new int[prices.length];

        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            if(buyPrice > prices[i]) {
                buyPrice = prices[i];
                continue;
            }

            profit[i] = prices[i] - buyPrice;
            if(maxProfit < profit[i]) {
                maxProfit = profit[i];
            }
        }

        return maxProfit;
    }
}