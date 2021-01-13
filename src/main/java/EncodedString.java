import java.util.PriorityQueue;
import java.util.Stack;

public class EncodedString {

    public String decodeString(String s) {

        int n;
        StringBuilder temp = new StringBuilder();
        String output = "";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='['){
                n = Integer.parseInt(temp.toString());
                temp.delete(0,temp.length());
                String t = findSubString(s.substring(i));
                String string = decodeString(t);
                while(n-->0){
                    output += string;
                }
                i+=t.length()+1;
            }  else {
                if(s.charAt(i)>='0' && s.charAt(i)<='9')
                    temp.append(s.charAt(i));
                else output += s.charAt(i);
            }
        }

        PriorityQueue<String> queue = new PriorityQueue<>((x,y) -> (x.compareTo(y)));

        return output;
    }

    public String findSubString(String s){
        int count =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='[') {
                count ++;
            }
            else if (s.charAt(i)==']') {
                count--;
                if(count==0){
                    return (s.substring(1,i));
                }
            }
        }
        return "";
    }

    public static void main(String[] args){

        String s = "3[a]2[bc]";

        System.out.println(new EncodedString().decodeString(s));
    }
}
