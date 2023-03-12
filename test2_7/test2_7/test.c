#define _CRT_SECURE_NO_WARNINGS
////不创建临时变量交换两个数
//#include<stdio.h>
//int main()
//{
//	int n1, n2;
//	scanf("%d %d", &n1, &n2);
//	n1 = n1 ^ n2;
//	n2 = n1 ^ n2;//n1^n2^n2
//	n1 = n1 ^ n2;//==n1^n1^n2
//	printf("%d %d", n1, n2);
//	return 0;
//


////统计二进制中1的个数
////此方法负数不行
//#include<stdio.h>
//int main()
//{
//	int num = 0;
//	scanf("%d", &num);
//	int count = 0;
//	while(num) {
//		if (num % 2 == 1) {
//			count++;
//		}
//		num = num / 2;
//	}
//	printf("%d", count);
//
//
//	return 0;
//}
//int NumberOf1(int n ) 



////统计二进制中1的个数
// 正确方法
//#include<stdio.h>
//int main()
//{
//	int num = 0;
//	scanf("%d", &num);
//	int count = 0;
//	while (num) {
//		num = num & (num - 1);
//		count++;
//	}
//	printf("%d", count);
//
//	return 0;
//}

#include <stdio.h>
int main()
{
	int a, b, c;
	a = 5;
	c = ++a;
	b = ++c, c++, ++a, a++;
	b += a++ + c;
	printf("a = %d b = %d c = %d\n:", a, b, c);
	return 0;
}