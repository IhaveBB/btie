#define _CRT_SECURE_NO_WARNINGS
//����С������
//#include<stdio.h>
//int main()
//{
//	int a, b;
//	scanf("%d %d", &a, &b);
//	int m = a > b ? a : b;
//	while (m % a != 0 || m % b != 0)
//	{
//		m++;
//	}
//	printf("%d\n", m);
//	return 0;
//}

//
#include<stdio.h>
int main()

{

    char ch = 0;

    while ((ch = getchar())!EOF)

    {

        getchar();

        if (ch == 'a')

            printf("%c", ch + 32);

    }

    return 0;

}