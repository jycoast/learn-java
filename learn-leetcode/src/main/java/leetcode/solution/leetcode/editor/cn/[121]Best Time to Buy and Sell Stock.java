package leetcode.solution.leetcode.editor.cn;

/**
 * @see <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/">买卖股票的最佳时机</a>
 */
class BestTimeToBuyAndShellStock {
    public static void main(String[] args) {
        BestTimeToBuyAndShellStock bestTimeToBuyAndShellStock = new BestTimeToBuyAndShellStock();
        System.out.println(bestTimeToBuyAndShellStock.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                profit = Math.max(prices[i] - min, profit);
            }
        }
        return profit;
    }
}
