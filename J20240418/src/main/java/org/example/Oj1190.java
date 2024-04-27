package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Oj1190 {
/**
 *
 *
 * @name: Oj1190
 * @author: IhaveBB
 * @date: 2024-04-19 20:51
 **/
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int m = 1;
	List<Integer> list = new ArrayList<>();
	while(scanner.hasNext()){
		list.add(scanner.nextInt());
	}
	int pre = list.get(0);
	for(int i = 1; i < list.size(); i++){
		int temp = list.get(i);
		if(pre >= temp){
			m++;
		}
		pre = temp;
	}
	System.out.print(m);
}

}
