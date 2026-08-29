package week4.class_problems;
public class besttimestock {
    public static int findprofit(int[] prices) {
        int lowestprice = prices[0];
        int buyDay = 0;
        int sellDay = 0;
        int maxprofit = 0;

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < lowestprice) {
                lowestprice = prices[i];
                buyDay = i;
            }

            int profit = prices[i] - lowestprice;

            if (profit > maxprofit) {
                maxprofit = profit;
                sellDay = i;
            }
        }

        System.out.println("BUY STOCK ON DAY: " + (buyDay + 1));
        System.out.println("SELL STOCK ON DAY: " + (sellDay + 1));
        System.out.println("MAXIMUM PROFIT: " + maxprofit);

        return maxprofit;
    }

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};

        findprofit(prices);
    }
}