#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdio.h>
#include <stdlib.h>

// ����ṹ������
struct MyStruct
{
    int* arr;
    int length;
};

// ���뺯��
void insert(struct MyStruct* arrStruct, int index, int value)
{
    if (index > arrStruct->length || index < 0)
    {
        printf("������Ч\n");
        return;
    }

    // �������е�Ԫ�غ��ƣ���֤�����ԭ���ݸ���
    if (index < arrStruct->length)
    {
        for (int i = arrStruct->length; i > index; i--)
        {
            arrStruct->arr[i] = arrStruct->arr[i - 1];
        }
    }

    // ��ָ��λ�ò�����ֵ
    arrStruct->arr[index] = value;
    (arrStruct->length)++;
}

// ɾ������
void delete (struct MyStruct* arrStruct, int index)
{
    if (index >= arrStruct->length || index < 0)
    {
        printf("������Ч\n");
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

    /*printf("����������Ԫ�ظ���: ");
    scanf("%d", &arrStruct.length);*/

    arrStruct.length = 5;

    // ��̬�����ڴ�
    arrStruct.arr = (int*)malloc(arrStruct.length * sizeof(int));

    printf("������%d��������Ϊ����Ԫ�أ��ÿո�ָ���\n", arrStruct.length);
    for (int i = 0; i < arrStruct.length; i++)
    {
        scanf("%d", &arrStruct.arr[i]);
    }

    // ������������
    printf("��ǰ�������ݣ�");
    for (int i = 0; i < arrStruct.length; i++)
    {
        printf("%d ", arrStruct.arr[i]);
    }
    printf("\n");

    printf("1. ����Ԫ��\n2. ɾ��Ԫ��\n3. �˳�\n");
    while (1)
    {
        printf("��������Ҫѡ��Ĳ��� ");
        scanf("%d", &option);

        if (option == 1)
        {
            printf("������Ҫ�����λ�ú�ֵ��λ�ô�0��ʼ���� ");
            scanf("%d %d", &index, &val);
            insert(&arrStruct, index, val);

            printf("�������������ݣ�");
            for (int i = 0; i < arrStruct.length; i++)
            {
                printf("%d ", arrStruct.arr[i]);
            }
            printf("\n");
        }
        else if (option == 2)
        {
            printf("������Ҫɾ����λ�ã�λ�ô�0��ʼ���� ");
            scanf("%d", &index);
            delete(&arrStruct, index);

            printf("ɾ������������ݣ�");
            for (int i = 0; i < arrStruct.length; i++)
            {
                printf("%d ", arrStruct.arr[i]);
            }
            printf("\n");
        }
        else if (option == 3)
        {
            free(arrStruct.arr); // �ͷŶ�̬������ڴ�
            printf("�˳�����\n");
            break;
        }
        else
        {
            printf("�������\n");
        }
    }

    return 0;
}
