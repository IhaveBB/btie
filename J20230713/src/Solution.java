class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null||k<=0){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        //寻找链表中倒数第k个结点
        //fast先走k-1步
        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
            if(fast == null){
                return null;
            }
        }
        //再同频走  一人一步
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode mergeTwoList(ListNode headA,ListNode headB){
        ListNode newHead = new ListNode();
        ListNode tempHead = newHead;
        while(headA != null && headB != null)
        {
            if(headA.val>headB.val){
                tempHead.next = headB;
                tempHead = tempHead.next;
                headB = headB.next;
            }
            else{
                tempHead.next = headA;
                tempHead = tempHead.next;
                headA = headA.next;
            }
        }
        if(headA!=null){
            tempHead.next = headA;
        }
        if(headB!=null){
            tempHead.next = headB;
        }

        return newHead.next;
    }


    public ListNode partition(ListNode pHead, int x) {
        ListNode cur = pHead;
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        while (cur != null) {
            if (cur.val < x) {
                if (bs == null) {
                    bs = be = cur;
                } else {
                    be.next = cur;
                    be = be.next;
                }

            } else {
                if (as == null) {
                    as = ae = cur;
                } else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        if (bs == null) {
            return as;
        }
        //bs和as连接起来
        be.next = as;
        if (as != null) {
            //最后一个变为nul
            ae.next = null;
        }
        return bs;
    }


    public boolean chkPalindrome(ListNode A) {
        ListNode head = A;
        //线找中间的元素
        ListNode mid = middleNode(A);
        ListNode cur = mid.next;
        //反转指针的指向，让中间后面的元素指向中间。
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = mid;
            mid = cur;
            cur = curNext;
        }
        while(head!=mid){
            if(head.val != mid.val){
                return false;
            }
            if(head.next == mid){
                return  true;
            }
            head = head.next;
            mid = mid.next;
        }
        return true;
    }





}