#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>  // Ϊ��ʹ�� memcmp ����

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
        printf("�������\n");
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
        printf("�������\n");
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

    printf("��������ջ�ĸ���: ");
    scanf("%d", &num);

    if (num <= 0 || num > Maxsize) {
        printf("�������������\n");
        return 1;
    }

    for (int i = 0; i < num; i++) {
        printf("��������ջ�����֣���ʽ��YYYYMMDD��: ");
        scanf("%s", input);

        int year, month, day;
        if (sscanf(input, "%4d%2d%2d", &year, &month, &day) != 3) {
            printf("�������������\n");
            return 1;
        }

        x.date.year = year;
        x.date.month = month;
        x.date.day = day;

        Push(&N, x);

        // ����ջN
        for (int j = N.top; j > 0; j--) {
            if (memcmp(&N.numbers[j].date, &N.numbers[j - 1].date, sizeof(Date)) < 0) {
                // ����Ԫ��
                DataType temp = N.numbers[j];
                N.numbers[j] = N.numbers[j - 1];
                N.numbers[j - 1] = temp;
            }
        }
    }

    printf("������Ҫ�����̼���������֣���ʽ��YYYYMMDD��: ");
    scanf("%s", input);

    int newYear, newMonth, newDay;
    if (sscanf(input, "%4d%2d%2d", &newYear, &newMonth, &newDay) != 3) {
        printf("�������������\n");
        return 1;
    }

    y.date.year = newYear;
    y.date.month = newMonth;
    y.date.day = newDay;

    // ��y�����̼ܣ��������̼�����
    int i = N.top;
    while (i >= 0 && memcmp(&y.date, &N.numbers[i].date, sizeof(Date)) > 0) {
        N.numbers[i + 1] = N.numbers[i];
        i--;
    }
    N.numbers[i + 1] = y;
    N.top++;

    printf("�����̼���������ǣ�\n");
    for (int j = N.top; j >= 0; j--) {
        printf("%d-%d-%d\n", N.numbers[j].date.year, N.numbers[j].date.month, N.numbers[j].date.day);
    }

    if (Empty(&N) == 1) {
        printf("���ڱ���Ϊ��\n");
    }
    else {
        printf("���ڱ��ж���\n");
    }

    return 0;
}
