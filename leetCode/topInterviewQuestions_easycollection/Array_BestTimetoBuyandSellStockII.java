package topInterviewQuestions_easycollection;

public class Array_BestTimetoBuyandSellStockII {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 0)
            return 0;
        
        int sum = 0;
        for(int i = 0; i < prices.length-1; ++i){
            if(prices[i] < prices[i+1])
                sum = sum + (prices[i+1] - prices[i]);
        }
        return sum;
    }
}
