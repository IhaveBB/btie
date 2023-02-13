//#pragma warning(disable:4996)
////调整数组使奇数全部都位于偶数前面。
//#include<stdio.h>
//#include<string.h>
//
//int main()
//{
//    int len = 0, i = 0, j = 0;
//    int arr1[50] = { 0 };
//    int arr2[50] = { 0 };
//    for (i = 0; i < 100; i++) {
//        scanf("%d", &arr1[i]);
//        if (getchar() == '\n')
//            break;
//    }
//    len = sizeof(arr1) / sizeof(arr1[0]);
//    memmove(arr2, arr1, sizeof(arr1));
//    for (i = 0; i < len; i++)
//    {
//        if (arr1[i] % 2 == 1)
//        {
//            j++;
//            arr1[j] = arr1[i];
//        }
//    }
//
//    for (i = len - 1; i >= 0; i--)
//    {
//        if (arr2[i] % 2 == 0)
//        {
//            j++;
//            arr1[j] = arr2[i];
//        }
//    }
//
//    for (i = 0; i < len; i++) {
//        printf("%d ", arr1[i]);
//    }
//
//    return 0;
//}
//
//
////模拟库函数strcpy
//#include <stdio.h>
//char my_strcpy(char* a, const char* str)
//{
//    while ((*a++ = *str++) != '\0');
//    return a;
//}
//
//int main()
//{
//    char a[100];
//    char str[] = "ABCDEFGHIGKLMN";
//    my_strcpy(a, str);
//    printf("copy string: %s\n", a);
//    return 0;
//}
//
//
////模拟库函数strlen
//#include<stdio.h>
//
//char my_strlen(char* str)
//{
//	unsigned long length=0;
//	while (*str != '\0') {
//		str++;
//		length++;
//	}
//	return length;
//}
//int main()
//{
//	char str[] = "Life is short and art is long.";
//	printf("%d", my_strlen(str));
//	return 0;
//}
//
