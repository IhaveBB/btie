#define _CRT_SECURE_NO_WARNINGS
#define MaxSize 100
#include<stdio.h>
#include<stdlib.h>
typedef int DataType;
typedef struct {
	DataType data[MaxSize];
	int length;
} SeqList;

void InitList(SeqList* L) {
	L->length = 0;
}
int CreateList(SeqList* L, DataType a[], int n) {
	if (n > MaxSize) {
		printf("无法建立顺序表");

		return 0;
	}
	for (int i = 0; i < n; i++) {
		L->data[i] = a[i];
		L->length = n;
		return 1;
	}
}
int Empty(SeqList* L) {
	if (L->length == 0)return 1;
	else return 0;
}
int Length(SeqList* L) {
	return L->length;
}
void PrintList(SeqList* L) {
	for (int i = 0; i < L->length; i++)
		printf("%d", L->data[i]);
}
int Locate(SeqList* L, DataType x) {
	for (int i = 0; i < L->length; i++) {
		if (L->data[i] == x)
			return i + 1;
		return 0;
	}
}
int Get(SeqList* L, int i, DataType* ptr) {
	if (i<1 || i>L->length) {
		printf("查找失败");
		return 0;
	}
	else {
		*ptr = L->data[i - 1]; return 1;
	}

}
int Insert(SeqList* L, int i, DataType X)
{
	if (L->length >= MaxSize) { printf("插入失败"); return 0; }
	if (i<1 || i>L->length + 1) {
		printf("插入失败"); return 0;
	}
	for (int j = L->length; j >= i; j--)
		L->data[j] = L->data[j - 1];
	L->data[i - 1] = X;
	L->length++;
	return 1;
}
int delete(SeqList* L, int i, DataType* ptr) {
	if (L->length == 0) {
		prtinf("删除失败"); return 0;
	}
	if (i<1 || i>L->length) {
		prtinf("删除失败"); return 0;
	}
	*ptr = L->data[i - 1];
	for (int j = i; j < L->length; j++)
		L->data[j - 1] = L->data[j];
	L->length--;
	return 1;
}
int main() {
	int r[5] = { 1,2,3,4,5 }, i, x;
	SeqList L;
	Creat(&L, r, 5);
	printf("当前线性表的数据为");
	PrintList(&L);
	Insert(&L, 2, 8);
	printf("当前线性表的数据为");
	PrintList(&L);
	printf("当前线性表的数据为%d", Length(&L));
	printf("请输入查找的元素值");
	scanf("%d", &x);
	i = Locate(&L, x);
	if (0 == i)printf("查找失败");
	else printf("元素%d的位置为%d", x, i);
	printf("请输入查找第几个元素值");
	scanf("%d", &i);
	if (Get(&L, i, &x) == 1)printf("第%d个元素值是%d", i, x);
	else printf("线性表没有第%d元素", i);
	printf("请输入要删除的第几个元素");
}