import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // 创建一个货架
        Shelf shelf = new Shelf();
        // 创建3个新商品
        Product product1 = new Product("Item1", LocalDate.of(2023, 10, 1));
        Product product2 = new Product("Item2", LocalDate.of(2023, 10, 2));
        Product product3 = new Product("Item3", LocalDate.of(2023, 10, 3));
        // 把3个商品添加到栈中
        shelf.addProduct(product1);
        shelf.addProduct(product2);
        shelf.addProduct(product3);
        System.out.println("商品数量为：" + shelf.getProductCount());

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("请输入新增加的商品名称 (输入'exit'退出)");
            String name = input.nextLine();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("请输入新增加商品的生产日期年 月 日");
            int year = input.nextInt();
            int month = input.nextInt();
            int day = input.nextInt();
            input.nextLine(); // 读取换行符
            LocalDate date = LocalDate.of(year, month, day);
            Product product = new Product(name, date);
            // 添加商品
            shelf.addProduct(product);
            // 输出新的商品数量
            System.out.println("商品数量为:" + shelf.getProductCount());
        }

        // 将所有商品卖出
        while (shelf.getProductCount() > 0) {
            shelf.sellProduct();
        }
    }
}

// 货架类
class Shelf {
    private MyStack<Product> stack = new MyStack<Product>(100);
    // 添加商品
    public void addProduct(Product product) {
        MyStack<Product> tempStack = new MyStack<>(100);
        //移动数据直到栈顶生产期日在新商品之前时
        while (!stack.isEmpty() && stack.peek().productionDate.isBefore(product.productionDate)) {
            tempStack.push(stack.pop());
        }
        stack.push(product);
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }
    // 移除商品
    public void sellProduct() {
        if (!stack.isEmpty()) {
            Product temp = stack.pop();
            System.out.println(temp.name + " " + temp.productionDate);
        }
    }

    public int getProductCount() {
        return stack.getTop();
    }
}

// 商品类
class Product {
    String name;
    LocalDate productionDate;

    public Product(String name, LocalDate productionDate) {
        this.name = name;
        this.productionDate = productionDate;
    }
}
