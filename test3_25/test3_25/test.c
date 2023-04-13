#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
union Un
{
	short s[7];
	int n;
};
int main()
{
	printf("%d\n", sizeof(union Un));
	return 0;
}