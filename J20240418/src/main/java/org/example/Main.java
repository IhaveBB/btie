package org.example;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] missileHeights = new int[20];
		int numMissiles = 0;

		// 读取输入的导弹高度数据
		while (scanner.hasNextInt()) {
			missileHeights[numMissiles] = scanner.nextInt();
			numMissiles++;
		}

		// 记录拦截的导弹数量
		int interceptCount = 1; // 第一枚导弹可以拦截任意高度的导弹

		// 判断导弹是否能被拦截
		for (int i = 1; i < numMissiles; i++) {
			boolean canIntercept = true;
			for (int j = i + 1; j < numMissiles; j++) {
				if (missileHeights[j] >= missileHeights[i]) {
					canIntercept = false;
					break;
				}
			}
			if (canIntercept) {
				interceptCount++;
			}
		}

		System.out.println(interceptCount+1);
	}
}
