public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //交点后的长度是一致的，先求出来两个的长度，倒序求交点
        int lengthA = 0;
        int lengthB = 0;
        ListNode curS = headA;
        ListNode curL = headB;
        //分别求长度
        while (curS != null) {
            lengthA++;
            curS = curS.next;
        }
        while (curL != null) {
            lengthB++;
            curL = curL.next;
        }
        //假设A>B，求出差值即可，不需要具体看谁大谁小
        int length = lengthA - lengthB;
        //修正定义指向
        curL = headA;
        curS = headB;
        //如果小于0证明B>A；
        if (length < 0) {
            length = lengthB - lengthA;
            //修正定义指向
            curS = headA;
            curL = headB;
        }
        //让最长的链表先走差值
        while (length != 0) {
            curL = curL.next;
            length--;
        }
        //找到相遇的点
        while (curL != curS) {
            curL = curL.next;
            curS = curS.next;
        }
        return curL;
    }

    //判断是否有环
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public ListNode deleteDuplication(ListNode pHead) {
        ListNode cur = pHead;
        ListNode newHead = new ListNode(-1);
        ListNode tempHead = newHead;
        //遍历每个节点
        while (cur != null) {
            //找到重复的节点
            if (cur.next != null && cur.val == cur.next.val) {
                //让cur一直走到不重复的节点
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
            } else {
                tempHead.next = cur;
                tempHead = tempHead.next;
                cur = cur.next;
            }
        }
        tempHead.next = null;
        return newHead.next;
    }
}


































class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
