#define _CRT_SECURE_NO_WARNINGS
#define MAXSIZE 100
#include <stdio.h>

typedef struct SeqList {
    int data[MAXSIZE];
    int length;
};

// ��ʼ��˳���
void InitList(SeqList* l) {
    l->length = 0;
}

/* ����˳��� */
int CreateList(SeqList* l, int a[], int n) {
    // ��ʼ��˳���
    InitList(l);
    // ����Ƿ񳬳���������
    if (n > MAXSIZE) {
        printf("�޷�����˳��������ռ�����\n");
        return 0;
    }
    // ������Ԫ���Ƶ�˳�����
    for (int i = 0; i < n; i++) {
        l->data[i] = a[i];
    }
    // ����˳�����
    l->length = n;
    return 1;
}

// �ж��Ƿ�Ϊ��
int isEmpty(SeqList* l) {
    return (l->length == 0);
}

// ��ֵ����
int Locate(SeqList* l, int x) {
    // ˳���Ϊ�ջ���Ч��ֱ�ӷ���-1��ʾδ�ҵ�
    if (l == NULL || l->length <= 0) {
        return -1;
    }

    for (int i = 0; i < l->length; i++) {
        if (l->data[i] == x) {
            return i; // �ҵ�Ԫ�أ�����λ��
        }
    }
    // ������δ�ҵ�Ԫ��
    return -1;
}

// ��λ����
int Get(SeqList* l, int index, int* ptr) {
    if (index < 0 || index >= l->length) {
        printf("λ�÷Ƿ�\n");
        return 0;
    }
    *ptr = l->data[index];
    return 1;
}

// ����
int Insert(SeqList* l, int index, int n) {
    if (l->length >= MAXSIZE) {
        printf("˳�������\n");
        return 0;
    }

    if (index < 0 || index > l->length) {
        printf("����λ�ô���\n");
        return 0;
    }
    for (int i = l->length; i > index; i--) {
        l->data[i] = l->data[i - 1];
    }
    l->data[index] = n;
    l->length++;
    return 1;
}
//ɾ��
int Delete(SeqList* l, int index) {
    if (index < 0 || index >= l->length) {
        printf("λ�÷Ƿ�\n");
        return 0;
    }
    if (l->length == 0)
    {
        printf("�����������,˳���Ϊ��\n");
        return 0;
    }
    for (int i = index; i < l->length - 1; i++) {
        l->data[i] = l->data[i + 1];
    }
    l->length--;
    return 1;
}

int main() {
    SeqList myList; // ����һ��˳������
    int arr[] = { 10, 20, 30, 40, 50 };
    int n = sizeof(arr) / sizeof(arr[0]);

    // ��ʼ��˳���
    InitList(&myList);

    // ����˳���
    if (CreateList(&myList, arr, n)) {
        printf("˳������ɹ���\n");
    }
    else {
        printf("˳�����ʧ�ܣ�\n");
        return 1;
    }

    // �ж��Ƿ�Ϊ��
    if (isEmpty(&myList)) {
        printf("˳���Ϊ��\n");
    }
    else {
        printf("˳���Ϊ��\n");
    }

    // ��ֵ����Ԫ��
    int searchValue = 30;
    int position = Locate(&myList, searchValue);
    if (position != -1) {
        printf("Ԫ�� %d ��λ�� %d\n", searchValue, position);
    }
    else {
        printf("Ԫ�� %d δ�ҵ�\n", searchValue);
    }

    // ��λ����Ԫ��
    int getIndex = 2;
    int getValue;
    if (Get(&myList, getIndex, &getValue)) {
        printf("λ�� %d �ϵ�Ԫ���� %d\n", getIndex, getValue);
    }
    else {
        printf("λ�� %d �Ƿ�\n", getIndex);
    }

    // ����Ԫ��
    int insertIndex = 2;
    int insertValue = 25;
    if (Insert(&myList, insertIndex, insertValue)) {
        printf("��λ�� %d ����Ԫ�� %d �ɹ�\n", insertIndex, insertValue);
    }
    else {
        printf("��λ�� %d ����Ԫ�� %d ʧ��\n", insertIndex, insertValue);
    }

    // ɾ��Ԫ��
    int deleteIndex = 3;
    if (Delete(&myList, deleteIndex)) {
        printf("ɾ��λ�� %d ��Ԫ�سɹ�\n", deleteIndex);
    }
    else {
        printf("ɾ��λ�� %d ��Ԫ��ʧ��\n", deleteIndex);
    }

    return 0;
}
