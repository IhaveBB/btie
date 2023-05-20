/*

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> lines = new ArrayList<Integer>();
        int num = sc.nextInt();
        while (num != 0) {
            lines.add(num);
            num = sc.nextInt();
        }
        for (int i = 0; i < lines.size() - 1; i++) {
            for (int j = lines.size() - 1; j > i; j--) {
                if (lines.get(i)==lines.get(j)) {
                    //删后面的
                    lines.remove(j);
                }
            }
        }
        System.out.println(lines);
    }
}


*/
