public class Demo1 {
    public static void main(String[] args) {
        MyArraylist list = new MyArraylist();

        // 添加元素
        list.add(1);
        list.add(2);
        list.add(3);

        // 打印顺序表
        System.out.println("顺序表内容：");
        list.display();

        // 在指定位置添加元素
        list.add(1, 4);

        // 打印顺序表
        System.out.println("在位置1添加元素4后的顺序表内容：");
        list.display();

        // 判断是否包含某个元素
        System.out.println("是否包含元素 3：" + list.contains(3));

        // 查找某个元素的位置
        System.out.println("元素 2 的位置：" + list.indexOf(2));

        // 获取指定位置的元素
        System.out.println("位置1的元素：" + list.get(1));

        // 更新指定位置的元素
        list.set(0, 0);
        System.out.println("更新位置0的元素后的顺序表内容：");
        list.display();

        // 删除元素
        list.remove(2);
        System.out.println("删除元素2后的顺序表内容：");
        list.display();

        // 获取顺序表长度
        System.out.println("顺序表长度：" + list.size());

        // 清空顺序表
        list.clear();
        System.out.println("清空顺序表后的内容：");
        list.display();
    }
}
