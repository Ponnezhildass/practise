public class MaxProduct {
    public int maxProduct(int[] nums) {
        int positiveMax = nums[0]>0 ? nums[0]: 0;
        int negativeMax = nums[0]<=0 ? nums[0]: 0;
        int global = positiveMax == 0 ? negativeMax: positiveMax ;
        for(int i = 1; i<nums.length;i++){
            if(nums[i] < 0){
                if(negativeMax != 0){
                    positiveMax = negativeMax * nums[i];
                    negativeMax = nums[i];
                } else {
                    if(positiveMax == 0) positiveMax = 1;
                    negativeMax = positiveMax * nums[i];
                    positiveMax = 0;
                }
                if(negativeMax > global) global = negativeMax;
                if(positiveMax > global) global = positiveMax;
            } else if(nums[i] >0)  {
                positiveMax = positiveMax * nums[i];
                if(positiveMax == 0) positiveMax = nums[i];
                negativeMax = negativeMax*nums[i];
                if(positiveMax > global) global = positiveMax;
            } else {
                positiveMax = 0;
                negativeMax = 0;
            }
        }

        return global;
    }

    public static void main(String [] args){
        int[] a = {-1,-2,-9,-6};
        MaxProduct maxProduct = new MaxProduct();
        System.out.println(maxProduct.maxProduct(a));
    }
}
