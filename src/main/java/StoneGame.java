public class StoneGame {
    int[] dp;
    public int floorSqrt(int x)
    {
        // Base cases
        if (x == 0 || x == 1)
            return x;

        // Staring from 1, try all numbers until
        // i*i is greater than or equal to x.
        int i = 1, result = 1;

        while (result <= x) {
            i++;
            result = i * i;
        }
        return i - 1;
    }

    public boolean winnerSquareGame(int n) {
        dp = new int[n];
        for(int i=1;i<=floorSqrt(n);i++){
            int s = (i*i)-1;
            dp[s] = 1;
        }

        return winnerSquareGameUtil(n-1) == 1 ? true: false;
    }

    public int winnerSquareGameUtil(int n){
        if(dp[n] != 0) return dp[n];
        for(int i=1;i<=floorSqrt(n);i++){
            int s = i*i;
            if(winnerSquareGameUtil(n-s)==-1){
                dp[n] = 1;
                return 1;
            }
        }
        dp[n] = -1;
        return -1;
    }

    public static void main(String[] a){
        System.out.println(new StoneGame().winnerSquareGame(2));
        System.out.println(new StoneGame().winnerSquareGame(4));
        System.out.println(new StoneGame().winnerSquareGame(7));
        System.out.println(new StoneGame().winnerSquareGame(17));
    }
}
