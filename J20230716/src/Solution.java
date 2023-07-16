class Solution {
    public ListNode removeElements(ListNode head, int val) {
        //单链表
        ListNode cur = head;
        ListNode oldCurNext = head;
        while(head!=null&&head.val==val){
            head=head.next;
        }
        while(cur != null && cur.next != null ){
            if(cur.next.val == val){
                oldCurNext = cur.next;
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    public ListNode reverseList(ListNode head){
        ListNode cur = null;
        ListNode oldNext = null;

        while (head != null) {
            oldNext = head.next;
            head.next = cur;
            cur = head;
            head = oldNext;
        }
        return cur;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }












    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}