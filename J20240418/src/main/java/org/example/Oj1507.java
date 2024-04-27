package org.example;

import java.util.Scanner;

public class Oj1507 {
/**
 *
 *
 * @name: Oj1507
 * @author: IhaveBB
 * @date: 2024-04-19 21:09
 **/
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while(sc.hasNext()){
		int length = sc.nextInt();
		int day = 1;
		while(length != 1){
			length = (int) Math.floor(length / 2);
			day++;
		}
		System.out.println(day);
	}
}
}
