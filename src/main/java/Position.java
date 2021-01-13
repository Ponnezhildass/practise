public class Position {

        public int[] searchRange(int[] nums, int target) {
            int start = 0, end = nums.length - 1;
            return searchRangeUtil(nums,target,start,end);
        }

        public int[] searchRangeUtil(int[] nums, int target, int start, int end) {
            if(nums[start]>target) return new int[]{-1,-1};
            if(nums[end]<target) return new int[]{-1,-1};
            if(start == end) {
                if(nums[start] == target) return new int[]{start,start};
                else return new int[]{-1,-1};
            }
            int mid = (start+end)/2;

            int[] left = searchRangeUtil(nums,target,start,mid);
            int[] right = searchRangeUtil(nums,target,mid+1,end);
            if(left[0] != -1 && right[0] != -1){
                return new int[]{left[0],right[1]};
            }
            if(left[0] != -1) return left;
            if(right[0] != -1) return right;
            return new int[]{-1,-1};
        }

        public static void main(String[] args){
            Position position = new Position();
            int [] nums = {5,7,7,8,8,8,8,10};
            int [] pos = position.searchRange(nums,10);
            System.out.println("start: " + pos[0] + " end: " + pos[1]);
        }
}
