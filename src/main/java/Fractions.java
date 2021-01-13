import java.util.ArrayList;
import java.util.List;

public class Fractions {

    public static void printFractions(int d) {

        if(d==0)	return ;
        int [] nos = new int[d];
        for(int i=0;i<d;i++){
            nos[i] = 1;
        }

        List<String> result = new ArrayList();
        while(true){
            double min = 1;
            int index = 0;
            for(int i=0; i<d ; i++){
                double v = (double)nos[i]/(i+1);
                if(min > v){
                    index = i;
                    min = v;
                }
            }//finds the minimum

            result.add(nos[index] + "/" + (index+1));
            nos[index]++;

            for(int i=0; i<d ; i++){
                double v = (double)nos[i]/(i+1);  // 2/1
                if(v == min && index != i){
                    nos[i]++;
                }
            } // remove duplicates
            int count = 0;
            for(int i=0; i<d ; i++){
                if(nos[i]==i+2){
                    count++ ;
                }
            } // keeps track of number of variable where the fraction equal 1
            if(count == d) break;
        }

        for(String s: result)
            System.out.println(s);
    }

    public static void main(String[] args){
        int [] a = test();
        System.out.println(a[0] + " -- " + a[1]);
        //printFractions(7);
    }

    private static int[] test(){
        int [] a = {10,11};
        int [] b = {20,21};
        return new int[]{a[0],b[1]};
    }
}
