import java.util.List;

/**
 * @author IhaveBB
 */
// 2、无头双向链表实现
public class MyLinkedList {
    static class ListNode {
        private int val;
        private ListNode prev;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode head;
        public ListNode last;

        //头插法
        public void addFirst(int data) {
            ListNode node = new ListNode(data);
            if (head == null) {
                head = node;
                last = node;
            } else {
                node.next = head;
                head.prev = node;
                head = node;
            }
        }

        //尾插法
        public void addLast(int data) {
            ListNode node = new ListNode(data);
            //判断是不是第一次插入
            if (last == null) {
                head = node;
                last = node;
            }else{
                last.next = node;
                node.prev = last;
                last = last.next;
            }
        }

        //任意位置插入,第一个数据节点为0号下标
        public void addIndex(int index, int data) {
            ListNode node = new ListNode(data);
            ListNode cur = searchIndex(index);

            checkIndex(index);
            if(index == 0) {
                addFirst(data);
                return;
            }
            if(index == size()){
                addLast(data);
                return;
            }
            node.next = cur;
            cur.prev.next = node;
            node.prev = cur.prev;
            cur.prev = node;
        }
        private ListNode searchIndex(int index) {
            ListNode cur = head;
            while(index != 0){
                cur = cur.next;
                index--;
            }
            return cur;
        }

        private void checkIndex(int index){
            if(index<0||index>=size()){
                throw new IndexOutOfException("Index out of bounds：index=  "+index);
            }
        }
        //查找是否包含关键字key是否在单链表当中
        public boolean contains(int key) {
            ListNode cur = head;
            while (cur != null) {
                if (cur.val == key) {
                    return true;
                }
                cur = cur.next;
            }
            return false;
        }

        //删除第一次出现关键字为key的节点
        public void remove(int key){
            ListNode cur = head;
            while (cur != null) {
                if(cur.val == key) {
                    if(cur == head) {
                        head = head.next;
                        if(head != null) {
                            head.prev = null;
                        }else {
                            last = null;
                        }
                    }else {
                        if(cur.next != null) {
                            cur.prev.next = cur.next;
                            cur.next.prev = cur.prev;
                        }else {
                            cur.prev.next = cur.next;
                            last = last.prev;
                        }
                    }
                    return;
                }else {
                    cur = cur.next;
                }
            }
        }

        public void removeAllKey(int key){
            ListNode cur = head;
            while (cur != null) {
                if(cur.val == key) {
                    if(cur == head) {
                        head = head.next;
                        if(head != null) {
                            head.prev = null;
                        }else {
                            last = null;
                        }
                    }else {
                        if(cur.next != null) {
                            cur.prev.next = cur.next;
                            cur.next.prev = cur.prev;
                        }else {
                            cur.prev.next = cur.next;
                            last = last.prev;
                        }
                    }
                    cur = cur.next;
                }else {
                    cur = cur.next;
                }
            }
        }

        //得到单链表的长度
        public int size() {
            int count = 0;
            ListNode cur = head;
            while (cur != null) {
                count++;
                cur = cur.next;
            }
            return count;
        }

        public void display() {
            ListNode cur = head;
            while (cur != null) {
                System.out.println(cur.val + " ");
            }
        }

        public void clear() {
            head = null;
            last = null;
        }
    }
}