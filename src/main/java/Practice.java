import java.util.Date;

public class Practice {
    public static void main(String[] args){
        String haystack = "a";
        String needle = "a";
        int output =0;
        if(needle.length()==0) System.out.println( output);
        int n= needle.length() ;
        for(int i=0; i<haystack.length();i++){
            if(haystack.substring(i,i+n).equalsIgnoreCase(haystack))
                System.out.println( i);
        }
        System.out.println( -1);

    }
}
