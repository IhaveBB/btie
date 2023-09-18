#define _CRT_SECURE_NO_WARNINGS
#define MAXSIZE 100
#include <stdio.h>

typedef struct SeqList {
    int data[MAXSIZE];
    int length;
};

// 初始化顺序表
void InitList(SeqList* l) {
    l->length = 0;
}

/* 建立顺序表 */
int CreateList(SeqList* l, int a[], int n) {
    // 初始化顺序表
    InitList(l);
    // 检测是否超出长度限制
    if (n > MAXSIZE) {
        printf("无法建立顺序表，超出空间限制\n");
        return 0;
    }
    // 将数组元素移到顺序表中
    for (int i = 0; i < n; i++) {
        l->data[i] = a[i];
    }
    // 修正顺序表长度
    l->length = n;
    return 1;
}

// 判断是否为空
int isEmpty(SeqList* l) {
    return (l->length == 0);
}

// 按值查找
int Locate(SeqList* l, int x) {
    // 顺序表为空或无效，直接返回-1表示未找到
    if (l == NULL || l->length <= 0) {
        return -1;
    }

    for (int i = 0; i < l->length; i++) {
        if (l->data[i] == x) {
            return i; // 找到元素，返回位置
        }
    }
    // 遍历后未找到元素
    return -1;
}

// 按位查找
int Get(SeqList* l, int index, int* ptr) {
    if (index < 0 || index >= l->length) {
        printf("位置非法\n");
        return 0;
    }
    *ptr = l->data[index];
    return 1;
}

// 插入
int Insert(SeqList* l, int index, int n) {
    if (l->length >= MAXSIZE) {
        printf("顺序表已满\n");
        return 0;
    }

    if (index < 0 || index > l->length) {
        printf("插入位置错误！\n");
        return 0;
    }
    for (int i = l->length; i > index; i--) {
        l->data[i] = l->data[i - 1];
    }
    l->data[index] = n;
    l->length++;
    return 1;
}
//删除
int Delete(SeqList* l, int index) {
    if (index < 0 || index >= l->length) {
        printf("位置非法\n");
        return 0;
    }
    if (l->length == 0)
    {
        printf("发生下溢错误,顺序表为空\n");
        return 0;
    }
    for (int i = index; i < l->length - 1; i++) {
        l->data[i] = l->data[i + 1];
    }
    l->length--;
    return 1;
}

int main() {
    SeqList myList; // 声明一个顺序表变量
    int arr[] = { 10, 20, 30, 40, 50 };
    int n = sizeof(arr) / sizeof(arr[0]);

    // 初始化顺序表
    InitList(&myList);

    // 创建顺序表
    if (CreateList(&myList, arr, n)) {
        printf("顺序表创建成功！\n");
    }
    else {
        printf("顺序表创建失败！\n");
        return 1;
    }

    // 判断是否为空
    if (isEmpty(&myList)) {
        printf("顺序表为空\n");
    }
    else {
        printf("顺序表不为空\n");
    }

    // 按值查找元素
    int searchValue = 30;
    int position = Locate(&myList, searchValue);
    if (position != -1) {
        printf("元素 %d 在位置 %d\n", searchValue, position);
    }
    else {
        printf("元素 %d 未找到\n", searchValue);
    }

    // 按位查找元素
    int getIndex = 2;
    int getValue;
    if (Get(&myList, getIndex, &getValue)) {
        printf("位置 %d 上的元素是 %d\n", getIndex, getValue);
    }
    else {
        printf("位置 %d 非法\n", getIndex);
    }

    // 插入元素
    int insertIndex = 2;
    int insertValue = 25;
    if (Insert(&myList, insertIndex, insertValue)) {
        printf("在位置 %d 插入元素 %d 成功\n", insertIndex, insertValue);
    }
    else {
        printf("在位置 %d 插入元素 %d 失败\n", insertIndex, insertValue);
    }

    // 删除元素
    int deleteIndex = 3;
    if (Delete(&myList, deleteIndex)) {
        printf("删除位置 %d 的元素成功\n", deleteIndex);
    }
    else {
        printf("删除位置 %d 的元素失败\n", deleteIndex);
    }

    return 0;
}
