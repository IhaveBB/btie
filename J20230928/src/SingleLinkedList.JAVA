import java.util.LinkedList;
class SingleLinkedList {
    private ListNode head;
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
    public SingleLinkedList() {
        head = null;
    }
    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        node.next = head;
        head = node;
    }
    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        //如果链表为空就直接插入
        if(head == null){
            head = node;
            return;
        }
        ListNode cur = head;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
    }
    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
        if (index < 0 || index > size()) {
            return false;
        }
        if(index == 0){
            addFirst(data);
        }else{
            ListNode node = new ListNode(data);
            ListNode cur = head;
            for(int i = 0; i < index - 1; i++){
                cur = cur.next;
            }
            node.next = cur.next;
            cur.next = node;
        }
        return true;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur = head;
        while(cur != null){
            if(cur.val == key){
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
        /*if (head != null && head.val == key) {
            head = head.next;
        }
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == key) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }*/
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
    public int size(){
        ListNode cur = head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    public void display(){
        ListNode cur = head;
        while(cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void clear(){
        //head == null 过于粗暴
        ListNode cur = head;
        ListNode curNext = null;
        while(cur != null){
            curNext = cur.next;
            cur.next = null;
            cur = cur.next;
        }
        head = null;
    }
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