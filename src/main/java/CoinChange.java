public class CoinChange {
    int[] dp;
    public int change(int amount, int[] coins) {
        dp = new int[amount+1];

        for(int i : coins){
            if(i<=amount){
                dp[i] = 1;
            }
        }

        for(int i=1;i<=amount;i++) {
            for(int c : coins) {
                if(c<i) {
                    dp[i] += dp[i-c];
                } else break;
            }
        }

        return dp[amount];
    }

    public static void main(String[] args){
        int[] coins = {1,2,5};
        System.out.println(new CoinChange().change(3,coins));
    }
}
