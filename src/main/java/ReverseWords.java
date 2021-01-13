import java.util.Stack;

public class ReverseWords {
    public static void reverseWords(String str){
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                while(!stack.isEmpty()){
                    System.out.print(stack.pop());
                }
                System.out.print(" ");
            }
            else{
                stack.push(str.charAt(i));
            }
        }
    }
    public static void main(String[] args)
    {
        String str = "Geeks for Geeks";
        reverseWords(str+" ");
    }
}
