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
        printf("输入最大数为%d，最小数为%d\n", MAX_NUMBER, MIN_NUMBER);
        scanf("%d", &guess);
        int index = IsRight(number, guess);
        count++;
        if (count == 10) {
            printf("你猜了10次，数据已经更新，请重新输入\n");
            number = MakeNumber();
            count = 0;
        }
        else if (index == 1) {
            printf("恭喜你用%d答对了，退出请按-1\n", count);
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
    printf("随机数：%d", number);
    return number;
}

int IsRight(const int number, const int guess) {
    int index = 0;
    if (guess<MIN_NUMBER || guess>MAX_NUMBER) {
        printf("输入范围为%d~%d\n", MIN_NUMBER, MAX_NUMBER);
    }
    if (guess < number) {
        printf("数字小了\n");

    }
    else if (guess > number) {
        printf("数字大了\n");

    }
    else if (guess == number) {
        printf("答对了\n");
        index = 1;
        return  index;
    }
}
