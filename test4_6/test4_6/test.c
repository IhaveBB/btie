#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
//单独提取并放入数组
int main() {
	int n = 0;
	int count = 0;
	scanf("%d", &n);
	int temp = n;
	while (temp != 0) {
		temp = temp / 10;
		count++;
	}
	int arr[] = {10};
	//求出字符长度
	for (int i = 0; i < count-1; i++) {
		int x = n % 10;
		n = n / 10;
		arr[i] = n;
	}
	for (int i = 0; i < count; i++) {
		printf("%d", arr[i]);
	}


	return 0;
}