//#define _CRT_SECURE_NO_WARNINGS
//#include<stdio.h>
///*
//Ҫ�󣺱�д�������ú����ķ�ʽ��ʵ������2���������մ�С�����˳�������40�֣���
//��������������ʵ�֣�main()��sort()��swap()
//*/
//void sort(int* num1, int* num2);
//void swap(int* num1, int* num2);
//int main() {
//	int num1, num2;
//	if (scanf("%d %d", &num1, &num2) != 2) {
//		printf("������󣬱�����������������\n");
//		return 1; 
//	}
//	printf("����ǰ%d %d\n", num1, num2);
//	sort(&num1, &num2);
//	printf("������%d %d", num1, num2);
//}
//void sort(int *num1,int *num2) {
//	//��С�������
//	if (*num1 > *num2) {
//		//���ܴ�&num1��&num2
//		//because��ָ��������ָ�룬�����Ǵ���ָ��ָ���ָ��
//		swap(num1, num2);
//	}
//}
//
//void swap(int *num1,int *num2) {
//	int tmp = 0;
//	tmp = *num1;
//	*num1 = *num2;
//	*num2 = tmp;
//}