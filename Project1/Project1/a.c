import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Student s = new Student(""); // ʵ����ѧ������
        Scanner SC = new Scanner(System.in);
        menu();
        int choice = SC.nextInt();

        while (choice != -1) { // ѡ��ѭ��
            switch (choice) {
            case 1:
                s.select("java", 1);
                break;
            case 2:
                s.select("C++", 2);
                break;
            case 3:
                s.select("C", 3);
                break;
            case 4:
                s.select("AI", 4);
                break;
            case 5:
                s.select("Python", 5);
                break;
            default:
                System.out.println("��Ч��ѡ�α�ţ�");
                break;
            }
            System.out.println("����������ѡ�ε����,ѡ����밴-1���к�������");
            choice = SC.nextInt();
        }

        int option = 0;
        while (option != 3) { // �˿�ѭ��
            System.out.println("����1�����˿�,����2�鿴��ǰ��ѡ�γ�,����3�˳�");
            option = SC.nextInt();
            switch (option) {
            case 1:
                System.out.println("��ǰ��ѡ�γ�:");
                s.query();
                System.out.println("�������˿εı��");
                int course = SC.nextInt();
                s.delete(course);
                System.out.println("�˿γɹ�");
                break;
            case 2:
                System.out.println("��ǰ��ѡ�γ�:");
                s.query();
                break;
            case 3:
                System.out.println("�˳�ѡ��ϵͳ");
                break;
            default:
                System.out.println("��Ч��ѡ�");
                break;
            }
        }
    }

    public static void menu() {
        System.out.println("java 1");
        System.out.println("C++  2");
        System.out.println("C  3");
        System.out.println("AI   4");
        System.out.println("Python  5");
    }
}
