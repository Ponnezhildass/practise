package backtracking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateSubString {

    public String longestDupSubstring(String S) {
        int n = S.length();
        int dp[][] = new int[n][n];

        List<Integer> list[] = new List[n];
        for(int i=0;i<n;i++){
            dp[i][i] = S.charAt(i) - 'a';
            for(int j=i+1;j<n;j++){
                dp[i][j] = dp[i][j-1] + S.charAt(j) - 'a';
            }
        }

        return S;
    }


    public static void main(String[] args){
        String S = "adfa";
        System.out.println(new DuplicateSubString().longestDupSubstring(S));
    }
}
