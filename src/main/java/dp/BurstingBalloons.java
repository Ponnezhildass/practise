package dp;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class BurstingBalloons {
    Map<String,Integer> dp;
    public int maxCoins(int[] nums) {
        dp = new HashMap<>();
        String[] n = new String[nums.length];
        int ptr = 0;
        for(int i : nums){
            n[ptr++] = Integer.toString(i);
        }
        return maxCoinsRecur(hash(n,-1));
    }

    public int maxCoinsRecur(String s){
        if(dp.containsKey(s)){
            return dp.get(s);
        } else {
            int max = 0;
            String[] nums = s.split(",");
            if(nums.length == 4){
                int a = Integer.parseInt(nums[0]);
                int b = Integer.parseInt(nums[1]);
                int c = Integer.parseInt(nums[2]);
                int d = Integer.parseInt(nums[3]);
                int x = b*c*d + a*b*d + a* d + Math.max(a,d);
                int y = a*c*d + a*b*c + a* d + Math.max(a,d);
                dp.putIfAbsent(s,Math.max(x,y));
                return dp.get(s);
            } else if(nums.length==3){
                int a = Integer.parseInt(nums[0]);
                int b = Integer.parseInt(nums[1]);
                int c = Integer.parseInt(nums[2]);
                dp.putIfAbsent(s,a*b*c + a*c + Math.max(a,c));
                return dp.get(s);
            } else if(nums.length==2){
                dp.putIfAbsent(s,Integer.parseInt(nums[0])*Integer.parseInt(nums[1]) + Math.max(Integer.parseInt(nums[0]),Integer.parseInt(nums[1])));
                return dp.get(s);
            } else {
                for (int i = 1; i < nums.length-1; i++) {
                    int left = i > 0 ? Integer.parseInt(nums[i - 1]) : 1;
                    int right = i < nums.length - 1 ? Integer.parseInt(nums[i + 1]) : 1;
                    int ele = Integer.parseInt(nums[i]);
                    max = Math.max(maxCoinsRecur(hash(nums, i)) + left * right * ele, max);
                }
                dp.putIfAbsent(s, max);
                return max;
            }
        }
    }

    public String hash(String[] nums, int exp){
        String string = "";
        for(int i =0;i<nums.length;i++) {
            if(exp != i)
                string += nums[i] + ",";
        }

        return string;
    }
    public static void main(String[] args){

        BurstingBalloons burstingBalloons = new BurstingBalloons();
        int[] nums = {2,3,7,9};
        System.out.println(burstingBalloons.maxCoins(nums));
    }
}
