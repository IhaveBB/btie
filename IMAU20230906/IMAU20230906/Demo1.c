#define _CRT_SECURE_NO_WARNINGS
#define MIN_NUMBER 1
#define MAX_NUMBER 500
#include<stdio.h>
#include<time.h>
#include<stdlib.h>

void GuessNumber();
int MakeNumber();
int IsRight(const int number, const int guess);

int main() {


    GuessNumber();
    return 0;
}

void GuessNumber() {

    int number = MakeNumber();
    int count = 0;
    int index = 0;
    while (1) {
        int guess = 0;
        printf("���������Ϊ%d����С��Ϊ%d\n", MAX_NUMBER, MIN_NUMBER);
        scanf("%d", &guess);
        int index = IsRight(number, guess);
        count++;
        if (count == 10) {
            printf("�����10�Σ������Ѿ����£�����������\n");
            number = MakeNumber();
            count = 0;
        }
        else if (index == 1) {
            printf("��ϲ����%d����ˣ��˳��밴-1\n", count);
            number = MakeNumber();
            count = 0;
        }
        else if (guess == -1) {
            break;
        }
    }
}

int MakeNumber() {

    srand(time(NULL));
    int  number = (rand() % (MAX_NUMBER - MIN_NUMBER + 1)) + MIN_NUMBER;
    printf("�������%d", number);
    return number;
}

int IsRight(const int number, const int guess) {
    int index = 0;
    if (guess<MIN_NUMBER || guess>MAX_NUMBER) {
        printf("���뷶ΧΪ%d~%d\n", MIN_NUMBER, MAX_NUMBER);
    }
    if (guess < number) {
        printf("����С��\n");

    }
    else if (guess > number) {
        printf("���ִ���\n");

    }
    else if (guess == number) {
        printf("�����\n");
        index = 1;
        return  index;
    }
}
