#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<string.h>
////��ϰʹ��strtok
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


//��ϰʹ��strerror
//#include<errno.h>
//int main()
//{
//	FILE* pf = fopen("test.txt", "r");
//	//����򿪷�ʽΪ��r"�����ļ�������򿪳ɹ����ļ����������ʧ�ܡ�
//	//��ֻ����ʽ��test.txt�ļ�
//	//��ʧ�ܷ��ؿ�ָ�롣
//	if (pf == NULL)
//	{
//		printf("���ļ�ʧ��%s", strerror(errno));
//		return 1;
//	}
//	fclose(pf);
//	pf = NULL;
//	return 0;
//}


//����memcpyy����
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


////ʵ��my_memcpy����
//#include<stdio.h>
//#include<assert.h>
////memcpy�������ص���Ŀ��ռ����ʼ��ַ
//void* my_memcpy(void* dest, const void* src, size_t num)
//{
//	void* ret = dest;
//	assert(dest && src);
//	while (num--)
//	{
//		*(char*)dest = *(char*)src;
//		dest = (char*)dest + 1;
//		src = (char*)src + 1;
////���ｨ��ʹ������ķ����Ƚϰ�ȫ��
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




////����memmove����
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



////ģ��ʵ��memmove����
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

////��ϰmemcmp����
//int main()
//{
//	int arr1[] = { 1,2,3,8,5 };
//	int arr2[] = { 1,2,3,8,5 };
//	int ret = memcmp(arr1, arr2, 20);
//	printf("%d", ret);
//	return 0;
//

//��ϰmemset
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
