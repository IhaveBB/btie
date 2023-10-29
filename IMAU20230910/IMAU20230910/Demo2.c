#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
void insert1(int arr[], int* size, int index, int value) {
	if (index > *size || index < 0) {
		printf("������Ч\n");
		return;
	}
	if (*size <= 0) {
		printf("���鳤�ȴ���");
		return;
	}
	//�������е�Ԫ�غ���,��֤�����ԭ���ݸ���
	if (index < *size) {
		for (int i = *size; i > index; i--) {
			arr[i] = arr[i - 1];
		}
	}
	//�������ֱ����ָ��λ�ò�����ֵ
	arr[index] = value;
	(*size)++;
}
void delete1(int arr[], int* size, int index) {
	if (index > *size || index < 0) {
		printf("������Ч\n");
		return;
	}
	if (*size <= 0) {
		printf("���鳤�ȴ���");
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
	printf("����������Ԫ�ظ���: ");
	scanf("%d", &size);
	
	printf("������%d��������Ϊ����Ԫ�أ��ÿո�ָ���\n", size);
	for (int i = 0; i < size; i++) {
		scanf("%d", &arr[i]);
	}

	//������������
	printf("��ǰ�������ݣ�");
	for (int i = 0; i < size; i++) {
		printf("%d ", arr[i]);
	}
	printf("\n");

	printf("1. ����Ԫ��\n2. ɾ��Ԫ��\n3. �˳�\n");
	while (1) {
		printf("��������Ҫѡ��Ĳ��� ");
		scanf("%d", &option);
		
		if(option == 1){
			printf("������Ҫ�����λ�ú�ֵ��λ�ô�0��ʼ���� ");
			scanf("%d %d", &index, &val);
			insert(arr, &size, index, val);

			printf("�������������ݣ�");
			for (int i = 0; i < size; i++) {
				printf("%d ", arr[i]);
			}
		}
		else if (option == 2) {
			int index;
			printf("������Ҫɾ����λ�ã�λ�ô�0��ʼ���� ");
			scanf("%d", &index);
			delete(arr, &size, index);

			printf("ɾ������������ݣ�");
			for (int i = 0; i < size; i++) {
				printf("%d ", arr[i]);
			}
			printf("\n");
		}
		else if (option == 3) {
			printf("�˳�����\n");
			break;
		}
		else {
			printf("�������\n");
		}
	}
}