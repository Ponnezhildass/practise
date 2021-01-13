import java.util.*;

public class HalfArray {
    public int minSetSize(int[] arr) {
        Map<Integer,Integer> countMap = new HashMap();
        for(int i : arr){
            int c = countMap.getOrDefault(i,0);
            countMap.put(i,c+1);
        }

        List<Integer> list = new ArrayList();

        for(int i : countMap.keySet()){
            list.add(countMap.get(i));
        }

        Collections.sort(list,Collections.reverseOrder());

        int n = arr.length;

        int sum = 0, i =0;

        while(sum<(n/2)){
            sum+=list.get(i++);
        }

        return i;
    }

    public static void main(String[] args){
        int[] arr = {3,7};
        System.out.println(new HalfArray().minSetSize(arr));
    }
}
