import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis {
    int N;
    public List<String> generateParenthesis(int n) {
        N= n;
        Stack<String> stack = new Stack();
        List<String> output = new ArrayList();
        generateParenthesisUtil(output,"",0,0);
        return output;
    }

    public void generateParenthesisUtil( List<String> output, String curr, int open, int close){
        if(curr.length()== 2*N){
            output.add(curr);
            return;
        }
        String string = "";
        for(Character c : string.toCharArray()){

        }
        if(open<N)
            generateParenthesisUtil(output,curr+"(",open+1,close);
        if(close<open)
            generateParenthesisUtil(output,curr+")",open,close+1);
    }

    public static void main(String[] args){
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> list = generateParenthesis.generateParenthesis(3);
        for(String string : list)
            System.out.println(string);
    }
}
