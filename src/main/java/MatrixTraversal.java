public class MatrixTraversal {

    public int uniquePaths(int m, int n) {
        if(m<n){
            int temp = m;
            m=n;
            n=temp;
        }
        int [][] dp = new int[m][n];
        dp[m-1][n-1] = 1;
        for(int i = m+n-3;i>=0;i--){
            int a = i >= m ?  m-1 : i;
            int b = i-a;
            for(int j = 0; a-j >=0 && b+j<n;j++){
                if(a+1-j<m)
                    dp[a-j][b+j] += dp[a-j+1][b+j];
                if(b+1+j<n)
                    dp[a-j][b+j] += dp[a-j][b+j+1];
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args){
        MatrixTraversal matrixTraversal = new MatrixTraversal();
        System.out.println(matrixTraversal.uniquePaths(1,1));

    }
}
