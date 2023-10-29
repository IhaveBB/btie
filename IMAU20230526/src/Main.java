import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TV haierTv = new TV();
        Family zhangsanFamily = new Family();
        Scanner input = new Scanner(System.in);
        zhangsanFamily.buyTv(haierTv);
        System.out.println("请输入您要观看的节目");
        while(input.hasNext()) {
            int channel = input.nextInt();
            zhangsanFamily.remoterControl(channel);
            zhangsanFamily.seeTv();
            System.out.println("请输入您要观看的节目");
        }


    }
}