#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
////写一个qsort的练习，排序结构体
//
////测试qsort，排序结构体数据
//struct Stu
//{
//	char name[20];
//	int age;
//};
//int cmp_stu_by_age(const void*p1,const void* p2)
//{
//	return ((struct Stu*)p1)->age - ((struct Stu*)p2)->age;
//}
//int cmp_stu_by_name(const void* p1, const void* p2)
//{
//	return strcmp(((struct Stu*)p1)->name,((struct Stu*)p2)->name);
//}
//void test2()
//{
//	struct Stu s[] = { {"zhangsan",20}, {"lisi",21},{"wangwu",30} };
//	int sz = sizeof(s) / sizeof(s[0]);
//	qsort(s,sz,sizeof(s[0]), cmp_stu_by_age);
//}
//
//
//int main()
//{
//	int arr[10] = { 9,8,7,6,5,3,4,2,8 };
//	test2();
//	return 0;
//}


////排序整数
//int compare(const void *p1, const void*p2)
//{
//	return	*(int*)p1-*(int*)p2;
//}
//int main() {
//	int arr[] = { 0,1,4,7,8,5,4,1,8,6,9 };
//	int sz = sizeof(arr) / sizeof(arr[0]);
//	qsort(arr, sz, sizeof(arr[0]), compare);
//	for (int i = 0; i < sz; i++) {
//		printf("%d ", arr[i]);
//	}
//	return 0;
//}

////浮点数排序
//int compare(const void *p1, const void*p2)
//{
//	return	*(float*)p1-*(float*)p2;
//}
//int main() {
//	float arr[] = {1.1,1.2,6.6,8.8,9.1 };
//	int sz = sizeof(arr) / sizeof(arr[0]);
//	qsort(arr, sz, sizeof(arr[0]), compare);
//	for (int i = 0; i < sz; i++) {
//		printf("%0.2f ", arr[i]);
//	}
//	return 0;
//}

////字符串排序
//#include <stdio.h>
//#include <stdlib.h>
//#include <string.h>
//
//#include <stdio.h>
//#include <stdlib.h>
//#include <string.h>
//
//int compare(const void* p1, const void* p2)
//{
//	return strcmp(*(const char**)p1, *(const char**)p2);
//}
//
//int main() {
//	const char* arr[] = { "GO", "C", "python", "java" };
//	int sz = sizeof(arr) / sizeof(arr[0]);
//	qsort(arr, sz, sizeof(arr[0]), compare);
//	for (int i = 0; i < sz; i++)
//	{
//		printf("%s ", arr[i]);
//	}
//	return 0;
//}


////模拟一个排序
//#include<stdio.h>
//void Swap(char* buf1, char* buf2, int width)
//{
//	char tmp = *buf1;
//	*buf1 = *buf2;
//	*buf2 = tmp;
//	buf1++;
//	buf2++;
//}
//
//int cmp_int(const void* p1, const void* p2)
//{
//	return (*(int*)p1 - *(int*)p2);
//}
//void print_arr(int arr[], int sz)
//{
//	for (int i = 0; i < sz; i++) {
//		printf("%d ", arr[i]);
//	}
//	printf("\n");
//}
//void bubble_sort(void* base, size_t num, size_t width, int (*cmp)(const void* p1, const void* p2))
//{
//	//确定冒泡排序的次数
//	for (int i = 0; i < num - 1; i++) {
//		//一次冒泡排序的过程
//		for (int j = 0; j < num - 1; j++) {
//			//两个相邻元素进行比较
//			if (cmp((char*)base + j * width, (char*)base + (j + 1) * width) > 0) {
//				Swap((char*)base + j * width, (char*)base + (j + 1) * width, width);
//			}
//		}
//	}
//}
//void test()
//{
//	int arr[] = { 1,2,4,5,7,8,9,6,3 };
//	int sz = sizeof(arr) / sizeof(arr[0]);
//	bubble_sort(arr, sz, sizeof(arr[0]),cmp_int);
//	print_arr(arr, sz);  
//}
//int main()
//{
//	test();
//	return 0;
//}

int main()
{
	int aa[2][5] = { 10,9,8,7,6,5,4,3,2,1 };
	int* ptr1 = (int*)(&aa + 1);
	int* ptr2 = (int*)(*(aa + 1));
	printf("%d,%d", *(ptr1 - 1), *(ptr2 - 1));
	return 0;
}