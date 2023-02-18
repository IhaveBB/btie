#define _CRT_SECURE_NO_WARNINGS
//求最小公倍数
#include<stdio.h>
int main()
{
	int a, b;
	scanf("%d %d", &a, &b);
	int m = a > b ? a : b;
	while (m % a != 0 || m % b != 0)
	{
		m++;
	}
	printf("%d\n", m);
	return 0;
}