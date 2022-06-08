//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;

        int buy = 0, sell = 1, maxProfit=0;
        while(sell <= prices.length - 1){
            if(prices[buy] < prices[sell]){
                int tran = prices[sell]-prices[buy];
                maxProfit = (tran > maxProfit) ? tran : maxProfit;
                sell ++;
            }
            else {
                buy = sell;
                sell ++;
            }
        }
        return maxProfit;
    }
}
