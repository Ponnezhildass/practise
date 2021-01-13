import java.util.ArrayList;
import java.util.List;

public class Justification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList();
        List<String> output = new ArrayList();
        List<Integer> word = new ArrayList();
        String line = "";
        int start =0;

        for(String s : words){
            if(line.length() + 1 + s.length()<=maxWidth || (line.isEmpty() &&s.length()<=maxWidth)){

                if(!line.isEmpty())
                    line+=" ";
                line+= s;
                start++;
            }
            else {
                list.add(line);
                word.add(start);
                start =1;
                line = "";
                line+= s;
            }
        }
        list.add(line);
        word.add(start);
        int index =0;
        start = 0;
        for(String s: list){
            if(word.get(index) == 1 || index == list.size()-1) {
                String x =s;
                while(x.length()<maxWidth){
                    x += " ";
                }
                output.add(x);
                start += word.get(index);
                index ++;
                continue;}
            String[] spaces = new String[word.get(index)-1];
            for(int i=0;i<spaces.length;i++){
                spaces[i] = " ";
            }
            int l = s.length();
            int j =0;
            if(l == maxWidth) {output.add(s); start += word.get(index); index ++;continue;}
            while(l<maxWidth){
                if(j==spaces.length) j =0;
                spaces[j]+=" ";
                l++;
                j++;
            }
            String x = "";
            for(int i= start;i<word.get(index)+start && i<words.length;i++){
                x+= words[i];
                if(i-start<spaces.length)x+= spaces[i-start];
            }
            start += word.get(index);
            index++;
            output.add(x);
        }
        return output;
    }

    public static void main(String[] args){
        Justification justification = new Justification();
        String[] strings = {"What","must","be","acknowledgment","shall","be"};
        for(String s : justification.fullJustify(strings,16)){
            System.out.println(s);
        }
    }
}
