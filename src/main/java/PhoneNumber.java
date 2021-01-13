import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class PhoneNumberSolution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList();
        String temp = "abc";
        list.add(temp);
        temp = "def";
        list.add(temp);
        temp = "ghi";
        list.add(temp);
        temp = "jkl";
        list.add(temp);
        temp = "mno";
        list.add(temp);
        temp = "pqrs";
        list.add(temp);
        temp = "tuv";
        list.add(temp);
        temp = "wxyz";
        list.add(temp);

        List<String> result = new ArrayList();
        result.add("");
        for(int i=0;i<digits.length();i++){
            int a = Integer.valueOf(digits.charAt(i)-'0')-2;
            int size = result.size();
            for(int j=0;j<size;j++){
                String s = result.remove(0);
                for(int k=0;k<list.get(a).length();k++){
                    result.add(s+ list.get(a).substring(k,k+1));
                }
            }
        }
        return list;
    }
}

public class PhoneNumber {


    public static String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringList) {
            sb.append(item);
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String digits = line;

            List<String> ret = new PhoneNumberSolution().letterCombinations(digits);

            String out = stringListToString(ret);

            System.out.print(out);
            return ;
        }
    }
}