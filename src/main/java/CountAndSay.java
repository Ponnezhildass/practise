import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Sotion {
    public String countAndSay(int n) {
        String number = "1";
        for(int i=1;i<n;i++)
            number = findNext(number);
        return number;
    }

    private String findNext(String n){
        List<Character> list = new ArrayList();
        String output = "";
        for(int i=0;i<n.length();i++){
            list.add(n.charAt(i));
        }
        Character k = list.get(list.size()-1);
        int count =1;
        for(int i=list.size()-2; i>=0;i--){
            if(list.get(i)==k) count++;
            else{
                output = output + Integer.toString(count) + Character.toString(k);
                k= list.get(i);
                count=1;
            }
        }
        output = output + Integer.toString(count) + Character.toString(k);
        return output;
    }
}

public class CountAndSay {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            String ret = new Sotion().countAndSay(n);

            String out = (ret);

            System.out.print(out);
        }
    }
}