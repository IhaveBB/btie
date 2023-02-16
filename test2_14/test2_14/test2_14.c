#define _CRT_SECURE_NO_WARNINGS
////判断是大端还是小端
//#include<stdio.h>
//check_sys()
//{
//	int a = 1;
//	if (*(char*)&a == 1)
//		return 1;//小端
//	else
//		return 0;//大端
//}
//
//int main()
//{
//	if (check_sys() == 1)
//		printf("大端");
//	else
//		printf("小端");
//
//	return 0;
//}




//#include<stdio.h>
//int main()
//{
//	unsigned char a = 200;
//	unsigned char b = 100;
//	unsigned char c = 0;
//	c = a + b;
//	printf(" % d % d", a + b, c);
//	return 0;
//


////日本某地发生了一件谋杀案，警察通过排查确定杀人凶手必为4个嫌疑犯的一个。
////以下为4个嫌疑犯的供词:
////A说：不是我。
////B说：是C。
////C说：是D。
////D说：C在胡说
////已知3个人说了真话，1个人说的是假话。
////现在请根据这些信息，写一个程序来确定到底谁是凶手。
//#include<stdio.h>
//int main()
//{
//	int tmp = 0;
//	char killer;
//	for (killer = 'A'; killer <= 'D'; killer++) {
//		if (killer != 'A')
//			tmp++;
//		else if (killer == 'C')
//			tmp++;
//		else if (killer == 'D')
//			tmp++;
//		else if (killer != 'D')
//			tmp++;
//		if (tmp == 3)
//			printf("凶手是%c", killer);
//	}
//	return 0;
//}






////杨辉三角形
//#include<stdio.h>
//int main()
//{
//	int arr[50][50] = { 0 };
//	int n = 0;
//	scanf("%d", &n);
//	for (int i = 0; i < n; i++)
//	{
//		arr[i][0] = 1;
//		arr[i][i] = 1;
//	}
//	for (int i = 2; i < n; i++)
//	{
//		for (int j = 1; j < i; j++)
//		{
//			arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
//
//		}
//	}
//	for (int i = 0; i < n; i++)
//	{
//		for (int j = 0; j <= i; j++)
//		{
//			printf("%3d ", arr[i][j]);
//		}
//		printf("\n");
//	}
//
//	return 0;
//}




////5位运动员参加了10米台跳水比赛，有人让他们预测比赛结果：
////A选手说：B第二，我第三；
////B选手说：我第二，E第四；
////C选手说：我第一，D第二；
////D选手说：C最后，我第三；
////E选手说：我第四，A第一；
////比赛结束后，每位选手都说对了一半，请编程确定比赛的名次。
//#include <stdio.h>
//
//int main() {
//    int A, B, C, D, E;
//
//    for (A = 1; A <= 5; A++) {
//        for (B = 1; B <= 5; B++) {
//            if (B == A) continue;
//            for (C = 1; C <= 5; C++) {
//                if (C == A || C == B) continue;
//                for (D = 1; D <= 5; D++) {
//                    if (D == A || D == B || D == C) continue;
//                    E = 15 - A - B - C - D;
//                    if (((B == 2) + (A == 3) == 1) && ((B == 2) + (E == 4) == 1) && ((C == 1) + (D == 2) == 1) && ((C == 5) + (D == 3) == 1) && ((E == 4) + (A == 1) == 1)) {
//                        printf("A=%d B=%d C=%d D=%d E=%d\n", A, B, C, D, E);
//                    }
//                }
//            }
//        }
//    }
//
//    return 0;
//}