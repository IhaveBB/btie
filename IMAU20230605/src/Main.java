import java.net.PasswordAuthentication;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("请输入您要加密的信息");
        Scanner sc  = new Scanner(System.in);
        String text = sc.nextLine();
        String password = "123456789123456789998415";

        System.out.println("原文");
        System.out.println(text);
        System.out.println("密文");
        String ciphertext = encrypt(password,text);
        System.out.println(ciphertext);
        System.out.println("解密");
        String decryption = decrypte(password,ciphertext);
        System.out.println(decryption);

    }


    public static String encrypt(String password, String test){
        int m = test.length();
        int n = password.length();
        char [] t = test.toCharArray();
        char [] p = password.toCharArray();
        for(int i=0; i<m; i++){
            t[i]=(char)(t[i]+p[i%n]);
        }
        return new String(t);
    }

    public static String decrypte(String password, String ciphertext){
        int m = ciphertext.length();
        int n = password.length();
        char [] c = ciphertext.toCharArray();
        char [] p = password.toCharArray();
        for(int i=0; i<m; i++){
            c[i]=(char)(c[i]-p[i%n]);
        }
        return new String(c);
    }
}



