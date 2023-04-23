import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       /*Student s1=new Student("张三",19,"男","内蒙古农业大学","计算机类");
       Computer s2=new Computer("张三的电脑","i9 12900k","DDR5 16G*2","技嘉","致态1T","七彩虹3060ti");*/
        Scanner sc =new Scanner(System.in);
        System.out.println("请输入体重");
        double w=sc.nextDouble();
        System.out.println("请输入身高");
        double h=sc.nextDouble();
        BMI user1=new BMI(w,h);
        System.out.printf("%.4f",user1.bmi());
    }
}



