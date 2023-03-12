#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>

void printDigits(int n) {
	printf("%d ", n % 10);
}

int mian()
{
	int num=0;
	scanf("%d",&num);
	printDigits(num / 10);
	return 0;
}