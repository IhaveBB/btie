#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#define MaxSize 10 // 假设图中最多顶点个数

// 全局数组变量visited初始化
int visited[MaxSize] = { 0 };

// 图中顶点的数据类型，假设为char型
typedef char DataType;

// 定义邻接矩阵存储结构
typedef struct
{
    DataType vertex[MaxSize];     // 存放顶点的一维数组
    int edge[MaxSize][MaxSize];   // 存放边的二维数组
    int vertexNum, edgeNum;       // 图的顶点数和边数
} MGraph;

// 创建图
void CreatGraph(MGraph* G, DataType a[], int n, int e)
{
    int i, j, k;
    G->vertexNum = n;
    G->edgeNum = e;

    // 存储顶点信息
    for (i = 0; i < G->vertexNum; i++)
        G->vertex[i] = a[i];

    // 初始化邻接矩阵
    for (i = 0; i < G->vertexNum; i++)
        for (j = 0; j < G->vertexNum; j++)
            G->edge[i][j] = 0;

    // 依次输入每一条边
    for (k = 0; k < G->edgeNum; k++)
    {
        printf("输入边依附的顶点编号:");
        scanf("%d%d", &i, &j); // 输入边依附的顶点编号
        G->edge[i][j] = 1;
        G->edge[j][i] = 1; // 置有边标志
    }
}

// 深度优先遍历
void DFTraverse(MGraph* G, int v)
{
    int j;
    printf("%c ", G->vertex[v]);
    visited[v] = 1;
    for (j = 0; j < G->vertexNum; j++)
        if (G->edge[v][j] == 1 && visited[j] == 0)
            DFTraverse(G, j);
}

// 广度优先遍历
void BFTraverse(MGraph* G, int v)
{
    int i, j, Q[MaxSize]; // 采用顺序队列，存储顶点编号
    int front = -1;
    int rear = -1; // 初始化顺序队列
    printf("%c ", G->vertex[v]);
    visited[v] = 1;
    Q[++rear] = v;
    while (front != rear) // 当队列非空时
    {
        i = Q[++front]; // 将队头元素出队并送到v中
        for (j = 0; j < G->vertexNum; j++)
            if (G->edge[i][j] == 1 && visited[j] == 0)
            {
                printf("%c ", G->vertex[j]);
                visited[j] = 1;
                Q[++rear] = j;
            }
    }
}

// 打印无向图的邻接矩阵
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
    printf("输入无向图的顶点数\n");
    scanf("%d", &vertex);

    int number = 0;
    printf("输入无向图的边数\n");
    scanf("%d", &number);

    int i;
    char ch[MaxSize];

    printf("请输入顶点信息");
    for (int i = 0; i < vertex; i++)
    {
        scanf(" %c", &ch[i]); // 注意%c前的空格
    }

    MGraph MG;
    CreatGraph(&MG, ch, vertex, number);

    // 重置visited数组
    for (i = 0; i < MaxSize; i++)
        visited[i] = 0;

    printf("无向图的邻接矩阵为\n");
    PrintAdjacencyMatrix(&MG);

    // 重置visited数组
    for (i = 0; i < MaxSize; i++)
        visited[i] = 0;

    printf("深度优先遍历序列是：\n");
    DFTraverse(&MG, 0); // 从顶点0出发进行深度优先遍历

    // 重置visited数组
    for (i = 0; i < MaxSize; i++)
        visited[i] = 0;

    printf("广度优先遍历序列是：\n");
    BFTraverse(&MG, 0); // 从顶点0出发进行广度优先遍历

    return 0;
}

