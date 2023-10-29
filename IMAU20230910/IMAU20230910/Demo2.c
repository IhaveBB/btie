#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
void insert1(int arr[], int* size, int index, int value) {
	if (index > *size || index < 0) {
		printf("索引无效\n");
		return;
	}
	if (*size <= 0) {
		printf("数组长度错误");
		return;
	}
	//将数组中的元素后移,保证不会把原内容覆盖
	if (index < *size) {
		for (int i = *size; i > index; i--) {
			arr[i] = arr[i - 1];
		}
	}
	//其他情况直接在指定位置插入新值
	arr[index] = value;
	(*size)++;
}
void delete1(int arr[], int* size, int index) {
	if (index > *size || index < 0) {
		printf("索引无效\n");
		return;
	}
	if (*size <= 0) {
		printf("数组长度错误");
		return;
	}
	for (int i = index; i < *size - 1; i++) {
		arr[i] = arr[i + 1];
	}
	(*size)--;

}

int main2() {
	int arr[100];
	int size = 0;
	int option = 0;
	int index = 0;
	int val = 0;
	printf("请输入数组元素个数: ");
	scanf("%d", &size);
	
	printf("请输入%d个整数作为数组元素，用空格分隔：\n", size);
	for (int i = 0; i < size; i++) {
		scanf("%d", &arr[i]);
	}

	//输出输入的内容
	printf("当前数组内容：");
	for (int i = 0; i < size; i++) {
		printf("%d ", arr[i]);
	}
	printf("\n");

	printf("1. 插入元素\n2. 删除元素\n3. 退出\n");
	while (1) {
		printf("请输入您要选择的操作 ");
		scanf("%d", &option);
		
		if(option == 1){
			printf("请输入要插入的位置和值（位置从0开始）： ");
			scanf("%d %d", &index, &val);
			insert(arr, &size, index, val);

			printf("插入后的数组内容：");
			for (int i = 0; i < size; i++) {
				printf("%d ", arr[i]);
			}
		}
		else if (option == 2) {
			int index;
			printf("请输入要删除的位置（位置从0开始）： ");
			scanf("%d", &index);
			delete(arr, &size, index);

			printf("删除后的数组内容：");
			for (int i = 0; i < size; i++) {
				printf("%d ", arr[i]);
			}
			printf("\n");
		}
		else if (option == 3) {
			printf("退出程序\n");
			break;
		}
		else {
			printf("输入错误）\n");
		}
	}
}