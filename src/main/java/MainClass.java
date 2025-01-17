import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while(head.val == val && head !=null ) {
            head=head.next;
        }
        if(head == null) return head;
        ListNode prev = head, curr = head.next;
        while(curr !=null){
            if(curr.val == val){
                prev.next = curr.next;
                curr = curr.next;
            }else {
                prev = prev.next;
                curr = curr.next;
            }
        }
        return head;
    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {

        String line="[1,2,6,3,4,5,6]";

            ListNode head = stringToListNode(line);

            int val = 6;

            ListNode ret = new Solution().removeElements(head, val);

            String out = listNodeToString(ret);

            System.out.print(out);

    }
}

