#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<assert.h>
#include<string.h>
//////计数器实现strlen
//my_strlen(const char* str)
//{
//	int count = 0;
//	assert(str);
//	while(*str != '\0')
//	{
//		count++;
//		str++;
//	}
//	return count;
//}
//int main()
//{
//	char arr[] = "bite";
//	int len = my_strlen(arr);
//	printf("%d", len);
//	return 0;
//}


////使用递归实现strlen
//int my_strlen(const char *str)
//{
//	if (*str != '\0')
//		return 1 + my_strlen(str + 1);
//	else
//		return 0;
//}
//int main()
//{
//	char arr[] = "bite";
//	int len = my_strlen(arr);
//	printf("%d", len);
//	return 0;
//}




////模拟实现strcpy函数
//#include <stdio.h>
//#include <assert.h>
//char* my_mtrcpy(char* dest, const char* src)
//{
//    char* ret = dest;
//    assert(dest && src);
//    while (*src != '\0') {
//        *dest++ = *src++;
//    }
//    *dest = '\0';
//    return ret;
//}
//int main()
//{
//    char arr1[20] = "abcdef";
//    char arr2[7] = "";
//    printf("%s", my_mtrcpy(arr2, arr1));
//    return 0;
//}


////模拟实现strcat函数
//char* my_strcat(char* dest, const char * str)
//{
//	assert(dest && str);
//	char* ret = dest;
//	while(*dest != '\0')
//	{
//		dest++;
//	}
//	while(*dest++ = *str++)
//	{
//		;
//	}
//	return ret;
//
//}
//int main()
//{
//	char arr1[20] = "hello";
//	char arr2[] = "world";
//	printf("%s",my_strcat(arr1, arr2));
//	return 0;
//}


////模拟strcmp
//int my_strcmp(const char* str1, const char* str2)
//{
//	assert(str1 && str2);
//	while (*str1 == *str2)
//	{
//		if (*str1 == 0)
//		{
//			return 0;
//		}
//		str1++;
//		str2++;
//	}
//	return *str1 - *str2;
//	//标准只规定返回大于0小于0和0，并未规定是否返回-1,1,0。所以判断时，应该判断返回值是>0,<0还是等于0；
//	//if (*str1 > *str2)
//	//	return 1;
//	//else
//	//	return -1;
//
//
//}
//int main()
//{
//	char str1[] = "abcd";
//	char str2[] = "abcwddwdasd";
//	int ret = my_strcmp(str1, str2);
//	printf("%d",ret);
//	return 0;
//}


////模拟实现strstr函数
#include <stdio.h>
char* my_strstr(const char* str1, const char* str2)
{
    if (!str1 || !str2) {
        return NULL;
    }
    char* s1 = NULL;
    char* s2 = NULL;
    char* cp = (char*)str1;
    while (*cp)
    {
        s1 = cp;
        s2 = (char*)str2;
        while (*s1 && *s2 && *s1 == *s2)
        {
            s1++;
            s2++;
        }
        if (*s2 == '\0')
        {
            return cp;
        }
        cp++;
    }
    return NULL;
}

int main()
{
    char arr1[] = "abcdefg";
    char arr2[] = "bcd";
    printf("%s", my_strstr(arr1, arr2));
    return 0;
}
