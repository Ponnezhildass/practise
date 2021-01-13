public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int n = nums.length ;
        for(int i=0;i<n;i++){
            int ptr = nums[i] - 1;
            if(nums[ptr]==0) return ptr+1;
            while(nums[ptr] !=0){
                int t = nums[ptr];
                nums[ptr]=0;
                ptr = t-1;
                if(nums[ptr]==0) return ptr+1;
            }
            nums[i]=0;
        }
        return -1;
    }

    public static void main(String[] args){
        FindDuplicate findDuplicate = new FindDuplicate();
        int [] nums = {2,1,2};
        System.out.println(findDuplicate.findDuplicate(nums));
    }
}
