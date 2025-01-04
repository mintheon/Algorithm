class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxPrice = 0;
        int price = 0;

        for(int i = 0; i < prices.length; i++) {
            maxPrice = Math.max(maxPrice, prices[i]);

            if(minPrice > prices[i]) {
                minPrice = prices[i];
                maxPrice = prices[i];
            }

            price = Math.max(price, maxPrice - minPrice);
        }

        return price;
    }
}