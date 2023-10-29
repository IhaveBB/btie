#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

#define QueueSize 100 // �����������󳤶�

typedef struct { // ����ͻ���Ϣ�Ľṹ��
    int num; // �ͻ���
} People;

typedef int DataType; // �������Ԫ�ص��������ͣ�����Ϊ int ��

typedef struct {
    DataType data[QueueSize]; // ��Ŷ���Ԫ�ص�����
    int front, rear; // �±꣬��ͷԪ�صĶ�βԪ�ص�λ��
} CirQueue; // ѭ������

// ѭ�����еĳ�ʼ��
void InitQueue(CirQueue* Q) {
    Q->front = Q->rear = 0;
}

// ��Ӳ���
int EnQueue(CirQueue* Q, DataType x) {
    if ((Q->rear + 1) % QueueSize == Q->front) {
        printf("�����������ʧ��\n");
        return 0;
    }
    Q->rear = (Q->rear + 1) % QueueSize; // ��βλ����ѭ�������¼�һ
    Q->data[Q->rear] = x; // �ڶ�β������Ԫ�� x
    return 1;
}

// ���Ӳ���
int DeQueue(CirQueue* Q, DataType* ptr) {
    if (Q->rear == Q->front) {
        printf("��Ϊ�գ�ɾ��ʧ��\n");
        return 0;
    }
    Q->front = (Q->front + 1) % QueueSize; // ��ͷλ����ѭ�������¼�1
    *ptr = Q->data[Q->front]; // ��ȡ����ǰ�Ķ�ͷԪ��
    return 1;
}

// ��ȡ���г���
int getQueuelength(CirQueue Q) {
    return (Q.rear - Q.front + QueueSize) % QueueSize;
}

// ȡ��ͷԪ��
int GetHead(CirQueue* Q, DataType* ptr) {
    if (Q->rear == Q->front) {
        printf("��Ϊ�գ�ȡ��ͷԪ��ʧ��\n");
        return 0;
    }
    int i = (Q->front + 1) % QueueSize; // ע�ⲻ�ı��ͷλ��
    *ptr = Q->data[i];
    return 1;
}

// �пղ���
int Empty(CirQueue* Q) {
    if (Q->rear == Q->front) {
        return 1;
    }
    else {
        return 0;
    }
}

// ѭ�����е�ʹ��
int main1() {
    DataType x;
    CirQueue Q; // ����ṹ����� Q Ϊѭ����������
    InitQueue(&Q); // ��ʼ��ѭ������ Q
    int i, n;
    printf("�������еĿͻ�����Ϊ:\n");
    scanf("%d", &n);
    for (i = 1; i <= n; i++) {
        People p;
        p.num = i;
        EnQueue(&Q, p.num); // ���ͻ�һ���������
        printf("��ǰ�ͻ���:%d", "�ͻ��ȴ���Ϊ:%d\n", i, getQueuelength(Q));
    }
    while (getQueuelength(Q) > 0) {
        DataType customer;
        DeQueue(&Q, &customer);
        printf("��%d�ſͻ������ڰ�������%d���˵ȴ�\n", customer, getQueuelength(Q));
    }
    printf("���пͻ����Ѱ������!");
}