//#include<stdio.h>
//int main()
//{
//	int arr[10] = { 1,1,2,2,3,3,4,4,5,6 };
//	int len = sizeof(arr) / sizeof(arr[0]);
//	for (int i = 0; i < len; i++)
//	{
//		int sign = 0;
//		int tmp = arr[i];
//		for (int i = 0; i < len; i++)
//		{
//			if (tmp == arr[i])
//			{
//				sign++;
//			}
//		}
//		if (sign == 1)
//		{
//			printf("%d ", tmp);
//		}
//	}
//
//	return 0;
//}

#include<stdio.h>
#include<assert.h>
char* my_strcat(char*  dest,  char* src)
{
	assert(dest && src);
	char* ret = dest;
	while (*dest) {
		dest++;
	}

	while (*src) {
		*dest++ = *src++;
	}
	*dest = '\0';
	return ret;
}
int main()
{
	char str1[40] = "abcd";
	char str2[] = "efghijklmn";
	my_strcat(str1, str2);
	printf("%s", str1);
	return 0;
}