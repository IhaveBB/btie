#define _CRT_SECURE_NO_WARNINGS
////实现一个函数，可以左旋字符串中的k个字符。
//#include<stdio.h>
//#include<string.h>
//int main()
//{
//	char arr[] = "ABCDEFG";
//	int len = strlen(arr);
//	int n = 0, tmp = 1;
//	scanf("%d", &n);//左旋几位
//	for (int i = n - 1; i >= 0; i--)
//	{
//		tmp = arr[len - 1];//暂存最后一个数
//		for (int j = len - 1; j > 0; j--)
//		{
//			arr[j] = arr[j - 1];//
//		}
//		arr[0] = tmp;//最后一个数挪到第一个
//	}
//	printf("%s\n", arr);
//
//	return 0;
//}
// 
//杨氏矩阵查找数字
//#include<stdio.h>
//int main()
//{
//	int a[4][4] = { {1,5,7,9},{4,6,10,15},{8,11,12,19},{14,16,18,21} };
//	int i = 0;//行数
//	int j = 3;//每一行的位数
//	int key = 14;//需要查找的元素
//	while (i < 4 && j >= 0)
//	{
//		if (key > a[i][j])
//		{
//			i++;
//		}
//		else if (key < a[i][j])
//		{
//			j--;
//		}
//		else
//		{
//			 printf("找到了，该元素在第 %d 行第 %d 列。\n", i+1, j+1);
//            return 0;  // 找到元素后直接结束程序
//		}
//	}
//	printf("没找到");
//	return 0;
//}
