import java.util.Stack;

public class Parenthesis {
    public boolean checkValidString(String s) {

        Stack<Character> stack = new Stack();
        return checkValidStringUtil(s,stack);
    }

    public boolean checkValidStringUtil(String s, Stack<Character> stack){
        for(int i =0; i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push('(');
            }
            else if (s.charAt(i)==')'){
                if(stack.isEmpty()){ return false;}
                else {stack.pop();}
            } else {
                boolean res = checkValidStringUtil(s.substring(i+1),(Stack<Character>)stack.clone());
                if(res) return true;
                stack.push('(');
                res = checkValidStringUtil(s.substring(i+1),(Stack<Character>)stack.clone());
                if(res) return true;
                stack.pop();
                if(stack.isEmpty()){ return false;}
                else {
                    stack.pop();
                    res = checkValidStringUtil(s.substring(i+1),(Stack<Character>)stack.clone());
                }
                return res;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        Parenthesis parenthesis = new Parenthesis();
        String s = "(((((*(((((*((**(((*)*((((**))*)*)))))))))((*(((((**(**)";
        System.out.println(parenthesis.checkValidString(s));
    }
}
