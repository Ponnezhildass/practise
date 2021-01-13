public class StocksProfit {
    int[] maxArray;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        maxArray = new int[n];
        for(int i=0;i<n;i++) maxArray[i]=-1;

        return maxProfitUtil(prices,0);
    }

    public int maxProfitUtil(int[] prices, int start){
        if(start >= prices.length) return 0;
        if(maxArray[start]!=-1) return maxArray[start];
        int temp = 0;
        int max = 0;
        for(int i=start;i<prices.length-1;i++){
            for(int j=i+1;j<prices.length;j++) {
                if (prices[i] < prices[j]) {
                    temp = prices[j] - prices[i] + maxProfitUtil(prices, j + 1);
                    max = max < temp ? temp : max;
                }
            }
        }
        maxArray[start]=max;
        return maxArray[start];
    }

    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new StocksProfit().maxProfit(prices));
    }
}
