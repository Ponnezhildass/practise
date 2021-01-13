public class RotatedArray {
    public int findMin(int[] nums) {
        if(nums.length == 0) return 0;
        int min = nums[0];
        min = Math.min(min,findMinUtil(nums,0,nums.length-1));

        return min;
    }

    public int findMinUtil(int[] nums, int start, int end){
        if(start>end) return Integer.MAX_VALUE;
        int mid = start + (end-start)/2;
        if(mid > 0 && nums[mid] < nums[mid-1]) return nums[mid];
        if(nums[start] < nums[end]) return nums[start];
        if(nums[start]>nums[mid]){
            return findMinUtil(nums,start,mid-1);
        } else {
            return findMinUtil(nums,mid+1, end);
        }
    }

    public static void main(String[] args){
        int [] arr = {2,1};
        System.out.println(new RotatedArray().findMin(arr));
    }

}
