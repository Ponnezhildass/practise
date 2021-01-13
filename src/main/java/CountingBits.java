import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingBits {
    public int[] countBits(int num) {
        int [] result = new int [num+1];
        result[0] = 0;
        if(num<1) return result;
        result[1] = 1;
        int p =2;
        for(int i=2;p<=num;i*=2){
            int t = 0;
            while(p<i && p<=num){
                result[p] = 1 + result[t];
                t++;
                p++;
            }
        }
        return result;
    }

    public static void main(String[] args){
        CountingBits c = new CountingBits();
        List<Integer> list = new ArrayList<>();

        for(int i : c.countBits(8)){
            System.out.println(i);
        }
    }
}
