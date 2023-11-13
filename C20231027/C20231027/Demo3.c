#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#define MaxSize 10 // ����ͼ����ඥ�����

// ȫ���������visited��ʼ��
int visited[MaxSize] = { 0 };

// ͼ�ж�����������ͣ�����Ϊchar��
typedef char DataType;

// �����ڽӾ���洢�ṹ
typedef struct
{
    DataType vertex[MaxSize];     // ��Ŷ����һά����
    int edge[MaxSize][MaxSize];   // ��űߵĶ�ά����
    int vertexNum, edgeNum;       // ͼ�Ķ������ͱ���
} MGraph;

// ����ͼ
void CreatGraph(MGraph* G, DataType a[], int n, int e)
{
    int i, j, k;
    G->vertexNum = n;
    G->edgeNum = e;

    // �洢������Ϣ
    for (i = 0; i < G->vertexNum; i++)
        G->vertex[i] = a[i];

    // ��ʼ���ڽӾ���
    for (i = 0; i < G->vertexNum; i++)
        for (j = 0; j < G->vertexNum; j++)
            G->edge[i][j] = 0;

    // ��������ÿһ����
    for (k = 0; k < G->edgeNum; k++)
    {
        printf("����������Ķ�����:");
        scanf("%d%d", &i, &j); // ����������Ķ�����
        G->edge[i][j] = 1;
        G->edge[j][i] = 1; // ���б߱�־
    }
}

// ������ȱ���
void DFTraverse(MGraph* G, int v)
{
    int j;
    printf("%c ", G->vertex[v]);
    visited[v] = 1;
    for (j = 0; j < G->vertexNum; j++)
        if (G->edge[v][j] == 1 && visited[j] == 0)
            DFTraverse(G, j);
}

// ������ȱ���
void BFTraverse(MGraph* G, int v)
{
    int i, j, Q[MaxSize]; // ����˳����У��洢������
    int front = -1;
    int rear = -1; // ��ʼ��˳�����
    printf("%c ", G->vertex[v]);
    visited[v] = 1;
    Q[++rear] = v;
    while (front != rear) // �����зǿ�ʱ
    {
        i = Q[++front]; // ����ͷԪ�س��Ӳ��͵�v��
        for (j = 0; j < G->vertexNum; j++)
            if (G->edge[i][j] == 1 && visited[j] == 0)
            {
                printf("%c ", G->vertex[j]);
                visited[j] = 1;
                Q[++rear] = j;
            }
    }
}

// ��ӡ����ͼ���ڽӾ���
void PrintAdjacencyMatrix(MGraph* G)
{
    for (int i = 0; i < G->vertexNum; i++)
    {
        for (int j = 0; j < G->vertexNum; j++)
        {
            if (G->edge[i][j] == 1)
                printf("1");
            else
            {
                printf("0");
            }
        }
        printf("\n");
    }
}

int main()
{
    int vertex = 0;
    printf("��������ͼ�Ķ�����\n");
    scanf("%d", &vertex);

    int number = 0;
    printf("��������ͼ�ı���\n");
    scanf("%d", &number);

    int i;
    char ch[MaxSize];

    printf("�����붥����Ϣ");
    for (int i = 0; i < vertex; i++)
    {
        scanf(" %c", &ch[i]); // ע��%cǰ�Ŀո�
    }

    MGraph MG;
    CreatGraph(&MG, ch, vertex, number);

    // ����visited����
    for (i = 0; i < MaxSize; i++)
        visited[i] = 0;

    printf("����ͼ���ڽӾ���Ϊ\n");
    PrintAdjacencyMatrix(&MG);

    // ����visited����
    for (i = 0; i < MaxSize; i++)
        visited[i] = 0;

    printf("������ȱ��������ǣ�\n");
    DFTraverse(&MG, 0); // �Ӷ���0��������������ȱ���

    // ����visited����
    for (i = 0; i < MaxSize; i++)
        visited[i] = 0;

    printf("������ȱ��������ǣ�\n");
    BFTraverse(&MG, 0); // �Ӷ���0�������й�����ȱ���

    return 0;
}

