//#define _CRT_SECURE_NO_WARNINGS
//#include<stdio.h>
///*
//要求：编写程序利用函数的方式，实现输入2个数，按照从小到大的顺序输出（40分）。
//至少由三个函数实现，main()，sort()，swap()
//*/
//void sort(int* num1, int* num2);
//void swap(int* num1, int* num2);
//int main() {
//	int num1, num2;
//	if (scanf("%d %d", &num1, &num2) != 2) {
//		printf("输入错误，必须输入两个整数。\n");
//		return 1; 
//	}
//	printf("调整前%d %d\n", num1, num2);
//	sort(&num1, &num2);
//	printf("调整后%d %d", num1, num2);
//}
//void sort(int *num1,int *num2) {
//	//从小到大输出
//	if (*num1 > *num2) {
//		//不能传&num1和&num2
//		//because递指向整数的指针，而不是传递指向指针的指针
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