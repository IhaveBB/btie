#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<time.h>
#include<stdlib.h>
void GuassNumber(const int number);
int MakeNumber(void);

#define MIN_NUMBER 0
#define MAX_NUMBER 100

int main()
{
    int number;
    char reply;
    srand(time(NULL));

    number = MakeNumber();
    GuassNumber(number);

    return 0;
}
void GuassNumber(const int number)
{
    int a = 1;//定义初始循环变量
    do {
        int b = 10 - a;//剩余猜的次数
        int guess = 0;
        scanf("%d", &guess);
        if (IsValidNum(guess)) {
            IsRight(guess, number);
            printf("剩余%d次机会\n", b);
        }
        else {
            printf("输入的数字不在规定范围内，请重新输入\n");
            scanf("%d", &guess);
            IsRight(guess, number);
            a = a + 1;//变量自增
        }
    } while (a <= 10);
}
int MakeNumber()
{
    int number;
    number = (rand() % (MAX_NUMBER - MIN_NUMBER + 1)) + MIN_NUMBER;
    return number;
}
int IsValidNum(const int number)
{
    if (number >= MIN_NUMBER && number <= MAX_NUMBER)
        return 1;
    else
        return 0;
}
int IsRight(const int number, const int guess)
{
    if (guess < number)
    {
        printf("Wrong! Too small!\n");
        return 0;
    }
    if (guess > number)
    {
        printf("Wrong! Too big!\n");
        return 0;
    }
    if (guess == number)
    {
        printf("Guess Right!\n");
        return 1;
    }
    return -1;
}