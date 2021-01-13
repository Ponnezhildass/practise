public class FrogJump {
    int [] dp;
    public boolean canCross(int[] stones) {
        int n = stones.length;
        dp = new int[n];

        dp[n-1] = 1;

        return canCrossUtil(stones,0,0);
    }


    public boolean canCrossUtil(int[] stones, int index, int jump){
        if(index == stones.length-1){
            return true;
        } else {
            int curr = stones[index];
            boolean result = false;
            for(int i = index+1;i<stones.length;i++){
                if(stones[i] == curr+jump-1){
                    result = result || canCrossUtil(stones,i,jump-1);
                }
                if(stones[i] == curr+jump){
                    result = result || canCrossUtil(stones,i,jump);
                }
                if(stones[i] == curr+jump+1){
                    result = result || canCrossUtil(stones,i,jump+1);
                }
            }

            dp[index] =  result? 1 : -1;
            return dp[index]==1;
        }

    }

    public static void main(String[] args){
        FrogJump frogJump = new FrogJump();
        int[] arr = {0,2};
        System.out.println(frogJump.canCross(arr));
    }
}
