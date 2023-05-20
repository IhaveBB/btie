import java.lang.management.MonitorInfo;
import java.nio.channels.InterruptedByTimeoutException;
import java.util.ArrayList;
import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        ArrayList<Fruit> list = new ArrayList<Fruit>();
        Scanner input=new Scanner(System.in);
        //添加水果信息
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        double price = sc.nextDouble();
        list.add(new Fruit(name, price));
        System.out.println("添加成功");
        ///删除水果信息
        removeFruit(list);
        //查询水果
        displayFruits(list);
        //水果总数
        getTotalCount(list);



    }


    public static void removeFruit(ArrayList<Fruit> list){
        //删除水果信息
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        for(int i=0;i<list.size();i++) {
            if(list.get(i).name.equals(name)){
                list.remove(i);
                System.out.println("删除成功");
            }
            else{
                System.out.println("删除失败");
            }
        }
    }

    public static void displayFruits(ArrayList<Fruit> list) {
        if (list.isEmpty()) {
            System.out.println("没有水果信息。");
        } else {
            System.out.println("水果信息如下：");
            for (Fruit fruit : list) {
                fruit.toString();
                System.out.println();
            }
        }
    }
    //显示水果总数
    public static void getTotalCount(ArrayList<Fruit> list) {
        System.out.println("水果总数：" + list.size());
    }

}





class Fruit{
    String name;
    double price=0;
    public Fruit(String name,double price){
        this.name = name;
        this.price = price;
    }
    public String toString(){
        return "种类"+name+" "+"价格"+price;
    }
}
class Apple extends Fruit{
    public Apple(String name,double price){
        super(name,price);
    }
    @Override
    public String toString(){
        return "种类"+name+" "+"价格"+price;
    }
}
class Oringe extends Fruit{
    public Oringe(String name,double price){
        super(name,price);
    }
    @Override
    public String toString(){
        return "种类"+name+" "+"价格"+price;
    }
}

