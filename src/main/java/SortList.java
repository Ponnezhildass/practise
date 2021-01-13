public class SortList {

        public ListNode sortList(ListNode head) {
            if(head == null) return null;
            if(head.next == null) return head;
            if(head.next.next == null){
                if(head.val>head.next.val){
                    head.next.next = head;
                    ListNode t1 = head.next;
                    head.next = null ;
                    return t1;
                }
                return head;
            }

            ListNode center = findCenter(head);
            ListNode temp = center.next;
            center.next = null;
            ListNode l1 = sortList(head);
            ListNode l2 = sortList(temp);
            ListNode result = new ListNode(0);
            ListNode output = result;
            while(l1 != null && l2 != null){
                if(l1.val<l2.val){
                    result.next = l1 ;
                    l1 = l1.next;
                    result = result.next;
                    result.next = null;
                } else {
                    result.next = l2 ;
                    l2 = l2.next;
                    result = result.next;
                    result.next = null;
                }
            }

            if(l1 != null){
                result.next = l1;
            }

            if(l2 != null){
                result.next = l2;
            }

            return output.next;

        }

        public ListNode findCenter(ListNode head){
            ListNode fast = head, slow = head;
            while(fast != null){
                fast = fast.next;
                if(fast!=null){
                    fast = fast.next;
                    slow = slow.next;
                } else {
                    return slow;
                }
            }
            return slow;
        }

        public static void main(String[] args){

            int[] arr = {-1,5,3,4,0};
            ListNode l1 = new ListNode(0);
            ListNode head = l1;
            for(int i : arr){
                ListNode listNode = new ListNode(i);
                l1.next = listNode;
                l1 = l1.next;
            }
            head = head.next;
            SortList sortList = new SortList();
            l1 = sortList.sortList(head);
            while(l1!=null){
                System.out.println(l1.val);
                l1 = l1.next;
            }
        }

}
