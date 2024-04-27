#define  _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

struct tm {
    int tm_year;
    int tm_mon;
    int tm_mday;
};

struct Product {
    char name[50];
    struct tm productionDate;
};

struct MyStack {
    void* stackArray;
    int maxSize;
    int top;
};

void push(struct MyStack* stack, struct Product* item) {
    if (stack->top < stack->maxSize - 1) {
        stack->top++;
        ((struct Product*)stack->stackArray)[stack->top] = *item;
    }
    else {
        printf("Stack is full. Cannot push %s\n", item->name);
    }
}

int isEmpty(struct MyStack* stack) {
    return stack->top == -1;
}

struct Product pop(struct MyStack* stack) {
    struct Product nullProduct = { "", {0, 0, 0} };
    if (isEmpty(stack)) {
        return nullProduct;
    }
    else {
        return ((struct Product*)stack->stackArray)[stack->top--];
    }
}

struct Product peek(struct MyStack* stack) {
    struct Product nullProduct = { "", {0, 0, 0} };
    if (isEmpty(stack)) {
        return nullProduct;
    }
    else {
        return ((struct Product*)stack->stackArray)[stack->top];
    }
}

int getTop(struct MyStack* stack) {
    return stack->top + 1;
}

int main() {
    struct MyStack shelf;
    shelf.maxSize = 100;
    shelf.stackArray = malloc(shelf.maxSize * sizeof(struct Product));
    shelf.top = -1;

    printf("商品数量为：0\n");

    while (1) {
        printf("请输入新增加的商品名称 (输入'exit'退出)\n");
        char name[50];
        scanf("%s", name);
        if (strcmp(name, "exit") == 0) {
            break;
        }
        printf("请输入新增加商品的生产日期年 月 日\n");
        int year, month, day;
        scanf("%d %d %d", &year, &month, &day);

        struct Product product = { .productionDate = {year, month, day} };
        strcpy(product.name, name);

        push(&shelf, &product);

        printf("商品数量为:%d\n", getTop(&shelf));
    }

    while (getTop(&shelf) > 0) {
        struct Product soldProduct = pop(&shelf);
        printf("%s %d-%d-%d\n", soldProduct.name, soldProduct.productionDate.tm_year, soldProduct.productionDate.tm_mon, soldProduct.productionDate.tm_mday);
    }

    free(shelf.stackArray);
    return 0;
}