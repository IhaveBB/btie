	#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

#define MaxSize 10

// ȫ���������visited��ʼ��
int visited[MaxSize] = { 0 };

// ͼ�ж�����������ͣ�����Ϊchar��
typedef char DataType;

// �ߵĽṹ��
typedef struct
{
    int start;  // �ߵ����
    int end;    // �ߵ��յ�
    int weight; // �ߵ�Ȩֵ
} Edge;

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

// Prim�㷨������С������
void Prim(MGraph* G, int start)
{
    int lowCost[MaxSize];  // �洢����ѡ���㼯�ϵ���С��Ȩֵ
    int minIndex;          // �洢��СȨֵ�������ӵĶ�����

    // ��ʼ��lowCost����
    for (int i = 0; i < G->vertexNum; i++)
    {
        lowCost[i] = G->edge[start][i];
    }

    visited[start] = 1;  // ����ʼ���������ѡ���㼯��

    printf("\nPrim�㷨���ɵ���С�������߼���Ϊ��\n");

    for (int i = 1; i < G->vertexNum; i++)
    {
        int min = INT_MAX;

        // ѡ����СȨֵ��
        for (int j = 0; j < G->vertexNum; j++)
        {
            if (lowCost[j] < min && visited[j] == 0)
            {
                min = lowCost[j];
                minIndex = j;
            }
        }

        visited[minIndex] = 1;  // ����СȨֵ�����ӵĶ��������ѡ���㼯��

        printf("(%c, %c) ", G->vertex[start], G->vertex[minIndex]);

        // ����lowCost����
        for (int j = 0; j < G->vertexNum; j++)
        {
            if (G->edge[minIndex][j] < lowCost[j] && visited[j] == 0)
            {
                lowCost[j] = G->edge[minIndex][j];
            }
        }
    }
}

// ���Ҳ��鼯�ĸ��ڵ�
int findRoot(int parent[], int i)
{
    while (parent[i] != i)
    {
        i = parent[i];
    }
    return i;
}

// Kruskal�㷨������С������
void Kruskal(MGraph* G)
{
    Edge edges[MaxSize * MaxSize]; // �洢���бߵ�����
    int edgeCount = 0;

    // ��ͼ�ıߴ���edges����
    for (int i = 0; i < G->vertexNum; i++)
    {
        for (int j = i + 1; j < G->vertexNum; j++)
        {
            if (G->edge[i][j] != 0)
            {
                edges[edgeCount].start = i;
                edges[edgeCount].end = j;
                edges[edgeCount].weight = G->edge[i][j];
                edgeCount++;
            }
        }
    }

    // �Ա߰�Ȩֵ��������
    for (int i = 0; i < edgeCount - 1; i++)
    {
        for (int j = 0; j < edgeCount - i - 1; j++)
        {
            if (edges[j].weight > edges[j + 1].weight)
            {
                Edge temp = edges[j];
                edges[j] = edges[j + 1];
                edges[j + 1] = temp;
            }
        }
    }

    printf("\nKruskal�㷨���ɵ���С�������߼���Ϊ��\n");

    // ��ʼ�����鼯����
    int parent[MaxSize];
    for (int i = 0; i < G->vertexNum; i++)
    {
        parent[i] = i;
    }

    // �������б�
    for (int i = 0; i < edgeCount; i++)
    {
        int root1 = findRoot(parent, edges[i].start);
        int root2 = findRoot(parent, edges[i].end);

        // ����������㲻��ͬһ�����У�������С������
        if (root1 != root2)
        {
            printf("(%c, %c) ", G->vertex[edges[i].start], G->vertex[edges[i].end]);

            // �ϲ���������
            parent[root1] = root2;
        }
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
    printf("\n");
    printf("������ȱ��������ǣ�\n");
    BFTraverse(&MG, 0); // �Ӷ���0�������й�����ȱ���

    // ����visited����
    for (i = 0; i < MaxSize; i++)
        visited[i] = 0;

    // Prim�㷨������С������
    printf("\n");
    Prim(&MG, 0);

    // ����visited����
    for (i = 0; i < MaxSize; i++)
        visited[i] = 0;

    // Kruskal�㷨������С������
    printf("\n");
    Kruskal(&MG);

    return 0;
}
