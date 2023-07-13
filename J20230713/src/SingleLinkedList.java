import com.sun.deploy.util.SearchPath;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.List;

// 1、无头单向非循环链表实现
public class SingleLinkedList {
    static class ListNode {
        public int val;
        public ListNode next;
        public ListNode head;

        public ListNode(int val) {
            this.val = val;
        }

        public void createList() {

            ListNode node1 = new ListNode(12);
            ListNode node2 = new ListNode(23);
            ListNode node3 = new ListNode(34);
            ListNode node4 = new ListNode(45);
            ListNode node5 = new ListNode(56);

            this.head = node1;
            node1.next = node2;
            node2.next = node3;
            node3.next = node4;
            node4.next = node5;
            node5.next = null;
        }


        //头插法
        public void addFirst(int data) {
            ListNode node = new ListNode(data);
            node.next = head;
            head = node;
        }

        //尾插法
        public void addLast(int data) {
            ListNode node = new ListNode(data);
            ListNode cur = head;
            //没有元素的情况，直接插入
            if (cur == null) {
                head = node;
                return;
            }
            //找到尾部节点的尾巴
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }

        //任意位置插入,第一个数据节点为0号下标
        public void addIndex(int index, int data) {
            //检测index是否合法
            if (index < 0 || index > size()) {
                throw new IndexOutOfBoundsException("Out of bounds");
            }
            if (index == 0) {
                addFirst(data);
                return;
            } else if (index == size()) {
                addLast(data);
                return;
            }
            ListNode cur = findIndexSubOne(index);
            ListNode node = new ListNode(data);
            node.next = cur.next;
            cur.next = node;
        }

        //查找是否包含关键字key是否在单链表当中
        public boolean contains(int key) {
            ListNode cur = findIndexSubOne(key);
            while (cur != null) {
                if (cur.val == key) {
                    return true;
                }
                cur = cur.next;
            }
            return false;
        }

        //删除第一次出现关键字为key的节点
        public void remove(int key) {
            //判断key是否在单链表中
            if (!contains(key)) {
                System.out.println("Key not found");
                return;
            }
            if (head == null) {
                return;
            }
            //单独删除头节点,跳过即可
            if (head.val == key) {
                head = head.next;
                return;
            }
            ListNode cur = searchPrev(key);
            cur.next = cur.next.next;
        }

        //删除所有值为key的节点
        public void removeAllKey(int key) {
            if (head == null) {
                return;
            }
            ListNode cul = head.next;
            ListNode prev = head;
            while (cul != null) {
                if (cul.val == key) {
                    prev.next = cul.next;
                    cul = cul.next;
                } else {
                    prev = cul;
                    cul = cul.next;
                }
            }
            if (head.val == key) {
                head = head.next;
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
                cur = cur.next;
            }

        }

        public void clear() {
            this.head = null;
        }

        //找到要删除位置的前一个节点
        private ListNode findIndexSubOne(int index) {
            ListNode cur = head;
            while (index - 1 != 0) {
                cur = cur.next;
                index--;
            }
            return cur;
        }

        //找到key的前驱
        private ListNode searchPrev(int key) {
            ListNode cur = head;
            while (cur.next != null) {
                if (cur.next.val == key) {
                    return cur;
                }
                cur = cur.next;
            }
            return null;
        }
    }
}