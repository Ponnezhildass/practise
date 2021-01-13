import java.util.*;
import java.util.stream.Collectors;

public class CountPrimes {
    public int countPrimes(int n) {
        List<Integer> list = new ArrayList();

        for(int i = 2;i<n; i++){
            list.add(i);
        }
        for(int i=0;i<list.size();i++){
            int t = list.get(i);
            if(t>Math.sqrt(n)) break;
            Iterator itr = list.iterator();
            while (itr.hasNext())
            {
                int x = (Integer)itr.next();
                if (x % t == 0 && x >t)
                    itr.remove();
            }
        }
        return list.size();
    }

    public static void testMap() {
    }
    public static void main(String[] args){
        testMap();
        //System.out.println(new CountPrimes().countPrimes(100));
    }
}
