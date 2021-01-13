import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    public String getPermutation(int n, int k) {
        List<String> list = new ArrayList();
        for(int i=1;i<=n;i++){
            list.add(Integer.toString(i));
        }

        String output = "";

        return getPermutationUtil(n,k-1,list,output);
    }

    public String  getPermutationUtil(int n, int k, List<String> list, String output){
        if(n==0) return output;
        int d = fact(n-1);
        int i = k/d;
        String s = list.get(i);
        output = output + s;
        list.remove(s);
        return getPermutationUtil(n-1,k-i*d ,list,output);
    }


    public int fact(int n){
        int f = 1;
        while(n>1){
            f*=n;
            n--;
        }
        return f;
    }

    public static void main(String[] args){
        PermutationSequence permutationSequence = new PermutationSequence();
        System.out.println(permutationSequence.getPermutation(4,1));
    }
}
