#define _CRT_SECURE_NO_WARNINGS
////��������ʱ��������������
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


////ͳ�ƶ�������1�ĸ���
////�˷�����������
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



////ͳ�ƶ�������1�ĸ���
// ��ȷ����
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