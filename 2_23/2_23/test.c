#define _CRT_SECURE_NO_WARNINGS 
//#include<stdio.h>
//#include<string.h>
//
////A A B C D 
////A B C D A
////0 1 2 3 4
//int left_move(char arr1[], char arr2[])
//{
//	int len = strlen(arr1);
//	char* pc = arr1;
//	int tmp = arr1[0];
//	for (int i = 0; i < len; i++)
//	{
//		for (int k = 0; k < len - 1; k++)
//		{
//			arr1[k] = arr1[k + 1];//往前面挪一位，空出最后一个位置。
//		}
//		arr1[len - 1] = tmp;//把第一个挪到最后一个
//		if (strcmp(arr1, arr2) == 0)
//			return 1;
//	}
//	return 0;
//
//
//}
//int main()
//{
//	char s1[] = "AABCD";
//	char s2[] = "BCDAA";
//	left_move(s1, s2);
//
//	return 0;
//
//}


#include<stdio.h>
#include<string.h>
#include <stdlib.h>
int move(char arr1[],char arr2[])
{
	int len = strlen(arr1);
	char* arr3 = (char*)malloc((len+len+1) *sizeof(char));
	strcpy(arr3, arr1);
	strcat(arr3, arr1);
	int ret = strstr(arr3, arr2);
	free(arr3);
	if (ret == NULL) {
		return 0;
	}
	else
		return 1;
}
int main() {
	char s1[] = "AABCD";
	char s2[] = "BCDAA";
	int ret = move(s1, s2);
	if (ret == 1) {
		printf("1\n");
	}
	else {
		printf("0");
	}
	return 0;
}