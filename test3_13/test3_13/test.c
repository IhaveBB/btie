#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<string.h>
////练习使用strtok
//int main()
//{
//	char arr[] = "ihavebb@outlook.com";
//	char buf[30] = { 0 };
//	strcpy(buf, arr);   
//	const char* p = "@.";
//	char* str = NULL;
//	for (str = strtok(buf, p); str != NULL; str = strtok(NULL, p))
//	{
//		printf("%s\n",str);
//	}
//
//	return 0;
//}


//练习使用strerror
//#include<errno.h>
//int main()
//{
//	FILE* pf = fopen("test.txt", "r");
//	//如果打开方式为“r"，那文件存在则打开成功，文件不存在则打开失败。
//	//以只读方式打开test.txt文件
//	//打开失败返回空指针。
//	if (pf == NULL)
//	{
//		printf("打开文件失败%s", strerror(errno));
//		return 1;
//	}
//	fclose(pf);
//	pf = NULL;
//	return 0;
//}


//测试memcpyy函数
//#include<stdio.h>
//int main()
//{
//	int arr1[] = { 1,2,3,4,5,6,7,8,9,10 };
//	int arr2[10] = { 88 };
//	memcpy(arr2, arr1, 40); 
//	int len = sizeof(arr2) / sizeof(arr2[0]);
//	for (int i = 0; i < len; i++)
//	{
//		printf("%d ", arr2[i]);
//	}
//	return 0;
//}


////实现my_memcpy函数
//#include<stdio.h>
//#include<assert.h>
////memcpy函数返回的是目标空间的起始地址
//void* my_memcpy(void* dest, const void* src, size_t num)
//{
//	void* ret = dest;
//	assert(dest && src);
//	while (num--)
//	{
//		*(char*)dest = *(char*)src;
//		dest = (char*)dest + 1;
//		src = (char*)src + 1;
////这里建议使用上面的方法比较安全。
////		((char*)dest)++;
////;	    ((char*)src)++;
//	}
//
//	return ret;
//}
//
//int main()
//{
//	int arr1[] = { 1,2,3,4,5,6,7,8,9,10 };
//	int arr2[10] = { 88 };
//	my_memcpy(arr2, arr1, 40); 
//	int len = sizeof(arr2) / sizeof(arr2[0]);
//	for (int i = 0; i < len; i++)
//	{
//		printf("%d ", arr2[i]);
//	}
//	return 0;
//}




////测试memmove函数
//int main()
//{
//	int arr1[] = { 1,2,3,4,5,6,7,8,9,10 };
//	memove(arr1 + 2, arr1, 20);
//	int len = sizeof(arr1) / sizeof(arr1[0]);
//	for (int i = 0; i < 10; i++)
//	{
//		printf("%d ", arr1[i]);
//	}
//	return 0;
//}



////模拟实现memmove函数
//void* my_memmove(void* dest, const void* src, size_t num)
//{
//	void* ret = dest;
//	if (dest < src){
//		while (num--){
//			*(char*)dest = *(char*)src;
//			dest = (char*)dest + 1;
//			src = (char*)src + 1;
//		}
//	}
//	else{
//		while (num--){
//			*((char*)dest + num) = *((char*)src + num);
//		}
//	}
//	return ret;
// }
//
//#include<stdio.h>
//int main()
//{
//	int arr1[] = { 1,2,3,4,5,6,7,8,9,10 };
//	my_memmove(arr1 + 2, arr1, 20);
//	int len = sizeof(arr1) / sizeof(arr1[0]);
//	for (int i = 0; i < 10; i++){
//		printf("%d ", arr1[i]);
//	}
//	return 0;
//}

////练习memcmp函数
//int main()
//{
//	int arr1[] = { 1,2,3,8,5 };
//	int arr2[] = { 1,2,3,8,5 };
//	int ret = memcmp(arr1, arr2, 20);
//	printf("%d", ret);
//	return 0;
//

//练习memset
//#include<stdio.h>
//int main()
//{
//	int i=0;
//	int arr[10] = {0};
//	memset(arr,1,40);
//	for (int i = 0; i < 10; i++)
//	{
//		printf("%d ",arr[i]);
//	}
//	return 0;
//}
