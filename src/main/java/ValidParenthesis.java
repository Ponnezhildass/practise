import java.io.Serializable;
import java.util.Stack;

public class ValidParenthesis  {
    public boolean isValid(String s) {
        int [][] a = new int[s.length()][s.length()];
        Stack<Character> stack = new Stack();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            } else {
                if(stack.isEmpty()) return false;
                if (stack.pop() != s.charAt(i)) return false;
            }
        }
        System.out.println(this);
        if(stack.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        ValidParenthesis validParenthesis = new ValidParenthesis();
        String string = "([{";
        System.out.println(validParenthesis.isValid(string));
    }
}
