import java.util.LinkedList;
import java.util.Queue;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String output = "";
        output = strs[0];
        int l = -1;
        for(int i=1; i<strs.length ; i++){
            for(int j= 0; j<strs[i].length() & j<output.length();j++){
                if(output.charAt(j)==strs[i].charAt(j))l = j;
                else break;
            }
            output = output.substring(0,l+1);
        }
            return output;
    }
    public static void main(String[] args){
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] strings = {"a","a","b"};
        System.out.println(longestCommonPrefix.longestCommonPrefix(strings));
    }
}
