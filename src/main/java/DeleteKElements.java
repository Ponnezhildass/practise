import java.io.Serializable;
import java.util.Stack;

public class DeleteKElements  {

    private static void deleteElements(int[] arr, int n, int k){

        Stack<Integer> stack = new Stack();
        stack.push(arr[0]);
        for(int i=1;i<n;i++){
            if(stack.isEmpty()) {stack.push(arr[i]);}
            else if(arr[i] > stack.peek()){
                stack.pop();
                k--;
                i--;
                if(k<=0) {
                    for(int j =i+1;j<n;j++)
                        stack.push(arr[j]);break;
                }
            } else {stack.push(arr[i]);}
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }


    public static void main(String[] args) {
        int n = 5, k = 3;
        int arr[] = { 23, 45, 11, 77, 18};
        deleteElements(arr, n, k);
    }
}
