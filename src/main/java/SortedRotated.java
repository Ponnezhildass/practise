import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortedRotated {
    public int search(int[] nums, int target) {
        return searchUtil(nums,target,0,nums.length-1,nums[nums.length-1]>nums[0]);
    }
    public int findUnsortedSubarray(int[] nums) {
        List<Integer> temp = new ArrayList();
        for (int i: nums
             ) {
            temp.add(i);
        }
        Collections.sort(temp);
        int start = 0, end = nums.length-1;
        while(temp.get(start)==nums[start]){
            start++;
        }
        while(temp.get(start) == nums[end]){
            end--;
        }
        return end+1 - start;
    }

    public int searchUtil(int[] nums, int target, int start, int end, boolean isSorted){
        if(nums[start]==target) return start;
        if(start>=end) return -1;
        int middle = start + (end-start)/2;
        if(start == middle) {
            if(nums[end]==target) return end;
            else return -1;
        }
        if(isSorted){
            if(nums[middle] == target) return middle;
            if(nums[middle] < target) {
                return searchUtil(nums,target,middle+1,end,true);
            } else {
                return searchUtil(nums,target, start, middle-1, true);
            }
        } else {
            if(nums[middle] == target) return middle;
            if(nums[start]<nums[middle]){
                if(target>nums[middle]){
                    return searchUtil(nums,target, middle+1, end, false);
                } else {
                    if(target < nums[start]){
                        return searchUtil(nums,target, middle+1, end, false);
                    } else {
                        return searchUtil(nums,target, start,middle-1, true);
                    }

                }
            } else {
                if(target>nums[middle]){
                    if(target > nums[end])
                        return searchUtil(nums,target, start, middle-1, false);
                    else
                        return searchUtil(nums,target, middle+1, end, true);
                } else {
                    return searchUtil(nums,target, start,middle-1, false);
                }
            }
        }

    }

    public static void main(String[] args){
        SortedRotated sortedRotated = new SortedRotated();
        int[] nums = {1,2,3,4};
        /*for (int n: nums) {
            System.out.println(sortedRotated.search(nums, n));
        }*/
        sortedRotated.findUnsortedSubarray(nums);

    }
}
