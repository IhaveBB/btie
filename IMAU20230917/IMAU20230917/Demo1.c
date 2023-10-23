#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>  // 为了使用 memcmp 函数

#define Maxsize 100

typedef struct {
    int year;
    int month;
    int day;
} Date;

typedef struct {
    int number;
    Date date;
} DataType;

typedef struct {
    DataType numbers[Maxsize];
    int top;
} Node;

int GetTop(Node* N, DataType* ptr) {
    if (N->top == -1) {
        printf("下溢错误\n");
        return 0;
    }
    *ptr = N->numbers[N->top];
    return 1;
}

void InitNode(Node* N) {
    N->top = -1;
}

int Push(Node* N, DataType x) {
    if (N->top == Maxsize - 1) {
        printf("上溢错误\n");
        return 0;
    }
    N->numbers[++(N->top)] = x;
    return 1;
}

int Empty(Node* N) {
    return N->top == -1;
}

int main() {
    Node N;
    DataType x;
    DataType y;
    char input[9];
    int num;
    InitNode(&N);

    printf("请输入入栈的个数: ");
    scanf("%d", &num);

    if (num <= 0 || num > Maxsize) {
        printf("错误的输入数量\n");
        return 1;
    }

    for (int i = 0; i < num; i++) {
        printf("请输入入栈的数字（格式：YYYYMMDD）: ");
        scanf("%s", input);

        int year, month, day;
        if (sscanf(input, "%4d%2d%2d", &year, &month, &day) != 3) {
            printf("错误的输入日期\n");
            return 1;
        }

        x.date.year = year;
        x.date.month = month;
        x.date.day = day;

        Push(&N, x);

        // 排序栈N
        for (int j = N.top; j > 0; j--) {
            if (memcmp(&N.numbers[j].date, &N.numbers[j - 1].date, sizeof(Date)) < 0) {
                // 交换元素
                DataType temp = N.numbers[j];
                N.numbers[j] = N.numbers[j - 1];
                N.numbers[j - 1] = temp;
            }
        }
    }

    printf("请输入要进入商架里的新数字（格式：YYYYMMDD）: ");
    scanf("%s", input);

    int newYear, newMonth, newDay;
    if (sscanf(input, "%4d%2d%2d", &newYear, &newMonth, &newDay) != 3) {
        printf("错误的输入日期\n");
        return 1;
    }

    y.date.year = newYear;
    y.date.month = newMonth;
    y.date.day = newDay;

    // 将y插入商架，并保持商架有序
    int i = N.top;
    while (i >= 0 && memcmp(&y.date, &N.numbers[i].date, sizeof(Date)) > 0) {
        N.numbers[i + 1] = N.numbers[i];
        i--;
    }
    N.numbers[i + 1] = y;
    N.top++;

    printf("现在商架里的日期是：\n");
    for (int j = N.top; j >= 0; j--) {
        printf("%d-%d-%d\n", N.numbers[j].date.year, N.numbers[j].date.month, N.numbers[j].date.day);
    }

    if (Empty(&N) == 1) {
        printf("现在表内为空\n");
    }
    else {
        printf("现在表有东西\n");
    }

    return 0;
}
