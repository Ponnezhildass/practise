public class LLInsertionSort {
    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = new ListNode(0, head);
        ListNode ptr = head.next;
        ListNode prev = temp;

        while(ptr !=null){
            insertionSortListUtil(temp,ptr,prev);
            prev = ptr;
            ptr = ptr.next;
        }

        return temp.next;
    }

    public void insertionSortListUtil(ListNode head, ListNode node, ListNode prev ){
        ListNode prevPtr = head;
        ListNode ptr = prevPtr.next;
        int v = node.val ;
        while(ptr!=node){
            if(ptr.val<v){
                ptr = ptr.next;
                prevPtr = prevPtr.next;
            } else {
                break;
            }
        }

        if(ptr!=node){
            ListNode temp = node.next;
            node.next = ptr;
            prevPtr.next = node;
            while(ptr !=node) {
                ptr = ptr.next;
            }
            ptr.next = temp;
        }
    }

    public static void main(String[] a){
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3,null))));

        ListNode sortedList = new LLInsertionSort().insertionSortList(head);

        while(sortedList!=null){
            System.out.println(sortedList.val);
            sortedList = sortedList.next;
        }
    }
}
