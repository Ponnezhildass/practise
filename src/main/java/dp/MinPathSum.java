package dp;

public class MinPathSum {
    int[][] dp;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]  = -1;
            }
        }
        dp[m-1][n-1] = grid[m-1][n-1];
        return minPathSumRecur(grid,0,0);
    }

    public int minPathSumRecur(int[][] grid, int m, int n){
        if(dp[m][n] != -1){
            return dp[m][n];
        } else {
            int min = 0;
            if(m+1<grid.length){
                min = Math.min(min,minPathSumRecur(grid,m+1,n));
            }
            if(n+1<grid[0].length){
                min = Math.min(min,minPathSumRecur(grid,m,n+1));
            }
            dp[m][n] = min + grid[m][n];
            return dp[m][n];
        }
    }

    public static void main(String[] args){
        int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(new MinPathSum().minPathSum(arr));
    }
}
