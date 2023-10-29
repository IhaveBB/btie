public class Demo2 {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();

        // 添加元素
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        // 显示链表内容
        System.out.println("链表内容:");
        list.display(); // 应该输出: 1 2 3 4

        // 插入元素
        list.addIndex(2, 5);
        System.out.println("插入元素后的链表内容:");
        list.display(); // 应该输出: 1 2 5 3 4

        // 查找元素
        int keyToFind = 5;
        boolean containsKey = list.contains(keyToFind);
        System.out.println("是否包含关键字 " + keyToFind + ": " + containsKey); // 应该输出: 是否包含关键字 5: true

        // 删除元素
        list.remove(3);
        System.out.println("删除元素后的链表内容:");
        list.display(); // 应该输出: 1 2 5 4

        // 删除所有指定元素
        list.removeAllKey(5);
        System.out.println("删除所有指定元素后的链表内容:");
        list.display(); // 应该输出: 1 2 4

        // 获取链表长度
        int size = list.size();
        System.out.println("链表长度: " + size); // 应该输出: 链表长度: 3

        // 清空链表
        list.clear();
        System.out.println("清空链表后的链表内容:");
        list.display(); // 应该输出: 空行

        // 再次获取链表长度
        size = list.size();
        System.out.println("清空后的链表长度: " + size); // 应该输出: 清空后的链表长度: 0
    }
}
