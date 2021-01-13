package backtracking;

import java.util.Vector;

public class SubsetSum {

    int N = 7;
    public static void main(String[] args){
        int weights[] = {10, 7, 5, 18, 12, 20, 15};
        SubsetSum subsetSum = new SubsetSum();
        subsetSum.findSubsets(weights,35);
    }

    public void findSubsets(int[] weights, int target){
        Vector<Integer> vector = new Vector<Integer>();
        for(int i=0;i<N;i++){
            if(findSubsetsUtil(weights,target,i)){
                System.out.println();
            }
        }
    }


    public boolean findSubsetsUtil(int[] weights, int target, int index){

        if(index == N) return false;

        for(int i = index; i<N;i++){
            if(target-weights[i] != 0){

            }
            else {

            }
        }
        return false;
    }

}
