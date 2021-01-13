package backtracking;

import java.util.ArrayList;
import java.util.List;

public class SuperSet {

    int N =3;
    public static void main(String [] args){
        int [] nums = {1,2,3,4};
        SuperSet superSet = new SuperSet();
        superSet.permute(nums);
    }

    private void permute(int[] nums){
        int [] visited = new int[N];
        List<List<Integer>> output = new ArrayList();
        List<Integer> list = new ArrayList();
        permuteUtil(nums, visited, list,0,output);
        for(List<Integer> i : output) {
            for (int j : i) {
                System.out.print(" " + j);
            }
            System.out.println("");
        }
    }

    private void permuteUtil(int[] nums, int[] visited, List<Integer> list, int n, List<List<Integer>> output){
        if(n==N) {
            return;
        }
        for(int i=0;i<N;i++){
            if(visited[i] == 0){
                visited[i] = 1;
                list.add(nums[i]);
                List<Integer> newList = new ArrayList<Integer>();
                newList.addAll(list);
                output.add(newList);
                permuteUtil(nums,visited,list,n+1,output);
                visited[i] = 0;
                list.remove(list.size()-1);
            }
        }
    }
}
