//将数组A中的内容和数组B中的内容进行交换
//方法一
#include <stdio.h>
int main()
{
    int arr1[10] = { 0,1,2,3,4,5,6,7,8,9 };
    int arr2[10] = { 11,12,13,14,15,16,17,18,19,20 };
    int tmp[10] = { 0 };
    for (int i = 0; i < 10; i++)
    {
        tmp[i] = arr1[i];
    }
    for (int i = 0; i < 10; i++)
    {
        arr1[i] = arr2[i];
    }
    for (int i = 0; i < 10; i++)
    {
        arr2[i] = tmp[i];
    }
    for (int i = 0; i < 10; i++)
    {
        printf(" %d", arr1[i]);
    }
    for (int i = 0; i < 10; i++)
    {
        printf(" %d", arr2[i]);
    }
    return 0;
}
//int Swarp(int arr1[], int arr2[])
//{
//    
//}

//#include<stdio.h>
//#include<string.h>
//int main()
//{
//	int arr[10] = {1,2,3,4,5,6,7,8,9,10};
//	int sz = sizeof(arr) / sizeof(arr[0]);
//	reverse(arr,sz);
//	print(arr);
//	init(arr);
//	print(arr);
//	return 0;
//}
//int init(int arr[])
//{
//	for (int i = 0; i < 10; i++)
//	{
//		arr[i] = 0;
//	}
//	return arr;
//}
//
//int print(const int arr[])
//{
//	for (int i = 0; i < 10; i++)
//	{
//		printf("%d ", arr[i]);
//	}
//	printf("\n");
//}
//
//int reverse(int arr[],int n)
//{
//	int tmp = 0;
//	for (int i = 0; i <n/2; i++)
//	{
//		tmp = arr[i];
//		arr[i] = arr[n - i-1];
//		arr[n - i-1] = tmp;
//	}
//
//}
