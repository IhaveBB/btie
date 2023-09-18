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
		printf("�޷�����˳���");

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
		printf("����ʧ��");
		return 0;
	}
	else {
		*ptr = L->data[i - 1]; return 1;
	}

}
int Insert(SeqList* L, int i, DataType X)
{
	if (L->length >= MaxSize) { printf("����ʧ��"); return 0; }
	if (i<1 || i>L->length + 1) {
		printf("����ʧ��"); return 0;
	}
	for (int j = L->length; j >= i; j--)
		L->data[j] = L->data[j - 1];
	L->data[i - 1] = X;
	L->length++;
	return 1;
}
int delete(SeqList* L, int i, DataType* ptr) {
	if (L->length == 0) {
		prtinf("ɾ��ʧ��"); return 0;
	}
	if (i<1 || i>L->length) {
		prtinf("ɾ��ʧ��"); return 0;
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
	printf("��ǰ���Ա������Ϊ");
	PrintList(&L);
	Insert(&L, 2, 8);
	printf("��ǰ���Ա������Ϊ");
	PrintList(&L);
	printf("��ǰ���Ա������Ϊ%d", Length(&L));
	printf("��������ҵ�Ԫ��ֵ");
	scanf("%d", &x);
	i = Locate(&L, x);
	if (0 == i)printf("����ʧ��");
	else printf("Ԫ��%d��λ��Ϊ%d", x, i);
	printf("��������ҵڼ���Ԫ��ֵ");
	scanf("%d", &i);
	if (Get(&L, i, &x) == 1)printf("��%d��Ԫ��ֵ��%d", i, x);
	else printf("���Ա�û�е�%dԪ��", i);
	printf("������Ҫɾ���ĵڼ���Ԫ��");
}