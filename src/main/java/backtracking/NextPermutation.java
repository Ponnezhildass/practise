package backtracking;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String [] args){
        int[][] nums = {{1,5,1}};
        NextPermutation nextPermutation = new NextPermutation();
        for (int [] t : nums) {
            nextPermutation.nextPermute(t);
            for (int i : t)
                System.out.print(" " + i);
            System.out.println("");
        }
    }

    public void nextPermute(int[] nums){
        int n = nums.length;
        int ptr = n-1;
        for(;ptr>=1;ptr--){
            if(nums[ptr]>nums[ptr-1])
                break;
        }
        if(ptr == 0)
            Arrays.sort(nums);
        else {
            int l = n-1;
            for(;l>=ptr;l--){
                if(nums[ptr-1] < nums[l])
                    break;
            }

            int temp = nums[ptr-1];
            nums[ptr-1] = nums[l];
            nums[l] = temp;
            for(int i = ptr, j= n-1;i<n && i<j;i++,j--){
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }
}
