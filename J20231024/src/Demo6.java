import com.sun.jdi.PathSearchingVirtualMachine;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Demo6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String string = sc.next();
			if(string.equals("END")){
				break;
			}
			StringBuilder sb = new StringBuilder();
			for(char word : string.toCharArray()){
				if(word == 'W' || word == 'A' || word == 'F' ){
					sb.append('I');
				}else if(word == 'C'){
					sb.append('L');
				}else if(word == 'M'){
					sb.append('o');
				}else if(word == 'S'){
					sb.append('v');
				}else if(word == 'D'|| word == 'P'|| word == 'G' || word == 'B'){
					sb.append('e');
				}else if(word == 'L'){
					sb.append('Y');
				}else if(word == 'X'){
					sb.append('u');
				}else{
					sb.append(word);
				}
			}
			System.out.println(sb.toString());
		}
	}
}
