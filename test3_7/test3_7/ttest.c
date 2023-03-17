////网购
//#include<stdio.h>
//int main()
//{
//
//    double money = 0, actual_money = 0;
//    int month = 0, data = 0, ticket = 0;
//
//    scanf("%lf %d %d %d", &money, &month, &data, &ticket);
//    if (data == 11 && month == 11)
//    {
//        if (ticket == 1)
//        {
//            if (money * 0.7 - 50 < 0)
//            {
//                printf("0.00");
//                return 0;
//            }
//            printf("%0.2lf", money * 0.7 - 50);
//        }
//        else
//        {
//            if (money * 0.7 - 50 < 0)
//            {
//                printf("0.00");
//                return 0;
//            }
//            printf("%0.2lf", money * 0.7);
//        }
//    }
//    else if (data == 12 && month == 12)
//    {
//        if (ticket == 1)
//        {
//
//            printf("%0.2lf", money * 0.8 - 50);
//        }
//        else
//        {
//            printf("%0.2lf", money * 0.8);
//        }
//    }
//
//    return 0;
//}


////获得月份天数
//#define _CRT_SECURE_NO_WARNINGS
//#include<stdio.h>
//int main()
//{
//    int year = 0, month = 0;
//    while (scanf("%d %d", &year, &month) != EOF) {
//
//        if (year == 0 && month == 0) {  // 如果年份和月份都是0，结束循环
//            break;
//        }
//        switch (month)
//        {
//        case 1:
//        case 3:
//        case 5:
//        case 7:
//        case 8:
//        case 10:
//        case 12:
//        {
//            printf("31\n");
//            break;
//        }
//        case 4:
//        case 6:
//        case 9:
//        case 11:
//        {
//            printf("30\n");
//            break;
//        }
//        case 2:
//            if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0)
//            {
//                printf("29\n");
//            }
//            else
//                printf("28\n");
//            break;
//        }
//    }
//
//    return 0;
//}

////序列中删除指定的数字
//#include<stdio.h>
//
//int main()
//{
//    int n, x;
//    scanf("%d", &n);
//
//    int arr[50];
//    for (int i = 0; i < n; i++)
//    {
//        scanf("%d", &arr[i]);
//    }
//
//    scanf("%d", &x);
//
//    int j = 0;
//    for (int i = 0; i < n; i++)
//    {
//        if (arr[i] != x)
//        {
//            arr[j++] = arr[i];
//        }
//    }
//
//    for (int i = 0; i < j; i++)
//    {
//        printf("%d ", arr[i]);
//    }
//
//    return 0;
//}


////矩阵相等判断
//#include <stdio.h>
//
//
//int main() {
//    int n, m;
//    scanf("%d %d", &n, &m);
//    int matrix1[n][m];
//    int matrix2[n][m];
//
//    for (int i = 0; i < n; i++) {
//        for (int j = 0; j < m; j++) {
//            scanf("%d", &matrix1[i][j]);
//        }
//    }
//    for (int i = 0; i < n; i++) {
//        for (int j = 0; j < m; j++) {
//            scanf("%d", &matrix2[i][j]);
//        }
//    }
//
//    for (int i = 0; i < n; i++) {
//        for (int j = 0; j < m; j++) {
//            if (matrix1[i][j] != matrix2[i][j]) {
//                printf("No\n");
//                return 0;
//            }
//        }
//    }
//    printf("Yes\n");
//
//    return 0;
//}

#include<stdio.h>
int main()
{
	printf("****\n*\n*\n****");
	return 0;
}