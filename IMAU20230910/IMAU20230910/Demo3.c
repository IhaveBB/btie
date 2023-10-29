#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdio.h>
#include <stdlib.h>

// 定义结构体类型
struct MyStruct
{
    int* arr;
    int length;
};

// 插入函数
void insert(struct MyStruct* arrStruct, int index, int value)
{
    if (index > arrStruct->length || index < 0)
    {
        printf("索引无效\n");
        return;
    }

    // 将数组中的元素后移，保证不会把原内容覆盖
    if (index < arrStruct->length)
    {
        for (int i = arrStruct->length; i > index; i--)
        {
            arrStruct->arr[i] = arrStruct->arr[i - 1];
        }
    }

    // 在指定位置插入新值
    arrStruct->arr[index] = value;
    (arrStruct->length)++;
}

// 删除函数
void delete (struct MyStruct* arrStruct, int index)
{
    if (index >= arrStruct->length || index < 0)
    {
        printf("索引无效\n");
        return;
    }

    for (int i = index; i < arrStruct->length - 1; i++)
    {
        arrStruct->arr[i] = arrStruct->arr[i + 1];
    }

    (arrStruct->length)--;
}

int main()
{
    struct MyStruct arrStruct;
    int option = 0;
    int index = 0;
    int val = 0;

    /*printf("请输入数组元素个数: ");
    scanf("%d", &arrStruct.length);*/

    arrStruct.length = 5;

    // 动态分配内存
    arrStruct.arr = (int*)malloc(arrStruct.length * sizeof(int));

    printf("请输入%d个整数作为数组元素，用空格分隔：\n", arrStruct.length);
    for (int i = 0; i < arrStruct.length; i++)
    {
        scanf("%d", &arrStruct.arr[i]);
    }

    // 输出输入的内容
    printf("当前数组内容：");
    for (int i = 0; i < arrStruct.length; i++)
    {
        printf("%d ", arrStruct.arr[i]);
    }
    printf("\n");

    printf("1. 插入元素\n2. 删除元素\n3. 退出\n");
    while (1)
    {
        printf("请输入您要选择的操作 ");
        scanf("%d", &option);

        if (option == 1)
        {
            printf("请输入要插入的位置和值（位置从0开始）： ");
            scanf("%d %d", &index, &val);
            insert(&arrStruct, index, val);

            printf("插入后的数组内容：");
            for (int i = 0; i < arrStruct.length; i++)
            {
                printf("%d ", arrStruct.arr[i]);
            }
            printf("\n");
        }
        else if (option == 2)
        {
            printf("请输入要删除的位置（位置从0开始）： ");
            scanf("%d", &index);
            delete(&arrStruct, index);

            printf("删除后的数组内容：");
            for (int i = 0; i < arrStruct.length; i++)
            {
                printf("%d ", arrStruct.arr[i]);
            }
            printf("\n");
        }
        else if (option == 3)
        {
            free(arrStruct.arr); // 释放动态分配的内存
            printf("退出程序\n");
            break;
        }
        else
        {
            printf("输入错误\n");
        }
    }

    return 0;
}
