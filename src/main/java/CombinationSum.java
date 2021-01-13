import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Map<Integer,List<List<Integer>>> dp = new HashMap();

        for(int i =1;i<=target;i++){
            for(int num : candidates){
                if(i==num){
                    List<List<Integer>> list = dp.get(i);
                    if(list == null){
                        dp.put(i,Collections.singletonList(Collections.singletonList(num)));
                    }
                    else {
                        list.add(Collections.singletonList(num));
                    }
                }
                if(num<i){
                    if(dp.containsKey(i-num) && i-num>=num){
                        List<List<Integer>> curr = dp.get(i-num);
                        List<List<Integer>> insert = new ArrayList<>();
                        for(List<Integer> list : curr){
                            List<Integer> temp = new ArrayList<>(list);
                            temp.add(num);
                            insert.add(temp);
                        }
                        if(dp.get(i)!=null) {
                            List<List<Integer>> list = new ArrayList<>(dp.get(i));
                            list.addAll(insert);
                            dp.put(i, list);
                        } else {
                            dp.put(i,insert);
                        }
                    }

                }
            }
        }
        return dp.get(target);
    }

    public static void main(String [] args){
        CombinationSum combinationSum = new CombinationSum();
        int[] candidates = {2,3,6,7};
        List<List<Integer>> output = combinationSum.combinationSum(candidates,7);
        for(List<Integer> list : output){
            for(int i : list){
                System.out.print(" " +i);
            }
            System.out.println("");
        }
    }
}
