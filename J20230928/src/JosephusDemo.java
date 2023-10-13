import java.util.Scanner;

public class JosephusDemo {
    public static void main(String []args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入总人数");
        int n = input.nextInt();
        System.out.println("请输入第一圈的最大值");
        int max = input.nextInt();
        Josephus josephus = new Josephus();
        // 创建一个包含 n 个人的循环列表
        josephus.Insert(n);
        // 开始步数为 max 的淘汰游戏
        josephus.gameStart(max);
    }
}


class Josephus {
    public People first = null;
    public People last = null;
    public int n = 0;

    public void Insert(int n) {
        Scanner sc = new Scanner(System.in);
        this.n = n;
        /*
        keyArr数组用来存储于密码，数组长度n+1的原因：因为在下面的循环中，i用来表示人数。
        所以数组也从1位置开始使用，0下标不使用.
         */
        int keyArr [] = new int[n+1];
        keyArr[0] = 0;
        for (int i = 1; i <= n; i++) {
            System.out.println("请您输入第"+i+"个密码 ");
            int key = sc.nextInt();
            keyArr[i] = key;
            People node = new People(i, key);
            //第一次插入
            if (i == 1) {
                last = first = node;
                first.setNext(first);
            } else {
                last.setNext(node);
                last = node;
                last.setNext(first);
            }
        }
        System.out.println("您输入的密码为");
        for(int i = 1; i <= n; i++){
            System.out.print(keyArr[i] + " ");
        }
        System.out.println();
    }

    public void gameStart(int max) {
        People tmpNode = null;
        System.out.println("出列顺序为：");
        People cur = first;
        while (n > 1) {
            // 移动到要淘汰的人之前的位置
            for (int i = 1; i < max - 1; i++) {
                cur = cur.getNext();
            }
            // 获取当前淘汰的人的密码值
            max = cur.getNext().getKey();
            /*
            如果密码为1，那么就不进行cur = cur.next的操作
            原因：当密码大于1时，for循环能正确的执行，从而找到要操作的前一个节点。
                 当密码等于1时，如果不进行if判断，那么cur节点指向的就是要操作的节点，而不是要操作的前一个节点
                 所以当密码等于1时，不进行cur=cur.next操作，从而保证cur始终指向要操作节点的前一个节点
             */
            if(max == 1){
                // 输出出队人员编号
                System.out.print(cur.getNext().getNumber() + " ");
                // 移除淘汰的人
                cur.setNext(cur.getNext().getNext());
                n--; // 更新剩余人数........
            }else {
                // 输出出队人员编号
                System.out.print(cur.getNext().getNumber() + " ");
                // 移除淘汰的人
                cur.setNext(cur.getNext().getNext());
                n--; // 更新剩余人数........
                cur = cur.getNext(); // 移动到下一个人
            }
        }
        // 输出最后一个人的编号
        System.out.println(cur.getNumber());
    }
}

class People {
    private int number = 0;
    private int key = 0;
    private People next;

    public People(int number, int key) {
        this.number = number;
        this.key = key;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public People getNext() {
        return next;
    }

    public void setNext(People next) {
        this.next = next;
    }
}
