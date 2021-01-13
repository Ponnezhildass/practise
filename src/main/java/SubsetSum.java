public class SubsetSum {
    int[][] dp;
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int i : nums)
            total+=i;

        if(total % 2 ==1 ) return false;

        total/=2;

        dp = new int[n][total+1];

        for(int i=0;i<n;i++){
            dp[i][0] = 1;
        }

        for(int i=1;i<=total;i++){
            dp[n-1][i] = -1;
        }
        dp[n-1][nums[n-1]] = 1;

        return hasSum(0,total, nums);

    }

    public boolean hasSum(int start, int sum, int[] nums) {
        if(sum<0) return false;
        if(start >= nums.length) return false;
        if(dp[start][sum] != 0) {
            return dp[start][sum] == 1 ;
        }

        boolean val = hasSum(start+1, sum,nums) || hasSum(start+1, sum-nums[start],nums);
        dp[start][sum] = val ? 1 : -1;

        return val;
    }

    public static void main(String[] args){
        int[] nums = {1,9,11,5};
        System.out.println(new SubsetSum().canPartition(nums));
    }
}
