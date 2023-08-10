import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
       if(head == null){
           return null;
       }
       ListNode dummy =  new ListNode(0,head);
       Map<Integer, ListNode> map = new HashMap<>();
       int sum = 0;
        for (ListNode cur = dummy; cur != null; cur = cur.next) {
            sum = sum + cur.val;
            map.put(sum, cur);
        }
        sum = 0;
        for(ListNode cur = dummy; cur != null; cur = cur.next){
            sum = sum + cur.val;
            cur.next = map.get(sum).next;
        }
        return dummy.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum1 = 0;
        while(l1.next != null){
            sum1 = l1.val;
            l1 = l1.next;
        }
        int sum2 = 0;
        while(l2.next != null){
            sum2 = l2.val;
            l2 = l2.next;
        }
        int sum = sum1 + sum2;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1!= null || l2 != null || sum > 0){
            cur.next = new ListNode(sum % 10);
            sum = sum / 10;
            cur = cur.next;
        }
        return dummy.next;
    }


























    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
