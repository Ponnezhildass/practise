import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PalindromePartition {

    private List<List<String>>[][] dp;


    public List<List<String>> partition(String s) {
        int n = s.length();
        dp = new ArrayList[n][n];

        partitionUtil(s,0,n-1);

        return dp[0][n-1];
    }



    public List<List<String>> partitionUtil(String s, int i, int j){
        if(i>j) return new ArrayList<>();
        if(dp[i][j] != null){
            return dp[i][j];
        } else {
            List<List<String>> list = new ArrayList<>();
            if(i==j){
                list.add(Collections.singletonList(String.valueOf(s.charAt(i))));
            } else if(i+1 == j){
                List<String> temp = new ArrayList<>();
                temp.add(String.valueOf(s.charAt(i)));
                temp.add(String.valueOf(s.charAt(j)));
                list.add(temp);
                if(s.charAt(i) == s.charAt(j)){
                    list.add(Collections.singletonList(s.substring(i,j+1)));
                }
            } else {
                for (int I = i ; I <= j; I++) {
                    String s1 = s.substring(i,I+1);
                    if(s1.equals(new StringBuilder(s1).reverse().toString()))
                        combine(Collections.singletonList(Collections.singletonList(s1)),partitionUtil(s,I+1,j),list);
                }
            }

            dp[i][j] = list;
            return dp[i][j];
        }

    }

    public void combine(List<List<String>> list1, List<List<String>> list2, List<List<String>> output ){
        for(List<String> list : list2){
            for(List<String> list3 : list1) {
                List<String> temp = new ArrayList<>(list3);
                temp.addAll(list);
                output.add(temp);
            }
        }
        if(list2.size()==0){
            for(List<String> list : list1) {
                List<String> temp = new ArrayList<>(list);
                output.add(temp);
            }
        }
        if(list1.size()==0){
            for(List<String> list : list2) {
                List<String> temp = new ArrayList<>(list);
                output.add(temp);
            }
        }
    }


    public static void main(String[] args){
        PalindromePartition palindromePartition = new PalindromePartition();
        for(List<String> list : palindromePartition.partition("efe")){
            for(String string : list){
                System.out.print(string + ", ");
            }
            System.out.println("");
        }
    }

}
