#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

#define QueueSize 100 // 定义数组的最大长度

typedef struct { // 定义客户信息的结构体
    int num; // 客户号
} People;

typedef int DataType; // 定义队列元素的数据类型，假设为 int 型

typedef struct {
    DataType data[QueueSize]; // 存放队列元素的数组
    int front, rear; // 下标，队头元素的队尾元素的位置
} CirQueue; // 循环队列

// 循环队列的初始化
void InitQueue(CirQueue* Q) {
    Q->front = Q->rear = 0;
}

// 入队操作
int EnQueue(CirQueue* Q, DataType x) {
    if ((Q->rear + 1) % QueueSize == Q->front) {
        printf("队已满，入队失败\n");
        return 0;
    }
    Q->rear = (Q->rear + 1) % QueueSize; // 队尾位置在循环意义下加一
    Q->data[Q->rear] = x; // 在队尾处插入元素 x
    return 1;
}

// 出队操作
int DeQueue(CirQueue* Q, DataType* ptr) {
    if (Q->rear == Q->front) {
        printf("队为空，删除失败\n");
        return 0;
    }
    Q->front = (Q->front + 1) % QueueSize; // 队头位置在循环意义下加1
    *ptr = Q->data[Q->front]; // 读取出队前的队头元素
    return 1;
}

// 获取队列长度
int getQueuelength(CirQueue Q) {
    return (Q.rear - Q.front + QueueSize) % QueueSize;
}

// 取队头元素
int GetHead(CirQueue* Q, DataType* ptr) {
    if (Q->rear == Q->front) {
        printf("队为空，取队头元素失败\n");
        return 0;
    }
    int i = (Q->front + 1) % QueueSize; // 注意不改变队头位置
    *ptr = Q->data[i];
    return 1;
}

// 判空操作
int Empty(CirQueue* Q) {
    if (Q->rear == Q->front) {
        return 1;
    }
    else {
        return 0;
    }
}

// 循环队列的使用
int main1() {
    DataType x;
    CirQueue Q; // 定义结构体变量 Q 为循环队列类型
    InitQueue(&Q); // 初始化循环队列 Q
    int i, n;
    printf("现在银行的客户数量为:\n");
    scanf("%d", &n);
    for (i = 1; i <= n; i++) {
        People p;
        p.num = i;
        EnQueue(&Q, p.num); // 将客户一次列入队列
        printf("当前客户号:%d", "客户等待数为:%d\n", i, getQueuelength(Q));
    }
    while (getQueuelength(Q) > 0) {
        DataType customer;
        DeQueue(&Q, &customer);
        printf("请%d号客户到窗口办理，现有%d个人等待\n", customer, getQueuelength(Q));
    }
    printf("所有客户都已办理完毕!");
}