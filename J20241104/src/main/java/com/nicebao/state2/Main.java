package com.nicebao.state2;

import java.util.Scanner;

/**
 * @name: Main
 * @author: IhaveBB
 * @date: 2024-11-04 20:35
 **/
public class Main {
	public static void main(String[] args) {
		Context trafficLight = new Context();
		Scanner scanner = new Scanner(System.in);

		System.out.println("按下回车键以改变信号灯颜色，输入'exit'以退出。");

		while (true) {
			String input = scanner.nextLine();
			if (input.equalsIgnoreCase("exit")) {
				break;
			}
			trafficLight.switchButton();
		}

		scanner.close();
	}
}
